package com.miraz029.coronaupdate.di.module;

import android.app.Application;
import android.content.Context;

import com.miraz029.coronaupdate.di.builder.ViewModelFactoryBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ViewModelFactoryBuilder.class})
public class AppModule {

    @Singleton
    @Provides
    public Context provideContext(Application application) {
        return application.getApplicationContext();
    }
}
