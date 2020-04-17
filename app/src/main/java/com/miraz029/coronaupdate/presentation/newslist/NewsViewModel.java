package com.miraz029.coronaupdate.presentation.newslist;

import androidx.lifecycle.MutableLiveData;

import com.miraz029.coronaupdate.domain.model.News;

public class NewsViewModel {

    private MutableLiveData<News> newsData = new MutableLiveData<>();
    private News news;

    public NewsViewModel(News news) {
        newsData.setValue(news);
        this.news = news;
    }

    public News getNews() {
        return news;
    }
}
