package com.adolphchris.android.musicpayerapplication;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creating the arraylist of the songs
        final ArrayList<MusicTemp> songs = new ArrayList<>();
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimageone ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagetwo ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagethree ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagefour ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimageone ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagetwo ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagethree ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagefour ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimageone ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagetwo ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagethree ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagefour ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimageone ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagetwo ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagethree ));
        songs.add(new MusicTemp("Holy is the Lord", "Chris", R.drawable.songimagefour ));

        //creating the adaPter that converts the arrays into views
        MusicAdapter adapter = new MusicAdapter(this, songs);

        final ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicTemp music = songs.get(position);
                Intent i = new Intent(SongsActivity.this, NowPlayingActivity.class);
                startActivity(i);
            }
        });

        //drawer navigation
        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
             drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
