package com.example.developer.android_dev_samples;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import timber.log.Timber;

/**
 * Sample app application class.
 */
public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        Fresco.initialize(this);
    }
}
