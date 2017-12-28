package com.example.developer.android_dev_samples.home;

import com.example.developer.android_dev_samples.base.BasePresenter;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by developer on 28/12/17.
 */

public class HomePresenterImpl<V extends HomeView> extends BasePresenter<V> implements HomePresenter<V> {

    @Inject
    public HomePresenterImpl() {

    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        loadHomeDetails();
    }

    @Override
    public void loadHomeDetails() {
        Timber.d("load details");
        getMvpView().showDetails();
    }
}
