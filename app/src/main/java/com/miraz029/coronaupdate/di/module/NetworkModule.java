package com.miraz029.coronaupdate.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miraz029.coronaupdate.data.repository.NewsRepositoryImpl;
import com.miraz029.coronaupdate.data.source.local.AppDatabase;
import com.miraz029.coronaupdate.data.source.remote.ApiService;
import com.miraz029.coronaupdate.domain.repository.NewsRepository;
import com.miraz029.coronaupdate.utils.AppConstants;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {AppModule.class})
public class NetworkModule {

    private final static String NAME_BASE_URL = "BASE_URL";
    private final static String NAME_API_KEY = "API_KEY";
    private final static String NAME_TOPIC_CORONA = "TOPIC_CORONA";

    @Provides
    @Named(NAME_BASE_URL)
    public String providesBaseUrl() {
        return AppConstants.BASE_URL;
    }

    @Provides
    @Named(NAME_API_KEY)
    public String providesApiKey() {
        return AppConstants.API_KEY;
    }

    @Provides
    @Named(NAME_TOPIC_CORONA)
    public String providesNewsTopicCorona() {
        return AppConstants.TOPIC_CORONA;
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit(GsonConverterFactory gsonConverterFactory,
                                     RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                                     OkHttpClient okHttpClient,
                                     @Named(NAME_BASE_URL) String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    public Gson providesGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory providesGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public RxJava2CallAdapterFactory providesRxJavaCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    public ApiService providesApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    public NewsRepository providesNewsRepository(ApiService apiService,
                                                 AppDatabase appDatabase,
                                                 @Named(NAME_API_KEY) String apiKey,
                                                 @Named(NAME_TOPIC_CORONA) String topic) {
        return new NewsRepositoryImpl(apiService, appDatabase, apiKey, topic);
    }

}