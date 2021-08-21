package com.example.additionallabsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
public class MyServices extends Service {
    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this,
                Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();
        return START_STICKY;
        //return super.onStartCommand(intent, flags, startId);
        MediaPlayer player =
                MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
    btnStart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startService(new Intent(MainActivity.this, MyServices.class));
        }
    }
btnStop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            stopService(new Intent(MainActivity.this, MyServices.class));
        }
    };



}
