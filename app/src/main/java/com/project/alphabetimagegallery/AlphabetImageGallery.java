package com.project.alphabetimagegallery;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AlphabetImageGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_view);
        ImageView selectedImage = findViewById(R.id.selectedImage);
        RecyclerView recyclerView = findViewById(R.id.image_gallery);

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

        GalleryAdapter myAdapter = new GalleryAdapter(galleryImages, selectedImage, alphabetMediaPlayer);
        recyclerView.setAdapter(myAdapter);
    }
}