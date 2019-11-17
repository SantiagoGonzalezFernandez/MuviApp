package com.muviteam.muviapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.muviteam.muviapp.R;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,
        YouTubePlayer.PlaybackEventListener {

    public static final String CLAVE_KEY = "key";
    YouTubePlayerView youTubePlayerView;
    String stringClaveYoutube = "AIzaSyBK5m-PZyl8BS0IUpKrGh2_fb9CygioTho";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        encontrarVariables();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String key = bundle.getString(CLAVE_KEY);

        youTubePlayerView.initialize(key,this);

    }

    private void encontrarVariables(){
        youTubePlayerView = findViewById(R.id.YoutubeActivity_YouTubePlayerView_Trailer);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {

        if(!fueRestaurado){
            youTubePlayer.cueVideo("BdJKm16Co6M");
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if(youTubeInitializationResult.isUserRecoverableError()){

            youTubeInitializationResult.getErrorDialog(this,1).show();
        }else{
            String error = "Error al inicializar Youtube" + youTubeInitializationResult.toString();

            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == 1) {

            getYoutubePlayerProvider().initialize(stringClaveYoutube,this);
        }
    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider(){

        return youTubePlayerView;
    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
}
