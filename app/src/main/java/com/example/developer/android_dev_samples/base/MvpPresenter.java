package com.example.developer.android_dev_samples.base;

/**
 * Every presenter in app should implement this interface or extend BasePresenter with mvp view type.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    //void handleApiError(ANError error);

    void setUserAsLoggedOut();

}
