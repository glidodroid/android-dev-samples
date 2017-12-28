package com.example.developer.android_dev_samples.base;

import android.support.annotation.StringRes;

/**
 * Base interface that any view class must implement.
 */

public interface MvpView {

    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    void hideKeyboard();

    void showKeyboard();

    boolean isNetworkConnected();

}
