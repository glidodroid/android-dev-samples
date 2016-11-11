package com.example.developer.android_dev_samples.eventbus;

import javax.security.auth.Subject;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/**
 * Created by Airbase on 08-Oct-16.
 */

public class RxEventBus {

    private final rx.subjects.Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());

    public void post(Object obj) {
        bus.onNext(obj);
    }

    public Observable<Object> getBusObservable() {
        return bus;
    }
}
