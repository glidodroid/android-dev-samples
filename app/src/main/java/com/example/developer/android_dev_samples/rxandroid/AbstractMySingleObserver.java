package com.example.developer.android_dev_samples.rxandroid;

import io.reactivex.observers.DisposableSingleObserver;


public abstract class AbstractMySingleObserver<T> extends DisposableSingleObserver<T> {

    @Override
    public final void onSuccess(T item) {
        try {
            success(item);
        } finally {
            dispose();
        }
    }

    @Override
    public final void onError(Throwable ex) {
        try {
            error(ex);
        } finally {
            dispose();
        }
    }

    protected abstract void success(T item);

    protected abstract void error(Throwable ex);

}
