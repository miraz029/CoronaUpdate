package com.miraz029.coronaupdate.di.provider;

import com.miraz029.coronaupdate.presentation.newsdetails.NewsDetailsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class NewsDetailsFragmentProvider {

    @ContributesAndroidInjector
    public abstract NewsDetailsFragment providesNewsDetailsFragment();
}