package com.miraz029.coronaupdate.data.source.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.miraz029.coronaupdate.domain.model.News;

import java.util.List;

@Dao
public interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Long insert(News news);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertNewsList(List<News> news);

    @Query("SELECT * FROM News")
    public List<News> loadAll();

    @Delete
    public void delete(News news);

    @Query("DELETE FROM NEWS")
    public void deleteAll();
}
