package com.example.womennovation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        ActionBar actionBar  =getSupportActionBar();
        actionBar.hide();


        ImageView declineCall2 = (ImageView) findViewById(R.id.declineCall2);

        declineCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity7.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}
