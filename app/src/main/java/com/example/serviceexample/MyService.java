package com.example.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    MediaPlayer mediaPlayer;

    // Извиква се, когато сървисът се създава
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setLooping(true);
        Toast.makeText(this, "Service started ...", Toast.LENGTH_LONG).show();
    }

    // Извиква се, когато клиентът се свързва с bindService()
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }

    // Извиква се, когато сървисът не се използва повече и се разрушава
    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        Toast.makeText(this, "Service destroyed ...", Toast.LENGTH_LONG).show();
    }


}
