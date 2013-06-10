package com.example.AulIrishTales;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


//CREATED BY ZARA
//SOUND BY RACHEL
//RECORDINGS BY HANNAH
/**
 * Created with IntelliJ IDEA.
 * User: Zara
 * Date: 02/04/2013
 * Time: 16:59
 */
public class FairyTales extends MyActivity implements View.OnClickListener

{
    Button pageCornerFairyTale;
    private MediaPlayer fairySound;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
         if (sounds)
         {
                fairySound = MediaPlayer.create(FairyTales.this, R.raw.fairysound);
                fairySound.start();
         }//if
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fairytale);
        pageCornerFairyTale= (Button) this.findViewById(R.id.fairy_button);
        pageCornerFairyTale.setOnClickListener(this);
    }//onCreate

    @Override
    public void onClick(View itemClicked)
    {
        if (sounds)
        {
            fairySound.release();
        }//if

        setContentView(R.layout.stpatrick);
        Intent stPatrick = new Intent(FairyTales.this, StPatrickTale.class);
        startActivity(stPatrick);
    }//onClick

}//class

