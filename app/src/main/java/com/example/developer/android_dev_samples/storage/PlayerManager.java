package com.example.developer.android_dev_samples.storage;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.developer.android_dev_samples.HockeyPlayerModel;
import com.squareup.sqldelight.SqlDelightQuery;
import com.squareup.sqldelight.SqlDelightStatement;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by developer on 9/1/18.
 */

public class PlayerManager {

    private final HockeyPlayer.InsertRow insertRow;
    private final SupportSQLiteDatabase database;

    @Inject
    public PlayerManager(DbManager dbManager) {
        database = dbManager.sqLiteOpenHelper().getWritableDatabase();
        insertRow = new HockeyPlayer.InsertRow(database);
    }

    public void insertRow(long playerNumber, String name) {
        Timber.d("insert row");
        insertRow.bind(playerNumber, name);
        int update = insertRow.executeUpdateDelete();
        Timber.d("updated= %s", update);
    }

    public List<HockeyPlayer> allPlayers() {
        List<HockeyPlayer> result = new ArrayList<>();
        SqlDelightQuery selectAllQuery = HockeyPlayer.FACTORY.selectAll();
        Cursor cursor = database.query(selectAllQuery);
        try {
            while (cursor.moveToNext()) {
                HockeyPlayer hockeyPlayer = HockeyPlayer.SELECT_ALL_MAPPER.map(cursor);
                result.add(HockeyPlayer.SELECT_ALL_MAPPER.map(cursor));
            }
        } catch (SQLException e) {
            Timber.e(e);
        }
        Timber.d("result %s",result);
        return result;
    }

}
