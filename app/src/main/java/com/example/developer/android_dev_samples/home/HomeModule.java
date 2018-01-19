package com.example.developer.android_dev_samples.home;

import com.example.developer.android_dev_samples.inject.PerActivity;
import com.example.developer.android_dev_samples.inject.PerFragment;
import com.example.developer.android_dev_samples.storage.DbManager;
import com.example.developer.android_dev_samples.storage.PlayerManager;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by developer on 28/12/17.
 */

@Module
public abstract class HomeModule {

    @PerFragment
    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment homeFragmentInjector();

    @Provides
    @PerActivity
    static PlayerManager providePlayer(DbManager dbManager) {
        return new PlayerManager(dbManager);
    }
}
