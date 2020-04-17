package com.miraz029.coronaupdate.presentation.newslist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.miraz029.coronaupdate.R;
import com.miraz029.coronaupdate.base.BaseFragment;
import com.miraz029.coronaupdate.databinding.FragmentNewsListBinding;
import com.miraz029.coronaupdate.domain.model.News;

import java.util.ArrayList;

import javax.inject.Inject;

public class NewsListFragment extends BaseFragment implements OnNewsSelectListener {

    public static final String FRAGMENT_NAME = NewsListFragment.class.getSimpleName();

    public NewsListViewModel newsListViewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    private NewsListAdapter newsListAdapter;
    private FragmentNewsListBinding fragmentNewsListBinding;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        newsListViewModel = new ViewModelProvider(this, viewModelFactory).get(NewsListViewModel.class);

        fragmentNewsListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false);
        fragmentNewsListBinding.setNewsListViewModel(newsListViewModel);
        fragmentNewsListBinding.rvNewsList.setAdapter(newsListAdapter);

        newsListViewModel.isLoaded.observe(getViewLifecycleOwner(), isLoaded -> {
            if (isLoaded) {
                fragmentNewsListBinding.newsProgressBar.setVisibility(View.GONE);
            } else {
                fragmentNewsListBinding.newsProgressBar.setVisibility(View.VISIBLE);
            }
        });

        newsListViewModel.newsListLiveData.observe(getViewLifecycleOwner(), newsList -> {
            newsListAdapter.setNewsList((ArrayList<News>) newsList);
        });

        newsListViewModel.loadNewsList();
        return fragmentNewsListBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsListAdapter = new NewsListAdapter(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        newsListAdapter = null;
    }

    @Override
    public void onSelectNews(News news) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(news.getUrl()));
        startActivity(browserIntent);
    }
}
