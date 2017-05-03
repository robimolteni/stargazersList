package com.robimolte.subitotest.module;

/**
 * Created by robimolte on 04/02/2017.
 */

import dagger.Module;
import dagger.Provides;
import com.robimolte.subitotest.MainScreenStargazer;
import com.robimolte.subitotest.Repository;
import com.robimolte.subitotest.StargazerAPI;
import com.robimolte.subitotest.StargazerModel;
import com.robimolte.subitotest.StargazerRepository;
import com.robimolte.subitotest.model.Stargazer;
import com.robimolte.subitotest.presenter.MainScreenPresenter;
import com.robimolte.subitotest.util.CustomScope;

import javax.inject.Singleton;


@Module(includes = {NetModule.class})
public class MainScreenModule {

    @Provides
    public MainScreenStargazer.Presenter provideActivityPresenter(MainScreenStargazer.Model topMoviesModel) {
        return new MainScreenPresenter(topMoviesModel);
    }

    @Provides
    public MainScreenStargazer.Model provideActivityModel(Repository repository) {
        return new StargazerModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepo(StargazerAPI stargazerApiService) {
        return new StargazerRepository(stargazerApiService);
    }
}
