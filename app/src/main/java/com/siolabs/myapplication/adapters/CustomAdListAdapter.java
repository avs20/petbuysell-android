package com.siolabs.myapplication.adapters;


import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.siolabs.myapplication.R;
import com.siolabs.myapplication.app.AppController;
import com.siolabs.myapplication.model.AdItem;

import java.util.List;

/**
 * Created by ashutoshsingh on 04-02-2015.
 */
public class CustomAdListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<AdItem> adItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();


    public CustomAdListAdapter(Activity activity, List<AdItem> movieItems) {
        this.activity = activity;
        this.adItems = movieItems;
    }
    
    @Override
    public int getCount() {
        return adItems.size();
    }

    @Override
    public Object getItem(int position) {
        return adItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        TextView city = (TextView) convertView.findViewById(R.id.city);
        TextView time = (TextView) convertView.findViewById(R.id.time);
        
        
        convertView.findViewById(R.id.favorite).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                adItems.get(position).setFavorite(!adItems.get(position).isFavorite());
                notifyDataSetChanged();
                
                //TODO Add the code here to add the adItem to users personal List
            }
        });
        
        ImageView favorite = (ImageView)convertView.findViewById(R.id.favorite);

        // getting movie data for the row
        AdItem m = adItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // title
        title.setText(m.getTitle());

        // rating == price
        price.setText("$ " + String.valueOf(m.getPrice()));

        final boolean favorited = false;
        // genre == city
        String genreStr = m.getCity();
//        for (String str : m.getGenre()) {
//            genreStr += str + ", ";
//        }
//        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
//                genreStr.length() - 2) : genreStr;
        city.setText(genreStr);

        // release year == postTime
        time.setText(String.valueOf(m.getPostTime()));
        
        if(m.isFavorite())
            favorite.setImageResource(R.drawable.favorited);
        else
            favorite.setImageResource(R.drawable.favorite);
        
        
        return convertView;
        
    }
}
