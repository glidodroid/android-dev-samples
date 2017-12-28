package com.example.developer.android_dev_samples.rxeventbus;

import android.util.Pair;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Airbase on 08-Oct-16.
 */

public class RxEventBus {

    private final Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());

    public void post(Pair<String, Object> obj) {
        bus.onNext(obj);
    }

    public Observable<Object> getBusObservable() {
        return bus;
    }
}
