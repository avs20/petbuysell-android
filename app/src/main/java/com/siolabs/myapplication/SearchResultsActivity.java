package com.siolabs.myapplication;


import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.siolabs.myapplication.app.AppController;
import com.siolabs.myapplication.fragments.AdListFragment;
import com.siolabs.myapplication.model.AdItem;

import java.util.ArrayList;
import java.util.List;
import com.siolabs.myapplication.adapters.CustomAdListAdapter;
import com.siolabs.myapplication.adapters.CategoryFragmentPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.siolabs.myapplication.utils.SlidingTabLayout;


public class SearchResultsActivity extends ActionBarActivity implements AdListFragment.OnFragmentInteractionListener{


        // Log tag
        private static final String TAG = MainActivity.class.getSimpleName();

        // Movies json url
        private static final String url = "http://www.json-generator.com/api/json/get/cuevQeEmMi?indent=2";
        private ProgressDialog pDialog;
        private List<AdItem> movieList = new ArrayList<AdItem>();
        private ListView listView;
        private CustomAdListAdapter adapter;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search_results);
           // handleIntent(getIntent());

            // Get the ViewPager and set it's PagerAdapter so that it can display items
            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
            viewPager.setAdapter(new CategoryFragmentPagerAdapter(getSupportFragmentManager(),
                    SearchResultsActivity.this));

            // Give the SlidingTabLayout the ViewPager
            SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
            // Center the tabs in the layout
            slidingTabLayout.setDistributeEvenly(true);
            slidingTabLayout.setViewPager(viewPager);

            listView = (ListView) findViewById(R.id.list);
            adapter = new CustomAdListAdapter(this, movieList);
            listView.setAdapter(adapter);

            pDialog = new ProgressDialog(this);
            // Showing progress dialog before making http request
            pDialog.setMessage("Loading...");
            pDialog.show();

//            // changing action bar color
//            getActionBar().setBackgroundDrawable(
//                    new ColorDrawable(Color.parseColor("#1b1b1b")));
            
            
            //json parsing 
            // Creating volley request obj
            JsonArrayRequest movieReq = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.d(TAG, response.toString());
                            hidePDialog();

                            // Parsing json
                            for (int i = 0; i < response.length(); i++) {
                                try {

                                    JSONObject obj = response.getJSONObject(i);
                                    AdItem item = new AdItem();
                                    item.setTitle(obj.getString("title"));
                                    item.setThumbnailUrl(obj.getString("picture"));
                                    item.setPrice((Integer) obj.get("price"));

                                    item.setPostTime(obj.getString("postTime"));

//                                    // Genre is json array
//                                    JSONArray genreArry = obj.getJSONArray("genre");
//                                    ArrayList<String> genre = new ArrayList<String>();
//                                    for (int j = 0; j < genreArry.length(); j++) {
//                                        genre.add((String) genreArry.get(j));
//                                    }
                                    item.setCity(obj.getString("city"));

                                    // adding movie to movies array
                                    movieList.add(item);

                                } catch (JSONException e) {
                                    e.printStackTrace();


                                }

                                // notifying list adapter about data changes
                                // so that it renders the list view with updated data
                                adapter.notifyDataSetChanged();
                            }
                        }}

                        ,new Response.ErrorListener()

                        {
                            @Override
                            public void onErrorResponse(VolleyError error){
                            VolleyLog.d(TAG, "Error: " + error.getMessage());
                            hidePDialog();
                        }

                    });

            // Adding request to request queue
            AppController.getInstance().addToRequestQueue(movieReq);
        } 
                    
            @Override
            public void onDestroy() {
                super.onDestroy();
                hidePDialog();
            }

            private void hidePDialog() {
                if (pDialog != null) {
                    pDialog.dismiss();
                    pDialog = null;
                }
            }
                    
                    


//            if (savedInstanceState == null) {
//               getSupportFragmentManager().beginTransaction().add(R.id.search_list_fragment,new AdListFragment()).commit();
//            }


    


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
    
        public void chooseCategory(View v){
            Intent intent = new Intent(this, CategoryListActivity.class);
            startActivity(intent);
            
        }

}


