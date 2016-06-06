package net.orgiu.common.repository;

import android.support.annotation.NonNull;

public class RepositoryContract {

    public interface Model {
        /**
         * When a new competition is starting, this method is the one being invoked, so that it can save
         * the data for later consumption
         */
        void onNewCompetition(@NonNull String competitionName);

        /**
         * This method is the one being called when the competition ends, so that it can be cleared
         */
        void onCompetitionEnded();
    }

}
