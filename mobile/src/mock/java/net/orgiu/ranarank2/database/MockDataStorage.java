package net.orgiu.ranarank2.database;

import android.support.annotation.NonNull;
import android.util.Log;


public class MockDataStorage implements DataStorage{
    private static final String TAG = "MOCK-DataStorage";

    @Override
    public void addNewCompetition(@NonNull String competitionName) {
        Log.d(TAG, "Competition name: " + competitionName);
    }
}
