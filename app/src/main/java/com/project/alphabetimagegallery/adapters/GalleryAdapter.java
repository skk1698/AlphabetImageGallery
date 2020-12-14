package com.project.alphabetimagegallery.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.alphabetimagegallery.AlphabetMediaPlayer;
import com.project.alphabetimagegallery.Image;
import com.project.alphabetimagegallery.R;
import com.project.alphabetimagegallery.databinding.GalleryBinding;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    @NonNull private List<Image> images;
    @NonNull private ImageView selectedImage;
    @NonNull private AlphabetMediaPlayer alphabetMediaPlayer;

    public GalleryAdapter(@NonNull List<Image> images,
                          @NonNull ImageView selectedImage,
                          @NonNull AlphabetMediaPlayer alphabetMediaPlayer) {
        this.images = images;
        this.selectedImage = selectedImage;
        this.alphabetMediaPlayer = alphabetMediaPlayer;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GalleryViewHolder((GalleryBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                                              R.layout.gallery,
                                                                              parent,
                                                                              false));
    }

    @Override
    public void onBindViewHolder(@NonNull final GalleryViewHolder holder, final int position) {
        final Image image = images.get(position);
        holder.galleryBinding.setImageModel(image);
        holder.galleryBinding.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage.setImageResource(image.getImage());
                alphabetMediaPlayer.playSelectedAlphabetMedia(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        public GalleryBinding galleryBinding;

        public GalleryViewHolder(@NonNull GalleryBinding galleryBinding) {
            super(galleryBinding.getRoot());
            this.galleryBinding = galleryBinding;
        }
    }
}
