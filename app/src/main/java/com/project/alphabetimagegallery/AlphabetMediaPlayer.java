package com.project.alphabetimagegallery;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;

public class AlphabetMediaPlayer {
    public final String TAG = this.getClass().getSimpleName();
    @Nullable private MediaPlayer mediaPlayer;
    @Nullable private int[] songs;
    @NonNull private Context context;

    public AlphabetMediaPlayer(@NonNull Context context) {
        this.context = context;

        songs = new int[]{R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e, R.raw.f, R.raw.g, R.raw.h,
                          R.raw.i, R.raw.j, R.raw.k, R.raw.l, R.raw.m, R.raw.n, R.raw.o, R.raw.p,
                          R.raw.q, R.raw.r, R.raw.s, R.raw.t, R.raw.u, R.raw.v, R.raw.w, R.raw.x,
                          R.raw.y, R.raw.z};
    }

    public void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(context, songs[0]);
        mediaPlayer.start();
    }

    public void playSelectedAlphabetMedia(int position) {
        if (mediaPlayer != null && songs != null) {
            AssetFileDescriptor assetFileDescriptor = context.getResources().openRawResourceFd(songs[position]);

            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
                                          assetFileDescriptor.getStartOffset(),
                                          assetFileDescriptor.getDeclaredLength());
                mediaPlayer.prepare();
                mediaPlayer.start();
                assetFileDescriptor.close();
            } catch (IOException e) {
                Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
            }
        }
    }
}
