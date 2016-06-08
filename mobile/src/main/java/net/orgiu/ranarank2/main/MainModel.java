package net.orgiu.ranarank2.main;

import android.support.annotation.NonNull;

import net.orgiu.ranarank2.RanaApp;

public class MainModel implements MainContract.Model{

    @Override
    public void onNewCompetitionCreated(@NonNull String competitionName) {
        RanaApp.getStorage().addNewCompetition(competitionName);
    }
}
