package com.siolabs.myapplication.adapters;

import android.content.Context;
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
        public  String[] prices ;
        public  String[] titles;
        public  String[] desc ;
        public  String[]  loca;
        public  String[] users ;
    
        Context context;
    
        public DemoObjectFragment(){}
    
        public DemoObjectFragment(Context c){
            this.context = c;
            prices = context.getResources().getStringArray(R.array.dog_prices);
            titles = context.getResources().getStringArray(R.array.dog_title);
            desc = context.getResources().getStringArray(R.array.dog_desc);
            loca = context.getResources().getStringArray(R.array.dog_locations);
            users = context.getResources().getStringArray(R.array.user_name);
            
        }
    
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
    
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }
}