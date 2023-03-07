package com.example.womennovation;


import static com.example.womennovation.MainActivity2.index;
import static com.example.womennovation.MainActivity2.pinList;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity5 extends AppCompatActivity {

    MaterialButton cancel;
    EditText digit1,digit2,digit3,digit4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        MediaPlayer music=MediaPlayer.create(MainActivity5.this,R.raw.siren);
        int pinCheck=pinList.get(index);

        music.start();

        cancel=(MaterialButton)findViewById(R.id.cancelButton);
        digit1 = (EditText)findViewById(R.id.digit1);
        digit2 = (EditText)findViewById(R.id.digit2);
        digit3 = (EditText)findViewById(R.id.digit3);
        digit4 = (EditText)findViewById(R.id.digit4);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int digit1_,digit2_,digit3_,digit4_;
                if (digit1.getText().toString().equals("") || digit2.getText().toString().equals("") ||digit3.getText().toString().equals("")||digit4.getText().toString().equals("")){
                    Toast.makeText(MainActivity5.this, "Invalid Pin", Toast.LENGTH_LONG).show();
                }else {
                    digit1_ = Integer.parseInt(digit1.getEditableText().toString());
                    digit2_ = Integer.parseInt(digit2.getEditableText().toString());
                    digit3_ = Integer.parseInt(digit3.getEditableText().toString());
                    digit4_ = Integer.parseInt(digit4.getEditableText().toString());
                    int pinEntered = 1000 * digit1_ + 100 * digit2_ + 10 * digit3_ + digit4_;
                    if (pinEntered == pinCheck) {
                        if (music.isPlaying()) {
                            music.stop();
                        }
                        Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
                        startActivity(intent);
                    } else {
                        digit1.setText("");
                        digit2.setText("");
                        digit3.setText("");
                        digit4.setText("");
                        Toast.makeText(MainActivity5.this, "Incorrect Pin", Toast.LENGTH_LONG).show();
                    }
                }

            }

        });


    }

}
