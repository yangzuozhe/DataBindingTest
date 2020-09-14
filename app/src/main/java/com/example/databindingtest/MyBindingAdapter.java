package com.example.databindingtest;

import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MyBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void bindImageUrl(ImageView view,String imageUrl){
        RequestOptions options =
                new RequestOptions()
                        .centerCrop()
                        .dontAnimate();

        Glide.with(view)
                .load(imageUrl)
                .apply(options)
                .into(view);
    }






}
