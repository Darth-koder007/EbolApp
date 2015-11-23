package com.beginner.ebolapp;

import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by vijay singh on 23-11-2015.
 */
public class MyMapFragment extends SupportMapFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GoogleMap googleMap = getMap();
        googleMap.setMyLocationEnabled(true);
    }
}
