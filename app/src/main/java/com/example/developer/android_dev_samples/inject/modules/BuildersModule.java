package com.example.developer.android_dev_samples.inject.modules;

import com.example.developer.android_dev_samples.home.HomeActivity;
import com.example.developer.android_dev_samples.home.HomeFragment;
import com.example.developer.android_dev_samples.home.HomeFragmentModule;
import com.example.developer.android_dev_samples.home.HomeModule;
import com.example.developer.android_dev_samples.inject.PerActivity;
import com.example.developer.android_dev_samples.inject.PerFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all subcomponents here.
 */

@Module
public abstract class BuildersModule {

    @PerActivity
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivityInjector();

    @PerFragment
    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment homeFragmentInjector();

    // can also access home module dependencies.
}
