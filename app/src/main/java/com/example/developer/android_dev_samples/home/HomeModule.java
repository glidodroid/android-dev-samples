package com.example.developer.android_dev_samples.home;

import com.example.developer.android_dev_samples.inject.PerFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by developer on 28/12/17.
 */

@Module
public abstract class HomeModule {

    @PerFragment
    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment homeFragmentInjector();
}
