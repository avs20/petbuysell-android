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


/*     my code */
    public class SearchResultsActivity extends ActionBarActivity implements AdListFragment.OnFragmentInteractionListener{
        // When requested, this adapter returns a DemoObjectFragment,
        // representing an object in the collection.
        AdsPagerAdapter mDemoCollectionPagerAdapter;
        ViewPager mViewPager;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search_results);
           // handleIntent(getIntent());

            if (savedInstanceState == null) {
               getSupportFragmentManager().beginTransaction().add(R.id.search_list_fragment,new AdListFragment()).commit();
            }

////            ViewPager and its adapters use support library
////            fragments, so use getSupportFragmentManager.
//            mDemoCollectionPagerAdapter =
//                    new AdsPagerAdapter(
//                            getSupportFragmentManager(), getApplicationContext());
//            mViewPager = (ViewPager) findViewById(R.id.pager);
//            mViewPager.setAdapter(mDemoCollectionPagerAdapter);
        }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
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


