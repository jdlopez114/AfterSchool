package com.example.jello.afterschool.parent.homeScreen.mvp;


import android.content.Context;

import com.example.jello.afterschool.DefaultModel;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.example.jello.afterschool.backend.parent.AfterSchoolParentResource;

class HomeScreenModel extends DefaultModel {

    private final AfterSchoolParentResource mResource;

    HomeScreenModel(final Context context){
        mResource = new AfterSchoolParentResource(context);
    }

    void loadHomeScreen(Receiver<Optional<DisplayableScreen>> receiver) {
        loadContent(mResource, receiver);
    }
}
