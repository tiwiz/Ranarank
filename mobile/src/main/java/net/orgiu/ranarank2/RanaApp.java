package net.orgiu.ranarank2;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;
import net.orgiu.ranarank2.database.DataStorage;

public class RanaApp extends Application{
    private static final DataStorage storage = Injection.provideDataStorage();

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }

    public static DataStorage getStorage() {
        return storage;
    }
}
