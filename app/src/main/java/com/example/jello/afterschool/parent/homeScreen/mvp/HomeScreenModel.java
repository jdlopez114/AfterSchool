package com.example.jello.afterschool.parent.homeScreen.mvp;


import android.content.Context;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.DualSourceResource;
import com.example.jello.afterschool.backend.AfterSchoolResource;

class HomeScreenModel {

    private final AfterSchoolResource mResource;

    HomeScreenModel(final Context context){
        mResource = new AfterSchoolResource(context);
    }

    private static void loadContent(final DualSourceResource resource,
                                    final Receiver<Optional<DisplayableScreen>> listener) {
        Thread t = new Thread(() -> {
            resource.getContent(listener);
        });
        t.start();
    }

    void loadHomeScreen(Receiver<Optional<DisplayableScreen>> receiver) {
        loadContent(mResource, receiver);
    }
}
