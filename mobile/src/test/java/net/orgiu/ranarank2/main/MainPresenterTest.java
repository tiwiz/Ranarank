package net.orgiu.ranarank2.main;

import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TextUtils.class})
public class MainPresenterTest {

    @Mock
    private MainContract.View mockView;

    @Mock
    private MainContract.Model mockModel;

    private MainContract.Presenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(TextUtils.class);
        presenter = new MainPresenter(mockModel);
    }

    @Test
    public void chooseNewCompetition_ModelUpdated() throws Exception {
        presenter.onNewCompetitionCreated("TEST1");
        verify(mockModel).onNewCompetitionCreated("TEST1");
    }

    @Test(expected = RuntimeException.class)
    public void emptyCompetitionNameThrowsException() throws Exception {
        presenter.onNewCompetitionCreated("");
    }

    @Test(expected = RuntimeException.class)
    public void shortCompetitionNameThrowsException() throws Exception {
        presenter.onNewCompetitionCreated("abc");
    }

    @Test
    public void longEnoughCompetitionNameIsOk() throws Exception {
        presenter.onNewCompetitionCreated("abcd");
    }
}