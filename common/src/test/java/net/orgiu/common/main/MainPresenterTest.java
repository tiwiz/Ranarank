package net.orgiu.common.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class MainPresenterTest {

    @Mock
    private MainContract.View mockView;

    @Mock
    private MainContract.Model mockModel;

    private MainContract.Presenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(mockModel);
    }

    @Test
    public void chooseNewCompetition_ModelUpdated() throws Exception {
        presenter.onNewCompetitionCreated("TEST1");
        verify(mockModel).onNewCompetitionCreated("TEST1");
    }
}