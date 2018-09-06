package com.adolphchris.android.musicpayerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class GenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        //Creating the arraylist of the songs
        final ArrayList<MusicTemp> songs = new ArrayList<>();
        songs.add(new MusicTemp("Gospel Music", "10 Songs", R.drawable.songimageone ));
        songs.add(new MusicTemp("Country Music", "20 Songs", R.drawable.songimagetwo ));
        songs.add(new MusicTemp("Blues", "15 Songs", R.drawable.songimagethree ));
        songs.add(new MusicTemp("Afro-pop", "30 Songs", R.drawable.songimagefour ));
        songs.add(new MusicTemp("Raggae", "2 Songs", R.drawable.songimageone ));
        songs.add(new MusicTemp("Raggae-Music", "8 Songs", R.drawable.songimagetwo ));
        songs.add(new MusicTemp("Afro-Blues", "11 Songs", R.drawable.songimagethree ));
        songs.add(new MusicTemp("Hip-Hop", "13 Songs", R.drawable.songimagefour ));
        songs.add(new MusicTemp("Rap", "6 Songs", R.drawable.songimageone ));
        songs.add(new MusicTemp("Jazz", "11 Songs", R.drawable.songimagetwo ));

        //creating the adaPter that converts the arrays into views
        ArtistAdapter adapter = new ArtistAdapter(this, songs);

        final ListView listView = findViewById(R.id.genreAndArtistList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicTemp music = songs.get(position);
                Intent i = new Intent(GenreActivity.this, NowPlayingActivity.class);
                startActivity(i);
            }
        });
    }
}