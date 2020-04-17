package com.miraz029.coronaupdate.domain.usecase;

import com.miraz029.coronaupdate.domain.model.News;
import com.miraz029.coronaupdate.domain.repository.NewsRepository;
import com.miraz029.coronaupdate.domain.usecase.base.UseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetNewsUseCase extends UseCase<List<News>> {

    private final NewsRepository newsRepository;

    @Inject
    GetNewsUseCase(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public Observable<List<News>> buildUseCaseObservable() {
        return newsRepository.getNews();
    }

}
