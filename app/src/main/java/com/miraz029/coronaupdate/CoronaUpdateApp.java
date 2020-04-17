package com.miraz029.coronaupdate;

import android.content.Context;

import com.miraz029.coronaupdate.di.component.AppComponent;
import com.miraz029.coronaupdate.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

//import androidx.multidex.MultiDex;


public class CoronaUpdateApp extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent component = DaggerAppComponent.builder()
                .application(this)
                .build();
        component.inject(this);
        return component;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //MultiDex.install(this);
    }
}
