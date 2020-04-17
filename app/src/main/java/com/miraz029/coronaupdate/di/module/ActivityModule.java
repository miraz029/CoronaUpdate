package com.miraz029.coronaupdate.di.module;

import com.miraz029.coronaupdate.di.provider.NewsDetailsFragmentProvider;
import com.miraz029.coronaupdate.di.provider.NewsListFragmentProvider;
import com.miraz029.coronaupdate.presentation.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {
        AndroidSupportInjectionModule.class
})
public interface ActivityModule {

    @ContributesAndroidInjector(
            modules = {
                    NewsListFragmentProvider.class,
                    NewsDetailsFragmentProvider.class
            })
    public MainActivity mainActivityInjector();
}
