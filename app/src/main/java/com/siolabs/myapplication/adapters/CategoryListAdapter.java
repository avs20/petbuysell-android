package com.siolabs.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.siolabs.myapplication.R;
import com.siolabs.myapplication.model.CategoryItem;

import java.util.List;

/**
 * Created by ashutoshsingh on 07-02-2015.
 */
public class CategoryListAdapter extends BaseAdapter {


    private Activity activity;
    private LayoutInflater inflater;
    private List<CategoryItem> categoryItems;
    
    public CategoryListAdapter(Activity activity, List<CategoryItem> items){
        this.activity = activity;
        this.categoryItems = items;
    }
    
    
    @Override
    public int getCount() {
        return categoryItems.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.category_list_row, null);

        TextView name = (TextView) convertView.findViewById(R.id.category_name);
        TextView numItems =(TextView) convertView.findViewById(R.id.num_items_in_category);
        TextView arrow = (TextView)convertView.findViewById(R.id.category_arrow);
        ImageView catImage = (ImageView) convertView.findViewById(R.id.category_image);

        CategoryItem item = categoryItems.get(position);
        
        name.setText(item.getName());
        numItems.setText("1344");
        //TODO change it to get value from the object
        catImage.setImageResource(R.drawable.cat_image);

        return convertView;
        
    }
}
