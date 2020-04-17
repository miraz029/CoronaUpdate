package com.miraz029.coronaupdate.data.source.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.miraz029.coronaupdate.data.source.local.dao.NewsDao;
import com.miraz029.coronaupdate.domain.model.News;
import com.miraz029.coronaupdate.domain.model.Source;

@Database(entities = {News.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public AppDatabase() {
        super();
    }
    public abstract NewsDao newsDao();
}
