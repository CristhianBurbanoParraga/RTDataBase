package com.example.rtdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import controllers.BussinessController;
import models.Bussiness;

public class MainActivity extends AppCompatActivity {

    private List<Bussiness> listBussiness = new ArrayList<Bussiness>();
    ArrayAdapter<Bussiness> arrayAdapterBussines;

    private EditText txtNameBussiness;
    private EditText txtRuc;
    private EditText txtCity;
    private EditText txtAddress;
    private ListView listView;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    BussinessController bussinessController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bussinessController = new BussinessController();

        txtNameBussiness = findViewById(R.id.namebussines);
        txtRuc = findViewById(R.id.ruc);
        txtCity = findViewById(R.id.city);
        txtAddress = findViewById(R.id.address);
        listView = findViewById(R.id.listbussiness);

        initRealtimeDataBase();

        ListarAllBussines();

    }

    private void ListarAllBussines() {
        databaseReference.child("bussiness").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listBussiness.clear();
                for (DataSnapshot objSnapshot: snapshot.getChildren()) {
                    Bussiness bussiness = objSnapshot.getValue(Bussiness.class);
                    listBussiness.add(bussiness);
                }
                arrayAdapterBussines = new ArrayAdapter<Bussiness>(MainActivity.this, android.R.layout.simple_list_item_1, listBussiness);
                listView.setAdapter(arrayAdapterBussines);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void initRealtimeDataBase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void writeBussiness(View view) {
        bussinessController.writeNewBussiness(
                databaseReference,
                txtNameBussiness.getText().toString(),
                txtRuc.getText().toString(),
                txtCity.getText().toString(),
                txtAddress.getText().toString());
        Toast.makeText(this, "Bussines registry susscefully", Toast.LENGTH_SHORT).show();
    }


}