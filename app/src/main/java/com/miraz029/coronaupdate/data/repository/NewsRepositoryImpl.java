package com.miraz029.coronaupdate.data.repository;

import com.miraz029.coronaupdate.data.source.local.AppDatabase;
import com.miraz029.coronaupdate.data.source.remote.ApiService;
import com.miraz029.coronaupdate.domain.model.News;
import com.miraz029.coronaupdate.domain.repository.NewsRepository;
import com.miraz029.coronaupdate.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class NewsRepositoryImpl implements NewsRepository {

    private ApiService apiService;
    private AppDatabase appDatabase;
    private String apiKey;
    private String newsTopic;

    public NewsRepositoryImpl(ApiService apiService,
                              AppDatabase appDatabase,
                              String apiKey,
                              String newsTopic) {
        this.apiService = apiService;
        this.appDatabase = appDatabase;
        this.apiKey = apiKey;
        this.newsTopic = newsTopic;
    }

    @Override
    public Observable<List<News>> getNews() {
        return apiService.getNews(newsTopic, apiKey)
                .map(newsContainer -> {
                    List<News> newsListOutput = new ArrayList<>();
                    if (newsContainer.getArticles() != null && !newsContainer.getArticles().isEmpty()) {
                        for (News news : newsContainer.getArticles()) {
                            news.setNewsId(AppUtils.getMd5(news.getUrl()));
                            newsListOutput.add(news);
                        }
                    }
                    return newsListOutput;
                })
                .doOnNext(newsList -> {
                    if (newsList != null && !newsList.isEmpty()) {
                        appDatabase.newsDao().insertNewsList(newsList);
                    }
                });
    }
}
