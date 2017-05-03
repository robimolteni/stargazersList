package com.robimolte.subitotest;

import com.robimolte.subitotest.model.Stargazer;

import java.util.List;

import rx.Observable;

/**
 * Created by robimolte on 02/05/2017.
 */

public class StargazerModel implements MainScreenStargazer.Model {

    private Repository repository;

    public StargazerModel(Repository repository){
        this.repository = repository;
    }


    @Override
    public Observable<List<Stargazer>> getStargazers(String onwerRepo, String nameRepo) {
        return  repository.getStargazers(onwerRepo,nameRepo);
    }
}
