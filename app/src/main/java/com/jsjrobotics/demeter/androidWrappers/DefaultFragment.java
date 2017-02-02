package com.jsjrobotics.demeter.androidWrappers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class DefaultFragment<Presenter extends LifeCyclePresenter<ViewClass> , ViewClass extends DefaultView> extends Fragment {
    protected ViewClass mView;
    protected Presenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = buildPresenter(savedInstanceState);
        mPresenter.onCreate(() -> this);
    }

    @Override
    public final void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public final void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public final void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    public final void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public final void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public final View onCreateView (LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        super.onCreateView(inflater,viewGroup,savedInstanceState);
        mView = buildView(inflater, viewGroup, savedInstanceState);
        return mView.getLayout();
    }

    @Override
    public void onViewStateRestored(final Bundle inState){
        super.onViewStateRestored(inState);
        mPresenter.onViewStateRestored(mView, inState);
    }

    protected abstract Presenter buildPresenter (Bundle savedInstanceState);

    protected abstract ViewClass buildView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState);

    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
        mView.saveInstanceState(outState);
    }
}
