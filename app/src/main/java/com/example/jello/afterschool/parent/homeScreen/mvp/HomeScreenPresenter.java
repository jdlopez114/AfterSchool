package com.example.jello.afterschool.parent.homeScreen.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.example.jello.afterschool.dataStructures.Child;
import com.example.jello.afterschool.parent.childProgress.ChildProgressActivity;
import com.example.jello.afterschool.parent.homeScreen.NavigationOption;
import com.example.jello.afterschool.parent.messageTeacher.MessageTeacherActivity;
import com.example.jello.afterschool.parent.searchPrograms.SearchForProgramsActivity;
import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.DefaultAppCompatLifecycleFragment;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Supplier;
import com.jsjrobotics.demeter.androidWrappers.DefaultView;
import com.jsjrobotics.demeter.androidWrappers.LifeCyclePresenter;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.DisplayTransformer;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

import java.util.Collections;
import java.util.List;

public class HomeScreenPresenter extends LifeCyclePresenter<HomeScreenView> {
    private final Supplier<Fragment> mContext;
    private final HomeScreenModel mHomeScreenModel;
    private final List<DisplayTransformer<? extends DisplayItem>> mTransformers;
    private HomeScreenView mView;
    private Optional<DisplayableScreen> mDisplayedScreen = Optional.empty();

    public HomeScreenPresenter(Supplier<Fragment> context, Bundle savedInstanceState) {
        mContext = context;
        mHomeScreenModel = new HomeScreenModel(mContext.get().getContext());
        mTransformers = Collections.singletonList(
                buildChildTransformer()
        );
    }

    private Receiver<NavigationOption> buildNavigationDrawerListener() {
        return option -> {
            switch (option) {
                case HOME:
                    break;
                case CHILD_PROGRESS:
                    launchActivity(ChildProgressActivity.class);
                    break;
                case SEARCH_FOR_PROGRAMS:
                    launchActivity(SearchForProgramsActivity.class);
                    break;
                case MESSAGE_TEACHER:
                    launchActivity(MessageTeacherActivity.class);
                    break;
                default:
                    throw new IllegalStateException("unhandled option");
            }
        };
    }

    private void launchActivity(Class<? extends AppCompatActivity> cls){
        FragmentActivity activity = mContext.get().getActivity();
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
    }

    @Override
    public void onStart(HomeScreenView view) {
        mView = view;
        mView.setNavigationDrawerListener(buildNavigationDrawerListener());
        if (!mDisplayedScreen.isPresent()) {
            this.mView.setLoading(true);
            mHomeScreenModel.loadHomeScreen(buildReceiver());
        }
    }

    private Receiver<Optional<DisplayableScreen>> buildReceiver() {
        return result -> {
            result.ifPresent( screen -> {
                    mDisplayedScreen = Optional.of(screen);
                    DefaultAppCompatLifecycleFragment.runOnUiThread(mContext.get(), () -> {
                        loadScreen(screen);
                    });
            });
        };
    }

    private void loadScreen(DisplayableScreen screen) {
        for (DisplayItem displayItem : screen.getContent()) {
            for (DisplayTransformer transformer : mTransformers){
                displayItem.transform(transformer);
            }
        }
        mView.setLoading(false);
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

}
