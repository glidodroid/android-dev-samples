package com.example.developer.android_dev_samples.base;

import timber.log.Timber;

/**
 * Base class than implements presenter interface and provides base implementation for
 * any view being attached.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = BasePresenter.class.getSimpleName();

    private V mMvpView;

    @Override
    public void onAttach(V mvpView) {
        Timber.v("attach view");
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        Timber.d("detached %s", "detached");
        mMvpView = null;
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    private boolean isViewAttached() {
        return mMvpView != null;
    }

    protected V getMvpView() {
        return mMvpView;
    }

    /**
     * Checks whether mvp view is attached.
     */
    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    /**
     * Exception class which throw run time exception.
     */
    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before"
                    + " requesting data to the Presenter");
        }
    }
}

