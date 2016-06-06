package net.orgiu.common.main;

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
        void onNewCompetitionCreated();

        /**
         * Whenever a competition ends, this method is invoked, so that the View can restore its
         * previous state and show again the fields for the new instance
         */
        void onCompetitionEnded();
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
        void onCompetitionStarted(@NonNull String competitionName);

        /**
         * This method is the one that will be invoked whenever the competition ends and shall
         * free all the used resources and connections
         */
        void onCompetitionEndend();
    }
}
