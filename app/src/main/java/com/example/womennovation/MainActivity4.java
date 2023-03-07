package com.example.womennovation;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity4 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    public ActionBarDrawerToggle toggle;
    public MaterialButton siren,statusUpdate,panicAlert,beingCautious;
    public TextView hello;
    public static int flagMessage = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        hello = (TextView) findViewById(R.id.hello);
        hello.setText(MainActivity2.username_+"!");

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#7612b8"));



        siren=(MaterialButton )findViewById(R.id.sirenButton);

        siren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(intent);
            }

        });

        panicAlert=(MaterialButton )findViewById(R.id.paincAlertButton);

        panicAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:9498824271"));
                /*
                Intent callIntent1 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+contact1List.get(index).toString()));
                Intent callIntent2 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+contact2List.get(index).toString()));
                Intent callIntent3 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+contact3List.get(index).toString()));
                */
                if (ActivityCompat.checkSelfPermission(MainActivity4.this,CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity4.this, "Permission not Granted", Toast.LENGTH_LONG).show();
                    return;
                }
                startActivity(callIntent);
            }
        });

        beingCautious=(MaterialButton )findViewById(R.id.beingCautiousButton);

        beingCautious.setOnClickListener(new View.OnClickListener() {
            //9498824271
            @Override
            public void onClick(View view) {
                flagMessage=1;

                //Intent callIntent1 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+contact1List.get(index).toString()));

                Intent intent = new Intent(MainActivity4.this, MapsActivity.class);
                startActivity(intent);



                //Intent callIntent2 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+contact2List.get(index).toString()));
                //Intent callIntent3 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+contact3List.get(index).toString()));

                if (ActivityCompat.checkSelfPermission(MainActivity4.this,CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity4.this, "Permission not Granted", Toast.LENGTH_LONG).show();
                    return;
                }
                //startActivity(callIntent1);
            }
        });
        statusUpdate=(MaterialButton )findViewById(R.id.statusUpdateButton);

        statusUpdate.setOnClickListener(new View.OnClickListener() {
            //9498824271
            @Override
            public void onClick(View view) {
                flagMessage=0;

                Intent intent = new Intent(MainActivity4.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_safetyMeasures:
                Intent intent = new Intent(MainActivity4.this, MainActivity9.class);
                startActivity(intent);
                break;
            case R.id.nav_emergency:
                intent = new Intent(MainActivity4.this, MainActivity8.class);
                startActivity(intent);
                break;
            case R.id.nav_fakeCall:
                intent = new Intent(MainActivity4.this, MainActivity6.class);
                startActivity(intent);
                break;
            case R.id.nav_checkSafety:
                Toast.makeText(MainActivity4.this, "4", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_location:
                intent = new Intent(MainActivity4.this, MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                intent = new Intent(MainActivity4.this, MainActivity2.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}
