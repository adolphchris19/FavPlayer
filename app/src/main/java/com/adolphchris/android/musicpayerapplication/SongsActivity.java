package com.adolphchris.android.musicpayerapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    LinearLayout musicView;

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
               // Intent i = new Intent(SongsActivity.this, NowPlayingActivity.class);
               // startActivity(i);

                LinearLayout musicView = (LinearLayout) findViewById(R.id.linearLayout);
                musicView.setVisibility(View.VISIBLE);
            }
        });

       musicView = findViewById(R.id.linearLayout);
        musicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SongsActivity.this, NowPlayingActivity.class);
                startActivity(i);
            }
        });

        //drawer navigation
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_albums:
                Intent i = new Intent(SongsActivity.this, AlbumActivity.class);
                startActivity(i);
                break;

            case R.id.nav_genre:
                Intent x = new Intent(SongsActivity.this, GenreActivity.class);
                startActivity(x);
                break;

            case R.id.nav_artist:
                Intent y = new Intent(SongsActivity.this, ArtistActivity.class);
                startActivity(y);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
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


