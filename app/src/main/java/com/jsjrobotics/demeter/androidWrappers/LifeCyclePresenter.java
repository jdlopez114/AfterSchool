package com.jsjrobotics.demeter.androidWrappers;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Supplier;

public abstract class  LifeCyclePresenter<ViewClass> {
    public void onCreate(Supplier<Fragment> context){}
    public void onStart(ViewClass view){}
    public void onResume(){}
    public void onPause(){}
    public void onStop(){}
    public void onDestroy(){}

}
