package controllers;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import models.Bussiness;

public class BussinessController {

    public void writeNewBussiness(DatabaseReference mDatabase, String nameBussiness, String ruc, String city, String address) {
        Bussiness bussiness = new Bussiness();
        bussiness.setNameBussinnes(nameBussiness);
        bussiness.setRuc(ruc);
        bussiness.setCity(city);
        bussiness.setAddress(address);
        String key = mDatabase.child("bussiness").push().getKey();
        mDatabase.child("bussiness").child(key).setValue(bussiness);
    }


}

