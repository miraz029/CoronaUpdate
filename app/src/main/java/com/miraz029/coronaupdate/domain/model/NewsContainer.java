package com.miraz029.coronaupdate.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsContainer {

    @SerializedName("ok")
    private String ok;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<News> articles;

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
}
