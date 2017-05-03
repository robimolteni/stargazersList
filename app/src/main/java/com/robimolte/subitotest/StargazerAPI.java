package com.robimolte.subitotest;

import com.robimolte.subitotest.model.Stargazer;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by robimolte on 02/05/2017.
 */

public interface StargazerAPI {

    @GET("/repos/{ownerRepo}/{nameRepo}/stargazers")
    Observable<List<Stargazer>> getStargazers(
            @Path("ownerRepo") String repoId,
            @Path("nameRepo") String branchId,
            @Header("User-Agent") String authorization);
}
