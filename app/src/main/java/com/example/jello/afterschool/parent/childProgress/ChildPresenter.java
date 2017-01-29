package com.example.jello.afterschool.parent.childProgress;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.jello.afterschool.dataStructures.TestResult;
import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.DefaultAppCompatLifecycleFragment;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Supplier;
import com.jsjrobotics.demeter.androidWrappers.LifeCyclePresenter;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.DisplayTransformer;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

import java.util.Collections;
import java.util.List;

public class ChildPresenter extends LifeCyclePresenter<ChildView> {
    public static final String ARGS_CHILD_ID = "child_presenter.child_id";
    private final Supplier<Fragment> mContext;
    private ChildModel mModel;
    private ChildView mView;
    private Optional<DisplayableScreen> mDisplayedScreen = Optional.empty();
    private final List<DisplayTransformer<? extends DisplayItem>> mTransformers;

    ChildPresenter(Supplier<Fragment> context, Bundle savedInstanceState) {
        mContext = context;
        mTransformers = Collections.singletonList(
                buildTestResultTransformer()
        );
    }

    private DisplayTransformer<TestResult> buildTestResultTransformer() {
        return new DisplayTransformer<TestResult>() {
            @Override
            public Class<TestResult> getTransformToType() {
                return TestResult.class;
            }

            @Override
            public void apply(TestResult item) {
                mView.addTestResult(item);
            }
        };
    }

    @Override
    public void onStart(ChildView view) {
        mView = view;
        if (!mDisplayedScreen.isPresent()) {
            mModel = new ChildModel(mContext.get().getContext());
            mModel.loadChildData(buildReceiver());
            this.mView.setLoading(true);
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
}
