package net.orgiu.ranarank2.database;

import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class FirebaseStorage implements DataStorage {
    private final DatabaseReference reference;
    private final String rootkey;

    private final static String ROOTKEY_FORMAT = "yyyy-Mm-dd";
    private final static String NAME_KEY = "name";
    private final static String COUNT_KEY = "count";


    public FirebaseStorage() {
        reference = FirebaseDatabase.getInstance().getReference();
        rootkey = getRootKey();
    }

    private String getRootKey() {
        DateTime now = DateTime.now();
        DateTimeFormatter formatter = DateTimeFormat.forPattern(ROOTKEY_FORMAT);
        return formatter.print(now);
    }

    @Override
    public void addNewCompetition(@NonNull String competitionName) {
        reference.child(rootkey).child(NAME_KEY).setValue(competitionName);
        reference.child(rootkey).child(COUNT_KEY).setValue(0);
    }
}
