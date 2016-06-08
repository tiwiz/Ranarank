package net.orgiu.ranarank2.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import net.orgiu.ranarank2.ChronometerActivity;

public class IntentBuilder {
    public static final String CHRONOMETER_ACTIVITY_TITLE_KEY = "ChronometerActivityTitle";

    public static Intent buildStartChronometerIntentFrom(@NonNull Context context, @NonNull String title) {
        Intent intent = new Intent(context, ChronometerActivity.class);
        intent.putExtra(CHRONOMETER_ACTIVITY_TITLE_KEY, title);
        return intent;
    }
}
