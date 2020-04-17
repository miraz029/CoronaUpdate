package com.miraz029.coronaupdate.domain.repository;

import com.miraz029.coronaupdate.domain.model.News;

import java.util.List;

import io.reactivex.Observable;

public interface NewsRepository {
    Observable<List<News>> getNews();
}
