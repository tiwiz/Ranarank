package net.orgiu.ranarank2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.orgiu.ranarank2.main.MainContract;

public class MainActivity extends AppCompatActivity{
    MainContract.View view;
    MainContract.Presenter presenter;
    MainContract.Model model;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
