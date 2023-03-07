package com.example.womennovation;

import static com.example.womennovation.MainActivity4.flagMessage;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.womennovation.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    SupportMapFragment mapFragment;
    public static LatLng latLng;
    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        client = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation();
        }
        else
        {
            ActivityCompat.requestPermissions(MapsActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
        }

        //mapFragment.getMapAsync(this);
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Task<Location> tack = client.getLastLocation();
        tack.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null)
                {
                    mapFragment.getMapAsync(new OnMapReadyCallback()
                    {
                        public void onMapReady(GoogleMap googleMap)
                        {
                            latLng = new LatLng(location.getLatitude(),location.getLongitude());
                            Toast.makeText(MapsActivity.this, "Location accessed", Toast.LENGTH_LONG).show();
                            //being cautious
                            if (flagMessage == 1)
                            {
                                Intent messageIntent = new Intent(getApplicationContext(),MapsActivity.class);
                                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,messageIntent,0);
                                SmsManager sms1 = SmsManager.getDefault();
                                sms1.sendTextMessage("9498824271",null,"BEING CAUTIOUS\nMY LOCATION:\nLATITUDE:"+latLng.latitude+"\nLONGITUDE:"+latLng.longitude,pi,null);
                                flagMessage = -1;
                                Intent intent = new Intent(MapsActivity.this, MainActivity4.class);
                                startActivity(intent);
                            }
                            //status update
                            else if (flagMessage == 0)
                            {
                                Intent messageIntent = new Intent(getApplicationContext(),MapsActivity.class);
                                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,messageIntent,0);
                                SmsManager sms1 = SmsManager.getDefault();
                                sms1.sendTextMessage("9498824271",null,"STATUS UPDATE \n\nMY LOCATION:\nLATITUDE:"+latLng.latitude+"\nLONGITUDE:"+latLng.longitude,pi,null);
                                flagMessage = -1;
                                Intent intent = new Intent(MapsActivity.this, MainActivity4.class);
                                startActivity(intent);
                            }
                            MarkerOptions options =new MarkerOptions().position(latLng).title("I am here");
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                            googleMap.addMarker(options);



                        }
                    });
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            }
        }
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }
}