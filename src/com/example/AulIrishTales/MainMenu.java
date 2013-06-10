package com.example.AulIrishTales;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//SOUNDS CREATED BY HANNAH AND RACHEL
/**
 * Created with IntelliJ IDEA.
 * User: Zara
 * Date: 02/04/2013
 * Time: 16:29
 * A class for the quiz menu
 */
public class MainMenu extends MyActivity implements View.OnClickListener
{
    Button beginTalesWithoutSound,beginTalesWithSound;

    MediaPlayer ourSong;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        ourSong = MediaPlayer.create(MainMenu.this, R.raw.dublin);
        ourSong.start();

        //Setting up the button and the listener
        beginTalesWithoutSound= (Button) this.findViewById(R.id.no_play_button);
        beginTalesWithoutSound.setOnClickListener(this);

        beginTalesWithSound= (Button) this.findViewById(R.id.play_button);
        beginTalesWithSound.setOnClickListener(this);

    }//onCreate

    @Override
    public void onClick(View view)
    {
       if (beginTalesWithSound.getId() == (view).getId())
       {
            sounds = true;
       }//if

       //Creating the intent telling it where it is and where it has to go. Also starting it.
       ourSong.release();
       Intent playTales = new Intent(MainMenu.this, FairyTales.class);
       startActivity(playTales);
    }//onClick

}//class

