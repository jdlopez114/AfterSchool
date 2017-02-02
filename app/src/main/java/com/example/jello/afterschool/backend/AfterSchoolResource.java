package com.example.jello.afterschool.backend;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;

import com.example.jello.afterschool.dataStructures.Teacher;
import com.example.jello.afterschool.parent.homeScreen.AppContent;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.example.jello.afterschool.R;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.OnlineFirstResource;
import com.jsjrobotics.demeter.utils.FileUtils;

import java.io.File;
import java.util.List;

public class AfterSchoolResource extends OnlineFirstResource {
    private final Context mContext;
    private final String mFilename;
    private final String mUrlPath;
    private final ConnectivityManager mConnectivityManager;

    public AfterSchoolResource(Context context) {
        mFilename = context.getString(R.string.homescreen_filename);
        mUrlPath = context.getString(R.string.homescreen_url);
        mContext = context;
        mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }


    private boolean isOnline() {
        NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    @Nullable
    @Override
    public void loadOnlineContent(final Receiver<Optional<DisplayableScreen>> listener) {
        if (isOnline()) {
            new AfterSchoolApi(mContext).downloadData(mUrlPath, buildHomepageReceiver(listener));
        } else {
            listener.accept(Optional.empty());
        }
    }

    private Receiver<AfterSchoolResponse> buildHomepageReceiver(final Receiver<Optional<DisplayableScreen>> listener) {
        return response -> {
            if (response.getSuccess()) {
                FileUtils.writeToFile(getFile(), response.getJson());
                listener.accept(Optional.of(buildDisplayableScreen(response)));
                return;
            }
            listener.accept(Optional.empty());
        };
    }

    private DisplayableScreen buildDisplayableScreen(AfterSchoolResponse response) {
        return new AppContent(response);
    }

    @Nullable
    @Override
    public Optional<DisplayableScreen> loadOfflineContent() {
        File offline = getFile();
        if (!offline.exists()) {
            return Optional.empty();
        }
        Optional<String> offlineJson = FileUtils.readFile(getFile());
        if (offlineJson.isPresent()) {
            AfterSchoolResponse result = AfterSchoolResponse.parse(offlineJson.get());
            if (!result.getResult().isEmpty()) {
                return Optional.of(buildDisplayableScreen(result));
            }
        }
        return Optional.empty();
    }

    @Override
    public String getFilename() {
        return mFilename;
    }

    @Override
    public String getUrl() {
        return mUrlPath;
    }

    public File getFile() {
        return new File(mContext.getFilesDir(), getFilename());
    }
}
