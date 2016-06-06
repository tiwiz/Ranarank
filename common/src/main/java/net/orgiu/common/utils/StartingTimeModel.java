package net.orgiu.common.utils;

/**
 * This interface is the one needed in order to save the starting time of the running
 */
public interface StartingTimeModel {

    /**
     * When a new competition is starting, this method is the one being invoked, so that it can save
     * the data for later consumption
     * @param timestamp the {@code long} representation of the timestamp
     */
    void onNewCompetition(long timestamp);

    /**
     * This method is the one that shall be called in order to retrieve the timestamp as a {@code long}
     * @return a {@code long} representation of the timestamp
     */
    long getStartingTime();

    /**
     * This method is the one being called when the competition ends, so that it can be cleared
     */
    void onCompetitionEnded();
}
