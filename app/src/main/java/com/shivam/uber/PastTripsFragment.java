package com.shivam.uber;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shivam.uber.Activity.PastRideDetails;

public class PastTripsFragment extends Fragment {

    private CardView cardView;
    public PastTripsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_past_trips, container, false);
        cardView = (CardView)view.findViewById(R.id.past_rides);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),PastRideDetails.class);
                startActivity(i);
            }
        });
        return view;
    }

}
