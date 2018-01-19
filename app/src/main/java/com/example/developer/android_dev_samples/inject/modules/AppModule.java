package com.example.developer.android_dev_samples.inject.modules;

import android.app.Application;

import com.example.developer.android_dev_samples.SampleApp;
import com.example.developer.android_dev_samples.home.HomeActivity;
import com.example.developer.android_dev_samples.home.HomeModule;
import com.example.developer.android_dev_samples.inject.PerActivity;
import com.example.developer.android_dev_samples.storage.DbManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by developer on 28/12/17.
 */

@Module(includes = AndroidInjectionModule.class)
public abstract class AppModule {

    @Binds
    abstract Application application(SampleApp app);

    @Provides
    @Singleton
    static DbManager provideDbManager(Application application) {
        return new DbManager(application);
    }

    @PerActivity
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivityInjector();
}
