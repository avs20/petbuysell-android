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
import android.widget.Toast;

import com.siolabs.myapplication.com.siolabs.myapplication.adapters.DemoObjectFragment;


/*     my code */
    public class SearchResultsActivity extends FragmentActivity {
        // When requested, this adapter returns a DemoObjectFragment,
        // representing an object in the collection.
        AdsPagerAdapter mDemoCollectionPagerAdapter;
        ViewPager mViewPager;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search_results);
            System.out.println("In on create");
           // handleIntent(getIntent());

//            ViewPager and its adapters use support library
////            fragments, so use getSupportFragmentManager.
            mDemoCollectionPagerAdapter =
                    new AdsPagerAdapter(
                            getSupportFragmentManager(), getApplicationContext());
            mViewPager = (ViewPager) findViewById(R.id.pager);
            mViewPager.setAdapter(mDemoCollectionPagerAdapter);
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
    }

    // Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
     class AdsPagerAdapter extends FragmentStatePagerAdapter {
        
        Context context;
        
        public AdsPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new DemoObjectFragment(context);
            Bundle args = new Bundle();
            // Our object is just an integer :-P
            args.putInt(DemoObjectFragment.ARG_OBJECT, i);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "OBJECT " + (position + 1);
        }
    }

    


