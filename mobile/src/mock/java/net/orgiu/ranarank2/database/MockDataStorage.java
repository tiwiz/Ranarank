package net.orgiu.ranarank2.database;

import android.support.annotation.NonNull;


public class MockDataStorage implements DataStorage{
    private static final String TAG = "MOCK-DataStorage";
    private String competitionName;

    @Override
    public void addNewCompetition(@NonNull String competitionName) {
        this.competitionName = competitionName;
    }

    @Override
    public String getCompetitionName() {
        return competitionName;
    }
}
