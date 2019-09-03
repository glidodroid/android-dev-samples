package com.example.developer.android_dev_samples.home;

import com.example.developer.android_dev_samples.inject.PerChildFragment;
import com.example.developer.android_dev_samples.inject.PerFragment;

import dagger.Binds;
import dagger.Module;

/**
 * Created by developer on 28/12/17.
 */

@Module
public abstract class HomeFragmentModule {

    @PerChildFragment
    abstract HomeChildFragment homeChildFragmentInjector();

    @PerFragment
    @Binds
    abstract HomePresenter<HomeView> provideHomePresenter(HomePresenterImpl<HomeView> homePresenterImpl);
}
