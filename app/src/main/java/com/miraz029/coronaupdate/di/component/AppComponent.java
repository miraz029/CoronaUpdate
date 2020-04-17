package com.miraz029.coronaupdate.di.component;

import android.app.Application;

import com.miraz029.coronaupdate.CoronaUpdateApp;
import com.miraz029.coronaupdate.di.module.ActivityModule;
import com.miraz029.coronaupdate.di.module.AppModule;
import com.miraz029.coronaupdate.di.module.DatabaseModule;
import com.miraz029.coronaupdate.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityModule.class,
        DatabaseModule.class,
        NetworkModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(CoronaUpdateApp application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
