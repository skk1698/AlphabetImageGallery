package com.project.alphabetimagegallery;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.alphabetimagegallery.adapters.GalleryAdapter;
import com.project.alphabetimagegallery.databinding.GalleryViewBinding;

import java.util.ArrayList;
import java.util.List;

public class AlphabetImageGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GalleryViewBinding galleryViewBinding =
                DataBindingUtil.setContentView(this, R.layout.gallery_view);

        RecyclerView recyclerView = galleryViewBinding.imageGallery;
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                                                              LinearLayoutManager.HORIZONTAL,
                                                              false));

        int[] images = new int[]{R.drawable.apple, R.drawable.ball, R.drawable.cat, R.drawable.dog,
                                 R.drawable.elephant, R.drawable.fish, R.drawable.goat, R.drawable.horse,
                                 R.drawable.icecream, R.drawable.joker, R.drawable.kite, R.drawable.lion,
                                 R.drawable.monkey, R.drawable.nest, R.drawable.orange, R.drawable.parrot,
                                 R.drawable.queen, R.drawable.rabbit, R.drawable.ship, R.drawable.top,
                                 R.drawable.umbrella, R.drawable.van, R.drawable.whale, R.drawable.xmas,
                                 R.drawable.yak, R.drawable.zebra};

        List<Image> galleryImages = new ArrayList<>();
        for (int image : images) {
            galleryImages.add(new Image(image));
        }
        AlphabetMediaPlayer alphabetMediaPlayer = new AlphabetMediaPlayer(this);
        alphabetMediaPlayer.initMediaPlayer();

        recyclerView.setAdapter(new GalleryAdapter(galleryImages,
                                                   galleryViewBinding.selectedImage,
                                                   alphabetMediaPlayer));
    }
}