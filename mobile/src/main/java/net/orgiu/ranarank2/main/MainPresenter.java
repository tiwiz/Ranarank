package net.orgiu.ranarank2.main;

import android.support.annotation.NonNull;


public class MainPresenter implements MainContract.Presenter{
    private MainContract.Model model;

    public MainPresenter(@NonNull MainContract.Model model) {
        this.model = model;
    }

    @Override
    public void onNewCompetitionCreated(@NonNull String competitionName) {
        model.onNewCompetitionCreated(competitionName);
    }
}
