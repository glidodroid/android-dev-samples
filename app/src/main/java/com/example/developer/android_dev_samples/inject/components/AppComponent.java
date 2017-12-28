package com.example.developer.android_dev_samples.inject.components;

import com.example.developer.android_dev_samples.SampleApp;
import com.example.developer.android_dev_samples.inject.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Created by developer on 28/12/17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent extends AndroidInjector<SampleApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<SampleApp> {
    }

}
