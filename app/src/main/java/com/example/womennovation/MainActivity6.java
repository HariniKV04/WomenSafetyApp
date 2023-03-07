package com.example.womennovation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {
    public ImageView acceptCall,declineCall;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        ActionBar actionBar  =getSupportActionBar();
        actionBar.hide();

        MediaPlayer music=MediaPlayer.create(MainActivity6.this,R.raw.ringtone);

        music.start();


        acceptCall = (ImageView) findViewById(R.id.acceptCall);
        declineCall = (ImageView) findViewById(R.id.declineCall);

        acceptCall.setOnClickListener(new View.OnClickListener() {
            //9498824271
            @Override
            public void onClick(View view) {
                if (music.isPlaying()) {
                    music.stop();
                }
                Intent intent = new Intent(MainActivity6.this, MainActivity7.class);
                startActivity(intent);
            }
        });
        declineCall.setOnClickListener(new View.OnClickListener() {
            //9498824271
            @Override
            public void onClick(View view) {
                if (music.isPlaying()) {
                    music.stop();
                }
                Intent intent = new Intent(MainActivity6.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }

}
