package com.example.AulIrishTales;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Created by Zara

/**
 * Created with IntelliJ IDEA.
 * User: Zara
 * Date: 02/04/2013
 * Time: 16:59
 */
public class StPatrickTale extends MyActivity implements View.OnClickListener

{
    Button pageCornerBanshee;
    private MediaPlayer stPatrickSound;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        if(sounds)
        {
            stPatrickSound = MediaPlayer.create(StPatrickTale.this, R.raw.stpaticksound);
            stPatrickSound.start();
        }//if

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stpatrick);
        pageCornerBanshee= (Button) this.findViewById(R.id.stpatrick_button);
        pageCornerBanshee.setOnClickListener(this);

    }//onCreate

    @Override
    public void onClick(View view)
    {
        if (sounds) //if playing
        {
            stPatrickSound.release();
        }//if

        setContentView(R.layout.banshee);
        Intent bansheeTale = new Intent(StPatrickTale.this, BansheeTale.class);
        startActivity(bansheeTale);

    }//onClick

}//class

