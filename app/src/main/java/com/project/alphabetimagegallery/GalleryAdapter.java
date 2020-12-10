package com.project.alphabetimagegallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        return new GalleryViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final GalleryViewHolder holder, final int position) {
        final Image image = images.get(position);
        holder.galleryImage.setImageResource(image.getImage());
        holder.galleryImage.setOnClickListener(new View.OnClickListener() {
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
        public ImageView galleryImage;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            galleryImage = itemView.findViewById(R.id.image);
        }
    }
}
