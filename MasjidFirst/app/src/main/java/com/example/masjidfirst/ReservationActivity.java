
package com.example.masjidfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class ReservationActivity extends AppCompatActivity {
    Spinner mosquee;
    Spinner salat;
    Spinner nombreplaces;
    Button reserver;
    Button deconnection;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        mosquee = (Spinner) findViewById(R.id.spinner2);
        salat = (Spinner) findViewById(R.id.spinner3);
        nombreplaces = findViewById(R.id.spinner4);
        reserver = findViewById(R.id.button);
        deconnection = findViewById(R.id.button3);
        deconnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(ReservationActivity.this, firstActivity.class);
                startActivity(intToMain);
                Toast.makeText(ReservationActivity.this, "Déconnection!", Toast.LENGTH_SHORT).show();
            }

        });

        mosquee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(ReservationActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        salat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selectedItem=parent.getItemAtPosition(position).toString();
                    Toast.makeText(ReservationActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
        });
        nombreplaces.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getItemAtPosition(position).toString();
                Toast.makeText(ReservationActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        reserver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int i=nombreplaces.getSelectedItemPosition();
                if (mosquee.getSelectedItemPosition() == 0) {
                    Toast.makeText(ReservationActivity.this, "vous avez réservé " + (i+1) + " places dans la mosquée Al-IKHWA", Toast.LENGTH_SHORT).show();
                    MapsActivity.nbrplace2=MapsActivity.nbrplace2-(i+1);
                    Intent j = new Intent(ReservationActivity.this, MapsActivity.class);
                    startActivity(j);
                }
                else if (mosquee.getSelectedItemPosition()==1){
                    Toast.makeText(ReservationActivity.this, "vous avez réservé " + (i+1) + " places dans la mosquée AMAZOUJ", Toast.LENGTH_SHORT).show();
                    MapsActivity.nbrplace1=MapsActivity.nbrplace1-(i+1);
                    Intent j = new Intent(ReservationActivity.this, MapsActivity.class);
                    startActivity(j);
                }
                else if (mosquee.getSelectedItemPosition()==2){
                    Toast.makeText(ReservationActivity.this, "vous avez réservé " + (i+1) + " places dans la mosquée MOULAY ALI ECHRIF", Toast.LENGTH_SHORT).show();
                    MapsActivity.nbrplace3=MapsActivity.nbrplace3-(i+1);
                    Intent j = new Intent(ReservationActivity.this, MapsActivity.class);
                    startActivity(j);
                }

            }
        });

    }
}