package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by aungaung on 10/7/2016.
 */

public class MediaArrayAdapter extends ArrayAdapter<Media> {
    public MediaArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Media object) {
        super.add(object);
    }

    @Override
    public Media getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.media_item_layout, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgPlay);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView txtArtist = (TextView) convertView.findViewById(R.id.txtArtist);
        Button btnBuy = (Button) convertView.findViewById(R.id.btnBuy);
        Button btnInfo = (Button) convertView.findViewById(R.id.btnInfo);

        Media object = getItem(position);

        txtTitle.setText(""+object.getTitle());
        txtArtist.setText(""+object.getArtist());

        return convertView;
    }

}
