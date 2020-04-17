package com.miraz029.coronaupdate.presentation;

import android.os.Bundle;

import com.miraz029.coronaupdate.R;
import com.miraz029.coronaupdate.base.BaseActivity;
import com.miraz029.coronaupdate.presentation.newslist.NewsListFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            navigateToNewsList();
        }
    }

    private void navigateToNewsList() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, NewsListFragment.newInstance(), NewsListFragment.FRAGMENT_NAME)
                .commitNow();
    }
}
