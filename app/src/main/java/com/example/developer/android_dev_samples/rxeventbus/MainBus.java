package com.example.developer.android_dev_samples.rxeventbus;

/**
 * Created by Airbase on 08-Oct-16.
 */

public class MainBus extends RxEventBus {

    private static MainBus instance;

    public static MainBus getInstance() {
        if (instance==null) {
            instance =new MainBus();
        }
        return instance;
    }

    private MainBus() {

    }
}
