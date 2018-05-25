package com.example.developer.android_dev_samples.storage;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.framework.FrameworkSQLiteOpenHelperFactory;

import javax.inject.Inject;

/**
 * Created by developer on 9/1/18.
 */

public final class DbManager {

    private static final String DATABASE_NAME = "androidsamples.db";
    private static final int DATABASE_VERSION = 1;

    private Application application;
    private DbHelper dbHelper;
    private SupportSQLiteOpenHelper supportSQLiteOpenHelper;

    @Inject
    public DbManager(Application application) {
        this.application = application;
        initializeHelper();
    }

    private void initializeHelper() {
        supportSQLiteOpenHelper = new FrameworkSQLiteOpenHelperFactory()
                .create(SupportSQLiteOpenHelper.Configuration.builder(application)
                        .name(DATABASE_NAME)
                        .callback(new DbHelper(application, DATABASE_NAME, null, DATABASE_VERSION))
                        .build());
        //dbHelper = new DbHelper(application, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SupportSQLiteOpenHelper sqLiteOpenHelper() {
        return supportSQLiteOpenHelper;
    }
}
