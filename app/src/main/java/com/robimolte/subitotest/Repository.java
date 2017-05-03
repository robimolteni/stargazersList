package com.robimolte.subitotest;

import com.robimolte.subitotest.model.Stargazer;

import java.util.List;

import rx.Observable;

/**
 * Created by robimolte on 02/05/2017.
 */

public interface Repository {

    Observable<List<Stargazer>> getStargazers(String onwerRepo, String nameRepo);



}
