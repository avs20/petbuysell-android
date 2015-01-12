package com.siolabs.myapplication.com.siolabs.myapplication.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.siolabs.myapplication.R;

// Instances of this class are fragments representing a single
// object in our collection.
    public  class DemoObjectFragment extends Fragment {
    
        public static final String ARG_OBJECT= "INDEX";
        public  final String[] prices = getResources().getStringArray(R.array.dog_prices);
        public  final String[] titles = getResources().getStringArray(R.array.dog_title);
        public  final String[] desc = getResources().getStringArray(R.array.dog_desc);
        public  final String[]  loca = getResources().getStringArray(R.array.dog_locations);
        public final String[] users = getResources().getStringArray(R.array.user_name);
    

    
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {
            // The last two arguments ensure LayoutParams are inflated
            // properly.
            
           
            View rootView = inflater.inflate(
                    R.layout.single_ad_layout, container, false);
            Bundle args = getArguments();
            ((TextView) rootView.findViewById(R.id.priceTextView)).setText(prices[(args.getInt(ARG_OBJECT))]);
            ((TextView) rootView.findViewById(R.id.titleTextview)).setText(titles[(args.getInt(ARG_OBJECT))]);
            ((TextView) rootView.findViewById(R.id.descTextView)).setText(desc[(args.getInt(ARG_OBJECT))]);
            ((TextView) rootView.findViewById(R.id.locationTextView)).setText(loca[(args.getInt(ARG_OBJECT))]);
            ((TextView) rootView.findViewById(R.id.userTextView)).setText(users[(args.getInt(ARG_OBJECT))]);
            return rootView;
        }
    }