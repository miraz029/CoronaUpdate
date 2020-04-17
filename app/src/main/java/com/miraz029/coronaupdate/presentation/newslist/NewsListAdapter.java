package com.miraz029.coronaupdate.presentation.newslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.miraz029.coronaupdate.R;
import com.miraz029.coronaupdate.databinding.ItemNewsBinding;
import com.miraz029.coronaupdate.domain.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnNewsSelectListener onNewsSelectListener;

    private List<News> newsList;

    public NewsListAdapter(OnNewsSelectListener onNewsSelectListener) {
        this.onNewsSelectListener = onNewsSelectListener;
        this.newsList = new ArrayList<>();
    }

    public void setNewsList(ArrayList<News> newsList) {
        if (newsList != null) {
            this.newsList = newsList;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding itemNewsBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_news, parent, false);
        return new NewsViewHolder(itemNewsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsViewHolder newsViewHolder = (NewsViewHolder) holder;
        newsViewHolder.onBind(getItem(position));
    }

    @Override
    public int getItemCount() {
        if (newsList == null) {
            return 0;
        }
        return newsList.size();
    }

    private News getItem(int position) {
        return newsList.get(position);
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        ItemNewsBinding itemNewsBinding;
        NewsViewModel newsViewModel;

        public NewsViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            itemNewsBinding = (ItemNewsBinding) dataBinding;
        }

        public void onBind(News news) {
            newsViewModel = new NewsViewModel(news);
            itemNewsBinding.setNewsViewModel(newsViewModel);
            itemView.setOnClickListener(v -> {
                if (onNewsSelectListener != null) {
                    onNewsSelectListener.onSelectNews(news);
                }
            });
        }
    }
}
