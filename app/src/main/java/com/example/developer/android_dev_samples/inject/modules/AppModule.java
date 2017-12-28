package com.example.developer.android_dev_samples.inject.modules;

import android.app.Application;

import com.example.developer.android_dev_samples.SampleApp;
import com.example.developer.android_dev_samples.home.HomeActivity;
import com.example.developer.android_dev_samples.home.HomeModule;
import com.example.developer.android_dev_samples.inject.PerActivity;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by developer on 28/12/17.
 */

@Module(includes = AndroidInjectionModule.class)
public abstract class AppModule {

    abstract Application application(SampleApp app);

    @PerActivity
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivityInjector();
}
