package com.example.AulIrishTales;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//SOUND ALSO CREATED BY RACHEL
//RECORDINGS BY HANNAH
//LINKED BY ZARA

public class BansheeTale extends MyActivity implements View.OnClickListener

{
    Button pageCornerbanshee;
    MediaPlayer bansheeSound ;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        if(sounds)
        {
            bansheeSound = MediaPlayer.create(BansheeTale.this, R.raw.bansheesound);
            bansheeSound.start();
        }//if

        super.onCreate(savedInstanceState);
        setContentView(R.layout.banshee);
        pageCornerbanshee= (Button) this.findViewById(R.id.banshee_button);
        pageCornerbanshee.setOnClickListener(this);
    }//onCreate

    @Override
    public void onClick(View itemClicked)
    {
        if (sounds)
        {
            bansheeSound.release();
        }//if

        setContentView(R.layout.leprechaun);
        Intent bansheeTale = new Intent(BansheeTale.this, LeprechaunTale.class);
        startActivity(bansheeTale);
    }//onClick
}//class

