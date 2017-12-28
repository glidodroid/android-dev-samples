package com.example.developer.android_dev_samples.home;

import com.example.developer.android_dev_samples.base.MvpPresenter;
import com.example.developer.android_dev_samples.base.MvpView;

/**
 * Created by developer on 28/12/17.
 */

public interface HomePresenter<V extends MvpView> extends MvpPresenter<V> {

    void loadHomeDetails();
}
