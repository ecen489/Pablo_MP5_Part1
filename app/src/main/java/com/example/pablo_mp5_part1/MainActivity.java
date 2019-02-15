package com.example.pablo_mp5_part1;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // THIS IS THE MUSIC PLAYER

    MediaPlayer mp;
    String currmp = "";
    String pastmp = "";
    Boolean stopped = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = (ImageView) findViewById(R.id.showpic);
        img.setVisibility(View.INVISIBLE);
    }

    public void play(View view) {
        if(mp.isPlaying() && currmp != pastmp) {
            mp.reset();
            change();
        } else if(stopped == true) {
            change();
        }
        stopped = false;
        mp.start();
    }

    public void pause(View view) {
        mp.pause();
    }

    public void stop(View view) {
        stopped = true;
        mp.reset();
    }

    public void radioClick(View view) {
        ImageView img = (ImageView) findViewById(R.id.showpic);
        int id = view.getId();
        img.setVisibility(View.VISIBLE);

        stopped = true;

        pastmp = currmp;

        if(id == R.id.weareone) {
            img.setImageResource(R.drawable.onepic);
            currmp = "onesong";
        } else if(id == R.id.sono) {
            img.setImageResource(R.drawable.sonopic);
            currmp = "jojo";
        } else if(id == R.id.ted){
            img.setImageResource(R.drawable.emptypic);
            currmp = "tedisempty";
        }

        if(pastmp == "") {
            pastmp = currmp;
            change();
        }
    }

    public void change() {
        if(currmp == "onesong") {
            mp = MediaPlayer.create(this,R.raw.onesong);
        } else if(currmp == "jojo") {
            mp = MediaPlayer.create(this,R.raw.jojo);
        } else if(currmp == "tedisempty") {
            mp = MediaPlayer.create(this,R.raw.tedisempty);
        }
    }
}
