package com.example.developer.android_dev_samples.storage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import timber.log.Timber;

/**
 * Created by developer on 9/1/18.
 */

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(HockeyPlayer.CREATE_TABLE);
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            Timber.e(e, "Failed db creation");
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        //db.execSQL("PRAGMA foreign_keys=ON");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.beginTransaction();
        try {
            db.execSQL("DROP TABLE IF EXISTS " + HockeyPlayer.TABLE_NAME);
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            Timber.e(e, "Failed db upgrade");
        } finally {
            db.endTransaction();
            onCreate(db);
        }
    }
}
