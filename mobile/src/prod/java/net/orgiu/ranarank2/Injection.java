package net.orgiu.ranarank2;

import net.orgiu.ranarank2.database.DataStorage;
import net.orgiu.ranarank2.database.FirebaseStorage;

public class Injection {

    public static DataStorage provideDataStorage() {
        return new FirebaseStorage();
    }
}
