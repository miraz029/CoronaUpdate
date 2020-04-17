package com.miraz029.coronaupdate.di.builder;

import androidx.lifecycle.ViewModel;

import com.miraz029.coronaupdate.di.key.ViewModelKey;
import com.miraz029.coronaupdate.presentation.newsdetails.NewsDetailsViewModel;
import com.miraz029.coronaupdate.presentation.newslist.NewsListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelsBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel.class)
    public abstract ViewModel bindNewsListViewModel(NewsListViewModel newsListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NewsDetailsViewModel.class)
    public abstract ViewModel bindNewsDetailsViewModel(NewsDetailsViewModel newsDetailsViewModel);
}
