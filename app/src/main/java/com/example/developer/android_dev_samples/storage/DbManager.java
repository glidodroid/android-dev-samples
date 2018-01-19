package com.example.developer.android_dev_samples.storage;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;

/**
 * Created by developer on 9/1/18.
 */

public final class DbManager {

    private static final String DATABASE_NAME = "androidsamples.db";
    private static final int DATABASE_VERSION = 1;

    private Application application;
    private DbHelper dbHelper;

    @Inject
    public DbManager(Application application) {
        this.application = application;
        initializeHelper();
    }

    private void initializeHelper() {
        dbHelper = new DbHelper(application, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteOpenHelper sqLiteOpenHelper() {
        return dbHelper;
    }
}
