package com.robimolte.subitotest.presenter;

/**
 * Created by robimolte on 04/02/2017.
 */

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import com.robimolte.subitotest.MainScreenStargazer;
import com.robimolte.subitotest.StargazerAPI;
import com.robimolte.subitotest.model.Stargazer;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainScreenPresenter implements MainScreenStargazer.Presenter{

    MainScreenStargazer.View mView;
    MainScreenStargazer.Model mModel;
    private Subscription subscription = null;

    public MainScreenPresenter(MainScreenStargazer.Model mModel) {
        this.mModel = mModel;
    }



    @Override
    public void getStargazers(String onwerRepo, String nameRepo) {


        subscription = mModel.getStargazers(onwerRepo,nameRepo).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Stargazer>>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (mView != null) {
                    mView.showError("Error getting Stargazer");
                }
            }

            @Override
            public void onNext(List<Stargazer> ls) {
                if (mView != null) {
                    mView.showStargazers(ls);
                }
            }
        });

    }

    @Override
    public void rxUnsubscribe() {

        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }

    }

    @Override
    public void setView(MainScreenStargazer.View mView) {
        this.mView = mView;

    }
}