package com.miraz029.coronaupdate.di.module;

import android.app.Application;

import androidx.room.Room;

import com.miraz029.coronaupdate.data.source.local.AppDatabase;
import com.miraz029.coronaupdate.data.source.local.dao.NewsDao;
import com.miraz029.coronaupdate.di.key.DatabaseInfo;
import com.miraz029.coronaupdate.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @DatabaseInfo
    public String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(Application application, String dbName) {
        return Room.databaseBuilder(
                application,
                AppDatabase.class,
                dbName
        ).build();
    }

    @Provides
    public NewsDao provideNewsDao(AppDatabase appDatabase) {
        return appDatabase.newsDao();
    }
}
