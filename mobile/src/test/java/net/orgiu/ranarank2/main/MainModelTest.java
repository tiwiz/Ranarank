package net.orgiu.ranarank2.main;

import net.orgiu.ranarank2.Injection;
import net.orgiu.ranarank2.database.DataStorage;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MainModelTest {

    private DataStorage storage;
    private MainContract.Model model;

    @Before
    public void setUp() throws Exception {
        storage = Injection.provideDataStorage();
        model = new MainModel(storage);
    }

    @Test
    public void setNameInModel_ReturnsIt() throws Exception {
        String COMPETITION_NAME = "Test competition";

        model.onNewCompetitionCreated(COMPETITION_NAME);
        assertEquals(storage.getCompetitionName(), COMPETITION_NAME);
    }
}