package com.miraz029.coronaupdate.di.builder;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;

@Module(includes = {ViewModelsBuilder.class})
public abstract class ViewModelFactoryBuilder {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
}
