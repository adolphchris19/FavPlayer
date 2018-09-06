package com.adolphchris.android.musicpayerapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter <MusicTemp>{
    public MusicAdapter(Context context, ArrayList<MusicTemp> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MusicTemp user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_template, parent, false);
        }
        // Lookup view for data population
        ImageView album = (ImageView) convertView.findViewById(R.id.image);
        TextView title = (TextView) convertView.findViewById(R.id.song_title);
        TextView name = (TextView) convertView.findViewById(R.id.song_artist_name);
        // Populate the data into the template view using the data object
        album.setImageResource(user.imageResource);
        title.setText(user.heading);
        name.setText(user.description);
        // Return the completed view to render on screen

        return convertView;

    }
}
