package com.miraz029.coronaupdate.presentation;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.miraz029.coronaupdate.R;

public class BindingAdapters {

    @BindingAdapter({"image"})
    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
                .load(imageURL)
                .placeholder(R.drawable.ic_loading)
                .into(imageView);
    }
}
