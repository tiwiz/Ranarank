package net.orgiu.common.main;

import android.support.annotation.NonNull;

import net.orgiu.common.utils.StartingTimeModel;


public class MainPresenter implements MainContract.Presenter{
    private MainContract.View view;
    private StartingTimeModel model;

    public MainPresenter(@NonNull MainContract.View view,
                         @NonNull StartingTimeModel model) {

        this.view = view;
        this.model = model;
    }

    @Override
    public void onCompetitionStarted(@NonNull String competitionName) {
        view.onNewCompetitionCreated();
        
    }

    @Override
    public void onCompetitionEnded() {
        model.onCompetitionEnded();
        view.onCompetitionEnded();
    }
}
