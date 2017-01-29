package com.example.jello.afterschool.backend.parent;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.Nullable;

import com.example.jello.afterschool.backend.AfterSchoolApi;
import com.example.jello.afterschool.dataStructures.ParentHomepage;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.example.jello.afterschool.R;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.OnlineFirstResource;
import com.jsjrobotics.demeter.utils.FileUtils;
import com.jsjrobotics.demeter.utils.NetworkUtils;

import java.io.File;

public class AfterSchoolParentResource extends OnlineFirstResource {
    private final Context mContext;
    private final String mFilename;
    private final String mUrlPath;
    private final ConnectivityManager mConnectivityManager;

    public AfterSchoolParentResource(Context context) {
        mFilename = context.getString(R.string.parent_homescreen_filename);
        mUrlPath = context.getString(R.string.parent_homescreen_url);
        mContext = context;
        mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }


    @Nullable
    @Override
    public void loadOnlineContent(final Receiver<Optional<DisplayableScreen>> listener) {
        if (NetworkUtils.isOnline(mConnectivityManager)) {
            new AfterSchoolApi(mContext).downloadParentHompage(mUrlPath, buildHomepageReceiver(listener));
        } else {
            listener.accept(Optional.empty());
        }
    }

    private Receiver<AfterSchoolParentResponse> buildHomepageReceiver(final Receiver<Optional<DisplayableScreen>> listener) {
        return response -> {
            if (response.getSuccess()) {
                FileUtils.writeToFile(getFile(), response.getJson());
                listener.accept(Optional.of(buildDisplayableScreen(response)));
                return;
            }
            listener.accept(Optional.empty());
        };
    }

    private DisplayableScreen buildDisplayableScreen(AfterSchoolParentResponse response) {
        return new ParentHomepage(response);
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
            AfterSchoolParentResponse result = AfterSchoolParentResponse.parse(offlineJson.get());
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
