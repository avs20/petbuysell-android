package com.siolabs.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


import com.siolabs.myapplication.adapters.CategoryListAdapter;
import com.siolabs.myapplication.dummy.CategoryContent;
import com.siolabs.myapplication.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a single Category detail screen.
 * This fragment is either contained in a {@link CategoryListActivity}
 * in two-pane mode (on tablets) or a {@link CategoryDetailActivity}
 * on handsets.
 */
public class CategoryDetailFragment extends ListFragment {
    /**
     * The serialization (saved instance state) Bundle key representing the
     * activated item position. Only used on tablets.
     */
    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    /**
     * The current activated item position. Only used on tablets.
     */
    private int mActivatedPosition = ListView.INVALID_POSITION;
    
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    

    private CategoryItem mItem;
    private List<CategoryItem> catList ;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CategoryDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO check here what item has been selected.
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            
            //load the sub categories string
//            System.out.println(getArguments().getString(ARG_ITEM_ID));
            String catName = getArguments().getString(ARG_ITEM_ID);
            
            if(catName.equals("Dogs")) {
                catList = new ArrayList<CategoryItem>();
                String cat[] = getResources().getStringArray(R.array.dog_sub_cat);

                for (String c : cat) {
                    catList.add(new CategoryItem(c, 1234, R.drawable.cat_image));
                }
                setListAdapter(new CategoryListAdapter(getActivity(),catList));
            }
           
            
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            // mItem = CategoryContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    private void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }
//
//    //this is the part that I have to change to get the list view in the detail also
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//
//
//
//
//        //TODO get the list of sub categories
////         String[] subCat
//
//
//
//        View rootView = inflater.inflate(R.layout.activity_category_detail, container, false);
//
//
//        //TODO populate the sub categories
//        //TODO implement the listener
//        //TODO show it to the user
//
//        // Show the dummy content as text in a TextView.
////        if (mItem != null) {
////            ((TextView) rootView.findViewById(R.id.category_detail_container)).setText(mItem.content);
////        }
//
//        return rootView;
//    }
}
