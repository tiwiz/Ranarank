package net.orgiu.ranarank2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import net.orgiu.ranarank2.utils.IntentBuilder;

public class ChronometerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.chronometerToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra(IntentBuilder.CHRONOMETER_ACTIVITY_TITLE_KEY));
    }

}
