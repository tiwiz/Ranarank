package net.orgiu.ranarank2.main;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;

import net.orgiu.ranarank2.R;
import net.orgiu.ranarank2.utils.IntentBuilder;
import net.orgiu.ranarank2.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainView implements MainContract.View {
    private final MainContract.Presenter presenter;
    private final Activity activity;

    @BindView(R.id.txtCompetitionName)
    EditText txtCompetitionName;

    @BindView(R.id.btnStartCounter)
    FloatingActionButton btnStartCounter;

    public MainView(@NonNull final Activity activity,
                    @NonNull MainContract.Presenter presenter) {

        this.presenter = presenter;
        this.activity = activity;
        ButterKnife.bind(this, activity);

        bindUiBehaviour();
    }

    private void bindUiBehaviour() {
        RxTextView.textChanges(txtCompetitionName)
                .map(StringUtils::isValid)
                .subscribe(this::changeFabVisibilityTo);
    }

    private void changeFabVisibilityTo(boolean v) {
        if (v && btnStartCounter.getVisibility() != View.VISIBLE) {
            btnStartCounter.show();
        } else if (!v && btnStartCounter.getVisibility() == View.VISIBLE) {
            btnStartCounter.hide();
        }
    }

    @OnClick(R.id.btnStartCounter)
    @Override
    public void createCompetition() {
        String competitionName = txtCompetitionName.getText().toString();
        presenter.onNewCompetitionCreated(competitionName);
        activity.startActivity(IntentBuilder.buildStartChronometerIntentFrom(activity, competitionName));
    }
}
