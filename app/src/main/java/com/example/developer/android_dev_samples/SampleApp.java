package com.example.developer.android_dev_samples;

import android.app.Activity;
import android.app.Application;
import android.support.multidex.MultiDex;

import com.example.developer.android_dev_samples.inject.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

/**
 * Sample app application class.
 */
public class SampleApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        Timber.plant(new Timber.DebugTree());
        DaggerAppComponent.builder().create(this).inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
