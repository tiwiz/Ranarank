package net.orgiu.ranarank2.main;

import android.support.annotation.NonNull;

import net.orgiu.ranarank2.utils.StringUtils;


public class MainPresenter implements MainContract.Presenter{
    private MainContract.Model model;

    public MainPresenter(@NonNull MainContract.Model model) {
        this.model = model;
    }

    @Override
    public void onNewCompetitionCreated(@NonNull String competitionName) {
        if (StringUtils.isValid(competitionName)) {
            model.onNewCompetitionCreated(competitionName);
        } else {
            throw new RuntimeException("Competition name should be long at least 3 characters");
        }
    }
}
