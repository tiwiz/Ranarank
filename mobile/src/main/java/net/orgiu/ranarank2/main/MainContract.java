package net.orgiu.ranarank2.main;

import android.support.annotation.NonNull;

public class MainContract {

    /**
     * This interface represents the View for the main part of the app, the one displaying the
     * fields for choosing the name of the competition and start the counter.
     */
    public interface View {
        /**
         * Whenever a new competition is started, this method is invoked, so that the View can
         * change its layout accordingly
         */
        void onNewCompetitionCreated(String competitionName);

        void onCompetitionNameVerified();

        void onCompetitionNameInvalid();
    }

    /**
     * This interface represents the behaviour of the main part, deciding when to start the
     * new counter and when instead invoke the old View restoration
     */
    public interface Presenter {

        /**
         * This method is the one that should be invoked when a new competition is needed to start
         * @param competitionName the name of the competition being saved
         */
        void onNewCompetitionCreated(@NonNull String competitionName);
    }

    public interface Model {

        void onNewCompetitionCreated(@NonNull String competitionName);
    }
}
