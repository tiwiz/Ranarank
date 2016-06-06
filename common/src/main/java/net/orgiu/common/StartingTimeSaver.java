package net.orgiu.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import net.orgiu.common.utils.StartingTimeModel;


public class StartingTimeSaver implements StartingTimeModel{
    private static final String PREFERENCE_NAME = ".Ranarank";
    private static final String KEY = ".TIMESTAMP";

    private SharedPreferences preferences;

    public StartingTimeSaver(@NonNull Context context) {
        preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void onNewCompetition(long timestamp) {
        preferences.edit().putLong(KEY, timestamp).apply();
    }

    @Override
    public long getStartingTime() {
        return preferences.getLong(KEY, 0);
    }

    @Override
    public void onCompetitionEnded() {
        preferences.edit().remove(KEY).apply();

    }
}
