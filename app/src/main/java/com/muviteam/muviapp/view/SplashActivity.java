package com.muviteam.muviapp.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.muviteam.muviapp.R;

public class SplashActivity extends AppCompatActivity {

    private VideoView videoViewVideoSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 2000);

        videoViewVideoSplash = findViewById(R.id.SplashActivity_VideoView_VideoSplash);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.muvi;
        Uri uri = Uri.parse(videoPath);
        videoViewVideoSplash.setVideoURI(uri);
        videoViewVideoSplash.requestFocus();
        videoViewVideoSplash.start();
    }
}