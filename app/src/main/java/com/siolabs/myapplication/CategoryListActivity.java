package com.siolabs.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.siolabs.myapplication.adapters.CategoryListAdapter;
import com.siolabs.myapplication.model.AdItem;
import com.siolabs.myapplication.model.CategoryItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * An activity representing a list of Categories. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CategoryDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link CategoryListFragment} and the item details
 * (if present) is a {@link CategoryDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link CategoryListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class CategoryListActivity extends FragmentActivity
        implements CategoryListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane = false ;
    
    private CategoryListAdapter adapter;
    private List<CategoryItem> items = new ArrayList<CategoryItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        
//        String[] cat = getResources().getStringArray(R.array.categories);
        
//        //TODO code here to get the number of items from the server
//        for(String c : cat){
//            items.add(new CategoryItem(c, 1234,7823));
//        }
//
//        adapter = new CategoryListAdapter(this, items );
//
//
//
        

          //commented this so that it is always in 1 pane mode
//        if (findViewById(R.id.category_detail_container) != null) {
//            // The detail container view will be present only in the
//            // large-screen layouts (res/values-large and
//            // res/values-sw600dp). If this view is present, then the
//            // activity should be in two-pane mode.
//            mTwoPane = true;
//
//            // In two-pane mode, list items should be given the
//            // 'activated' state when touched.
//            ((CategoryListFragment) getSupportFragmentManager()
//                    .findFragmentById(R.id.category_list))
//                    .setActivateOnItemClick(true);
//        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link CategoryListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(CategoryItem selectedCat) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            //TODO Either remove this whole code or change the line below
//            arguments.put(CategoryDetailFragment.ARG_ITEM_ID, id);
            CategoryDetailFragment fragment = new CategoryDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.category_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            
            if(selectedCat.isFinal()){
                //TODO send the request to server to get the ads
                Intent detailIntent = new Intent(this, CategoryDetailActivity.class);
                detailIntent.putExtra(CategoryDetailFragment.ARG_ITEM_ID, selectedCat.getName());
                startActivity(detailIntent);
            }else{
                //TODO start the  DetailActivity
                Intent detailIntent = new Intent(this, CategoryDetailActivity.class);
                detailIntent.putExtra(CategoryDetailFragment.ARG_ITEM_ID, selectedCat.getName());
                startActivity(detailIntent);
            }
            
            
        }
    }
}