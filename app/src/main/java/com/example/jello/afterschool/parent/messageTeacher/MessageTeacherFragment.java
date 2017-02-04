package com.example.jello.afterschool.parent.messageTeacher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.androidWrappers.DefaultFragment;

public class MessageTeacherFragment extends DefaultFragment<MessageTeacherPresenter, MessageTeacherView> {

    @Override
    protected MessageTeacherPresenter buildPresenter(Bundle savedInstanceState) {
        return new MessageTeacherPresenter();
    }

    @Override
    protected MessageTeacherView buildView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return new MessageTeacherView(getActivity(), inflater, viewGroup, savedInstanceState);
    }
}
