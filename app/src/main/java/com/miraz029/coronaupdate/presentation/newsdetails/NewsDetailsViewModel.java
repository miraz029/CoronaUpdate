package com.miraz029.coronaupdate.presentation.newsdetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miraz029.coronaupdate.domain.model.News;

import javax.inject.Inject;

public class NewsDetailsViewModel extends ViewModel {


    public MutableLiveData<News> newsLiveData = new MutableLiveData<News>();


    @Inject
    public NewsDetailsViewModel() {

    }

}
