package com.robimolte.subitotest;

import android.content.Intent;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import com.robimolte.subitotest.model.Stargazer;
import com.robimolte.subitotest.presenter.MainScreenPresenter;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by robimolte on 04/02/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityPresenterTest {

    @Mock
    private Retrofit retrofitAPI;

    @Mock
    MainScreenStargazer.View  mView;

    MainScreenPresenter mNotesPresenter;


    @Before
    public void setupNotesPresenter() {

        mView = mock(MainScreenStargazer.View.class);

        retrofitAPI = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

        mNotesPresenter = new MainScreenPresenter(retrofitAPI, mView);
    }

    //Test that given one stargazer the presenter call the view
    @Test
    public void getStargazerList() {

        List<Stargazer> listStargazer = new ArrayList<>();
        Stargazer f = new Stargazer("a","b");
        listStargazer.add(f);

        mNotesPresenter.showNext(listStargazer);
        verify(mView).showStargazers(listStargazer);
    }

    //Test that given one error answer the presenter call the method view showErrow
    @Test
    public void getStargazerError() {

        String errorMsg = "Error message";
        mNotesPresenter.showError(errorMsg);
        verify(mView).showError(errorMsg);
    }




}
