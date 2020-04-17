package com.miraz029.coronaupdate.data.source.remote;

import com.miraz029.coronaupdate.domain.model.NewsContainer;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("everything")
    public Observable<NewsContainer> getNews(@Query("q") String newsTopic, @Query("apiKey") String apiKey);
}
