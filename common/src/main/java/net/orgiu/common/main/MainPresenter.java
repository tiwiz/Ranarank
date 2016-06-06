package net.orgiu.common.main;

import android.support.annotation.NonNull;

import net.orgiu.common.repository.RepositoryContract;


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
