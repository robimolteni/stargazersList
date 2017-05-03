package com.robimolte.subitotest;

import com.robimolte.subitotest.model.Stargazer;

import java.util.List;

import rx.Observable;

/**
 * Created by robimolte on 02/05/2017.
 */

public class StargazerRepository implements Repository {

    private StargazerAPI stargazerAPI;

    public StargazerRepository(StargazerAPI stargazerAPI){

        this.stargazerAPI = stargazerAPI;

    }

    @Override
    public Observable<List<Stargazer>> getStargazers(String onwerRepo, String nameRepo) {
        String userAgent = "Android";
        return stargazerAPI.getStargazers(onwerRepo,nameRepo,userAgent);
    }
}
