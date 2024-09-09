package com.example.servicesexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer md;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        md=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        md.setLooping(true);
        md.start();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        md.stop();
        super.onDestroy();
    }
}
