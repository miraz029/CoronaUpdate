package com.miraz029.coronaupdate.di.provider;

import com.miraz029.coronaupdate.presentation.newslist.NewsListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class NewsListFragmentProvider {

    @ContributesAndroidInjector
    public abstract NewsListFragment providesNewsListFragment();
}
