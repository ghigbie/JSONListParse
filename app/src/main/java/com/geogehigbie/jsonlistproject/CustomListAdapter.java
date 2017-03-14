package com.geogehigbie.jsonlistproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by georgehigbie on 3/13/17.
 */

public class CustomListAdapter extends ArrayAdapter<String> {

    public CustomListAdapter(Context context, String[] values) {
        super(context, R.layout.list_item_custom, values);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.list_item_custom, parent, false);

        String item = getItem(position);

        TextView textView1 = (TextView) customView.findViewById(R.id.list_name);
        TextView textView2 = (TextView) customView.findViewById(R.id.list_phone);
        ImageView imageView = (ImageView) customView.findViewById(R.id.list_icon);

        textView1.setText(item);
        textView2.setText(item);
        imageView.setImageResource(R.drawable.mailicon);

        return customView;

    }
}