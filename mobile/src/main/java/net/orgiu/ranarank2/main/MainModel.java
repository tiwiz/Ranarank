package net.orgiu.ranarank2.main;

import android.support.annotation.NonNull;

import net.orgiu.ranarank2.database.DataStorage;

public class MainModel implements MainContract.Model{
    private DataStorage storage;

    public MainModel(DataStorage storage) {
        this.storage = storage;
    }

    @Override
    public void onNewCompetitionCreated(@NonNull String competitionName) {
        storage.addNewCompetition(competitionName);
    }
}
