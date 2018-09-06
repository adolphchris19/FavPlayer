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
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creating the arraylist of the songs
        final ArrayList<MusicTemp> songs = new ArrayList<>();
        songs.add(new MusicTemp("Adolph Chris", "10 Songs", R.drawable.songimageone ));
        songs.add(new MusicTemp("Adolph Chris", "20 Songs", R.drawable.songimagetwo ));
        songs.add(new MusicTemp("Adolph Chris", "15 Songs", R.drawable.songimagethree ));
        songs.add(new MusicTemp("Adolph Chris", "30 Songs", R.drawable.songimagefour ));
        songs.add(new MusicTemp("Adolph Chris", "2 Songs", R.drawable.songimageone ));
        songs.add(new MusicTemp("Adolph Chris", "8 Songs", R.drawable.songimagetwo ));
        songs.add(new MusicTemp("Adolph Chris", "11 Songs", R.drawable.songimagethree ));
        songs.add(new MusicTemp("Adolph Chris", "13 Songs", R.drawable.songimagefour ));
        songs.add(new MusicTemp("Adolph Chris", "6 Songs", R.drawable.songimageone ));
        songs.add(new MusicTemp("Adolph Chris", "11 Songs", R.drawable.songimagetwo ));
        songs.add(new MusicTemp("Adolph Chris", "19 Songs", R.drawable.songimagethree ));
        songs.add(new MusicTemp("Adolph Chris", "19 Songs", R.drawable.songimagefour ));
        songs.add(new MusicTemp("Adolph Chris", "11 Songs", R.drawable.songimageone ));
        songs.add(new MusicTemp("Adolph Chris", "80 Songs", R.drawable.songimagetwo ));
        songs.add(new MusicTemp("Adolph Chris", "1 Song", R.drawable.songimagethree ));
        songs.add(new MusicTemp("Adolph Chris", "33 Songs", R.drawable.songimagefour ));

        //creating the adaPter that converts the arrays into views
        ArtistAdapter adapter = new ArtistAdapter(this, songs);

        final ListView listView = findViewById(R.id.genreAndArtistList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicTemp music = songs.get(position);
                Intent i = new Intent(ArtistActivity.this, NowPlayingActivity.class);
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
                Intent i = new Intent(ArtistActivity.this, AlbumActivity.class);
                startActivity(i);
                break;

            case R.id.nav_genre:
                Intent x = new Intent(ArtistActivity.this, GenreActivity.class);
                startActivity(x);
                break;

            case R.id.nav_songs:
                Intent y = new Intent(ArtistActivity.this, SongsActivity.class);
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