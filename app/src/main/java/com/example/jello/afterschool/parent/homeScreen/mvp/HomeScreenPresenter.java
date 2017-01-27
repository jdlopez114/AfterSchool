package com.example.jello.afterschool.parent.homeScreen.mvp;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.jello.afterschool.dataStructures.Child;
import com.example.jello.afterschool.dataStructures.Classroom;
import com.example.jello.afterschool.dataStructures.Teacher;
import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.DefaultAppCompatLifecycleFragment;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Supplier;
import com.jsjrobotics.demeter.androidWrappers.LifeCyclePresenter;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.DisplayTransformer;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

import java.util.Arrays;
import java.util.List;

public class HomeScreenPresenter extends LifeCyclePresenter<HomeScreenView> {
    private final Supplier<Fragment> mContext;
    private final HomeScreenModel mHomeScreenModel;
    private final List<DisplayTransformer<? extends DisplayItem>> mTransformers;
    private HomeScreenView mView;

    public HomeScreenPresenter(Supplier<Fragment> context, Bundle savedInstanceState) {
        mContext = context;
        mHomeScreenModel = new HomeScreenModel(mContext.get().getContext());
        mTransformers = Arrays.asList(
                buildTeacherTransformer(),
                buildClassroomTransformer(),
                buildChildTransformer()
        );
    }

    @Override
    public void onViewStateRestored(HomeScreenView view, Bundle inState) {
        mView = view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {}

    @Override
    public void onResume() {
        mView.setLoading(true);
        mHomeScreenModel.loadHomeScreen(buildReceiver());
    }

    private Receiver<Optional<DisplayableScreen>> buildReceiver() {
        return result -> {
            result.ifPresent( screen ->
                    DefaultAppCompatLifecycleFragment.runOnUiThread(mContext.get(), () -> {
                        for (DisplayItem displayItem : screen.getContent()) {
                            for (DisplayTransformer transformer : mTransformers){
                                displayItem.transform(transformer);
                            }
                        }
                        mView.setLoading(false);
            }));
        };
    }

    private DisplayTransformer<Teacher> buildTeacherTransformer() {
        return new DisplayTransformer<Teacher>() {
            @Override
            public Class<Teacher> getTransformToType() {
                return Teacher.class;
            }

            @Override
            public void apply(Teacher item) {
                mView.addTeacher(item);
            }
        };
    }

    private DisplayTransformer<Child> buildChildTransformer() {
        return new DisplayTransformer<Child>() {
            @Override
            public Class<Child> getTransformToType() {
                return Child.class;
            }

            @Override
            public void apply(Child item) {
                mView.addChild(item);
            }
        };
    }

    private DisplayTransformer<Classroom> buildClassroomTransformer() {
        return new DisplayTransformer<Classroom>() {
            @Override
            public Class<Classroom> getTransformToType() {
                return Classroom.class;
            }

            @Override
            public void apply(Classroom item) {
                mView.addClassroom(item);
            }
        };
    }

}
