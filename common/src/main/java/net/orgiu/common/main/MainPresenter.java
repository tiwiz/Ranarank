package net.orgiu.common.main;

import android.support.annotation.NonNull;

import net.orgiu.common.repository.RepositoryContract;


public class MainPresenter implements MainContract.Presenter{
    private MainContract.View view;
    private RepositoryContract.Model model;

    public MainPresenter(@NonNull MainContract.View view,
                         @NonNull RepositoryContract.Model model) {

        this.view = view;
        this.model = model;
    }

    @Override
    public void onCompetitionStarted(@NonNull String competitionName) {
        view.onNewCompetitionCreated();
        model.onNewCompetition(competitionName);
    }

    @Override
    public void onCompetitionEnded() {
        model.onCompetitionEnded();
        view.onCompetitionEnded();
    }
}
