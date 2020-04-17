package com.miraz029.coronaupdate.presentation.newslist;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miraz029.coronaupdate.domain.model.News;
import com.miraz029.coronaupdate.domain.usecase.GetNewsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NewsListViewModel extends ViewModel {

    @Inject
    public GetNewsUseCase getNewsUseCase;

    public MutableLiveData<List<News>> newsListLiveData = new MutableLiveData<List<News>>();

    public MutableLiveData<Boolean> isLoaded = new MutableLiveData<Boolean>();
    private DisposableObserver disposableObserver = null;

    @Inject
    public NewsListViewModel() {
        isLoaded.setValue(false);
    }


    public void loadNewsList() {
        Observable<List<News>> observable = getNewsUseCase.buildUseCaseObservable();

        disposableObserver = new DisposableObserver<List<News>>() {

            @Override
            public void onNext(List<News> newsList) {
                newsListLiveData.setValue(newsList);
                isLoaded.setValue(true);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Corona", "" + e.toString());
            }

            @Override
            public void onComplete() {

            }
        };

        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(disposableObserver);
    }

    public boolean isDataLoaded() {
        return isLoaded.getValue();
    }
}
