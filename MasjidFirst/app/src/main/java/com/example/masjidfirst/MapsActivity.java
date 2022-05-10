package com.example.masjidfirst;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.masjidfirst.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private MapFragment mapFragment;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;


    public static int nbrplace1 = 50;
    public static int nbrplace2 = 100;
    public static int nbrplace3 = 50;
    Button buttonR;
    Button buttonD;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        buttonD = findViewById(R.id.idbuttonD);
        buttonR = findViewById(R.id.idbuttonR);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(MapsActivity.this, firstActivity.class);
                startActivity(intToMain);
                Toast.makeText(MapsActivity.this, "Déconnection!", Toast.LENGTH_SHORT).show();

            }
        });

        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MapsActivity.this, ReservationActivity.class);
                startActivity(i);
            }

        });


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Marker m1 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.939445, -4.462354
                ))
                .anchor(0.5f, 0.5f)
                .title("Mosquée AMAZOUJ")
                .snippet("le nombre de places disponnibles est: " + nbrplace1 + " places"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(m1.getPosition(), 14));


        Marker m2 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.943617, -4.464770))
                .anchor(0.5f, 0.5f)
                .title("Mosquée AL-IKHOUA")
                .snippet("le nombre de places disponnibles est: " + nbrplace2 + " places"));


        Marker m3 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.936874, -4.451815))
                .anchor(0.5f, 0.5f)
                .title("Mosquée MOULAY ALI ACHRIF")
                .snippet("le nombre de places disponnibles est: " + nbrplace3 + " places"));
    }


}