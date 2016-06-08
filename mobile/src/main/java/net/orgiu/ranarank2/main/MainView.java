package net.orgiu.ranarank2.main;

import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;

import net.orgiu.ranarank2.R;
import net.orgiu.ranarank2.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;
import rx.functions.Func1;

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
                .map(new Func1<CharSequence, Boolean>() {
                    @Override
                    public Boolean call(CharSequence c) {
                        return StringUtils.isValid(c);
                    }
                }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean v) {
                changeFabVisibilityTo(v);
            }
        });
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
