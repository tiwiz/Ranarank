package net.orgiu.ranarank2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.orgiu.ranarank2.main.MainContract;
import net.orgiu.ranarank2.main.MainPresenter;
import net.orgiu.ranarank2.main.MainView;

public class MainActivity extends AppCompatActivity{
    MainContract.View view;
    MainContract.Presenter presenter;
    MainContract.Model model;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(competitionName -> {});
        view = new MainView(findViewById(android.R.id.content), presenter);
    }
}
