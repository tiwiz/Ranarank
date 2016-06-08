package net.orgiu.ranarank2.database;

import android.support.annotation.NonNull;

public interface DataStorage {
    void addNewCompetition(@NonNull String competitionName);
    String getCompetitionName();
}
