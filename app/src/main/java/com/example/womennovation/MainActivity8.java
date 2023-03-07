package com.example.womennovation;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity8 extends AppCompatActivity {
    public MaterialButton police,womenHelpline1,womenHelpline2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        police=(MaterialButton )findViewById(R.id.policeButton);

        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:9498824271"));
                if (ActivityCompat.checkSelfPermission(MainActivity8.this,CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity8.this, "Permission not Granted", Toast.LENGTH_LONG).show();
                    return;
                }
                startActivity(callIntent);
            }

        });
        womenHelpline1=(MaterialButton )findViewById(R.id.womenHelpline1Button);

        womenHelpline1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9498824271"));
                if (ActivityCompat.checkSelfPermission(MainActivity8.this,CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity8.this, "Permission not Granted", Toast.LENGTH_LONG).show();
                    return;
                }
                startActivity(callIntent);
            }

        });
        womenHelpline2=(MaterialButton )findViewById(R.id.womenHelpline2Button);

        womenHelpline2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:9498824271"));
                if (ActivityCompat.checkSelfPermission(MainActivity8.this,CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity8.this, "Permission not Granted", Toast.LENGTH_LONG).show();
                    return;
                }
                startActivity(callIntent);
            }
        });

    }


}
