package net.orgiu.common.repository;

public class RepositoryContract {

    public interface View {

        void onTimeUpdated(String time);

        void onNumberOfRunnersUpdated(int number);

        void onStopTimer();

        void onAddNewTime();
    }

    public interface Presenter {

        void onAddNewTime();

        void onStopTimer();
    }

    public interface Model {

        void onAddNewTime(String time);
    }

}
