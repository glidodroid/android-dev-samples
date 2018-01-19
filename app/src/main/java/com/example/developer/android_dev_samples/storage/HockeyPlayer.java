package com.example.developer.android_dev_samples.storage;

import android.support.annotation.NonNull;

import com.example.developer.android_dev_samples.HockeyPlayerModel;
import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.RowMapper;

/**
 * Created by developer on 9/1/18.
 */

@AutoValue
public abstract class HockeyPlayer implements HockeyPlayerModel {

    public static final Factory<HockeyPlayer> FACTORY = new Factory<>(new Creator<HockeyPlayer>() {
        @Override
        public HockeyPlayer create(long _id, long player_number, @NonNull String name) {
            return new AutoValue_HockeyPlayer(_id, player_number, name);
        }
    });

    public static final RowMapper<HockeyPlayer> SELECT_ALL_MAPPER = FACTORY.selectAllMapper();
}
