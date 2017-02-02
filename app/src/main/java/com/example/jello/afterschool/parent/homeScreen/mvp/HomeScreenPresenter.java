package com.example.jello.afterschool.parent.homeScreen.mvp;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.jello.afterschool.dataStructures.Teacher;
import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.DefaultAppCompatLifecycleFragment;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Supplier;
import com.jsjrobotics.demeter.androidWrappers.LifeCyclePresenter;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.DisplayTransformer;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

public class HomeScreenPresenter extends LifeCyclePresenter<HomeScreenView> {
    private final Supplier<Fragment> mContext;
    private final HomeScreenModel mHomeScreenModel;
    private HomeScreenView mView;

    public HomeScreenPresenter(Supplier<Fragment> context, Bundle savedInstanceState) {
        mContext = context;
        mHomeScreenModel = new HomeScreenModel(mContext.get().getContext());
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
                            displayItem.transform(buildHomeScreenTransformer());
                        }
                        mView.setLoading(false);
            }));
        };
    }

    private DisplayTransformer<Teacher> buildHomeScreenTransformer() {
        return new DisplayTransformer<Teacher>() {
            @Override
            public Class<Teacher> getTransformToType() {
                return Teacher.class;
            }

            @Override
            public void apply(Teacher item) {
                mView.addData(item);
            }
        };
    }


}
