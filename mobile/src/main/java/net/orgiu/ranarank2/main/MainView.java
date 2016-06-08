package net.orgiu.ranarank2.main;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;

import net.orgiu.ranarank2.R;
import net.orgiu.ranarank2.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainView implements MainContract.View {
    private MainContract.Presenter presenter;

    @BindView(R.id.txtCompetitionName)
    EditText txtCompetitionName;

    @BindView(R.id.btnStartCounter)
    FloatingActionButton btnStartCounter;

    public MainView(View rootView, MainContract.Presenter presenter) {
        this.presenter = presenter;
        ButterKnife.bind(this, rootView);

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
        presenter.onNewCompetitionCreated(txtCompetitionName.getText().toString());
    }
}
