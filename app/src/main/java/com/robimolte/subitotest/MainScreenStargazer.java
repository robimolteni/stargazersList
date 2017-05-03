package com.robimolte.subitotest;


import java.util.List;

import com.robimolte.subitotest.model.Stargazer;

import rx.Observable;

/**
 * Created by robimolte on 27/12/2016.
 */

public interface MainScreenStargazer {

    interface View {
        void showStargazers(List<Stargazer> stargazer);
        void showError(String message);

    }

    interface Presenter {

        //getList
        void getStargazers(String onwerRepo,String nameRepo);
        void rxUnsubscribe();
        void setView(MainScreenStargazer.View view);

    }

    interface Model {
        Observable<List<Stargazer>> getStargazers(String onwerRepo,String nameRepo);
    }
}
