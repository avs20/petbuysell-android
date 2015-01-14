package com.siolabs.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.siolabs.myapplication.adapters.DemoObjectFragment;
import com.siolabs.myapplication.fragments.AdListFragment;



    public class SearchResultsActivity extends ActionBarActivity implements AdListFragment.OnFragmentInteractionListener{

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search_results);
           // handleIntent(getIntent());

            if (savedInstanceState == null) {
               getSupportFragmentManager().beginTransaction().add(R.id.search_list_fragment,new AdListFragment()).commit();
            }

        }

         private void handleIntent(Intent intent) {
            if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
                //TODO: parse the query from the previous screen and get the results from the internet
                System.out.println("Got the intent");
                String query = intent.getStringExtra(SearchManager.QUERY);
                //use the query to search your data somehow
                Toast.makeText(getApplicationContext(), "Got the message"+query, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onNewIntent(Intent intent){
            handleIntent(intent);
        }


        @Override
        public void onFragmentInteraction(String id) {
            //TODO: Pass the search result arraylist to the single Result Activity
            Toast.makeText(this, "Success" + id, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SingleResultActivity.class);
            intent.putExtra("id", Integer.parseInt(id));
            startActivity(intent);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu items for use in the action bar
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.search_results_options_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }

}


