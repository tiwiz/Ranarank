package net.orgiu.common.main;

import net.orgiu.common.repository.RepositoryContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class MainPresenterTest {

    @Mock
    private MainContract.View mockView;

    @Mock
    private RepositoryContract.Model mockModel;

    private MainContract.Presenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(mockView, mockModel);
    }

    @Test
    public void chooseNewCompetition_ViewAndModelUpdated() throws Exception {
        presenter.onCompetitionStarted("");
        verify(mockView).onNewCompetitionCreated();
        verify(mockModel).onNewCompetition("");
    }

    @Test
    public void chooseEndCompetition_ViewAndModelUpdated() throws Exception {
        presenter.onCompetitionEnded();
        verify(mockView).onCompetitionEnded();
        verify(mockModel).onCompetitionEnded();
    }
}