package com.robimolte.subitotest;

import android.app.Application;

import com.robimolte.subitotest.component.DaggerMainScreenComponent;
import com.robimolte.subitotest.component.MainScreenComponent;
import com.robimolte.subitotest.module.AppModule;
import com.robimolte.subitotest.module.MainScreenModule;
import com.robimolte.subitotest.module.NetModule;

/**
 * Created by robimolte on 04/02/2017.
 */

public class App extends Application {

    private String URL = "https://api.github.com";
    private MainScreenComponent component;



    @Override
    public void onCreate() {
        super.onCreate();

     component = DaggerMainScreenComponent.builder()
                .appModule(new AppModule(this))
                .mainScreenModule(new MainScreenModule())
                .netModule(new NetModule((URL)))
                .build();
    }


    public MainScreenComponent getMainScreenComponent() {
        return component;
    }






}