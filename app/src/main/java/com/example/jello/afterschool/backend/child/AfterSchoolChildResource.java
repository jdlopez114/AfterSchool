package com.example.jello.afterschool.backend.child;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.backend.AfterSchoolApi;
import com.example.jello.afterschool.backend.parent.AfterSchoolParentResponse;
import com.example.jello.afterschool.dataStructures.ChildDetail;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.OnlineFirstResource;
import com.jsjrobotics.demeter.utils.FileUtils;
import com.jsjrobotics.demeter.utils.NetworkUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AfterSchoolChildResource extends OnlineFirstResource{

    private final String mFilename;
    private final String mUrlPath;
    private final Context mContext;
    private final ConnectivityManager mConnectivityManager;
    private final String mChildId;

    public AfterSchoolChildResource(Context context, String childId) {
        mChildId = childId;
        mFilename = context.getString(R.string.parent_child_filename);
        mUrlPath = context.getString(R.string.parent_child_url) + "?child="+mChildId;
        mContext = context;
        mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Override
    public String getFilename() {
        return mFilename;
    }

    @Override
    public String getUrl() {
        return mUrlPath;
    }

    @Override
    public void loadOnlineContent(final Receiver<Optional<DisplayableScreen>> listener) {
        if (NetworkUtils.isOnline(mConnectivityManager)) {
            new AfterSchoolApi(mContext).downloadChildDetail(mUrlPath, buildChildDetailScreenReceiver(listener));
        } else {
            listener.accept(Optional.empty());
        }
    }

    private Receiver<AfterSchoolChildResponse> buildChildDetailScreenReceiver(final Receiver<Optional<DisplayableScreen>> listener) {
        return response -> {
            if (response.getResults().isEmpty()) {
                listener.accept(Optional.empty());
                return;
            }
            Optional<DisplayableScreen> result = Optional.of(buildDisplayableScreen(response));
            listener.accept(result);
        };
    }

    private DisplayableScreen buildDisplayableScreen(AfterSchoolChildResponse response) {
        return new ChildDetail(mChildId, response);
    }

    public File getFile() {
        return new File(mContext.getFilesDir(), getFilename());
    }


    @Override
    public Optional<DisplayableScreen> loadOfflineContent() {
        File offline = getFile();
        if (!offline.exists()) {
            return Optional.empty();
        }
        Optional<String> offlineJson = FileUtils.readFile(getFile());
        if (offlineJson.isPresent()) {
            AfterSchoolChildResponse result = AfterSchoolChildResponse.parse(offlineJson.get());
            if (!result.getResults().isEmpty()) {
                return Optional.of(buildDisplayableScreen(result));
            }
        }
        return Optional.empty();
    }
}
