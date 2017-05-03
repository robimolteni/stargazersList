package com.robimolte.subitotest.component;

import dagger.Component;
import com.robimolte.subitotest.MainActivity;
import com.robimolte.subitotest.module.AppModule;
import com.robimolte.subitotest.module.MainScreenModule;
import com.robimolte.subitotest.module.NetModule;
import com.robimolte.subitotest.util.CustomScope;

import javax.inject.Singleton;

/**
 * Created by robimolte on 04/02/2017.
 */

@Singleton
@Component(modules = {MainScreenModule.class, AppModule.class, NetModule.class})
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
