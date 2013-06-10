package com.example.AulIrishTales;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//RECORDINGS BY HANNAH
//SOUNDS BY RACHEL
/**
 * Created with IntelliJ IDEA.
 * User: Zara
 * Date: 02/04/2013
 * Time: 16:59
 */
public class LeprechaunTale extends MyActivity implements View.OnClickListener

{
    Button pageCornerLeprechaun;
    private MediaPlayer leprechaun;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        if(sounds)
        {

            leprechaun = MediaPlayer.create(LeprechaunTale.this, R.raw.leprechaunsound);
            leprechaun.start();
        }//if
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leprechaun);
        pageCornerLeprechaun= (Button) this.findViewById(R.id.leprechaun_button);
        pageCornerLeprechaun.setOnClickListener(this);

    }//onCreate

    @Override
    public void onClick(View itemClicked)
    {
        if (sounds)
        {
            leprechaun.release();
        }//if
        setContentView(R.layout.quiz);
        Intent leprechaunTale = new Intent(LeprechaunTale.this, Quiz.class);
        startActivity(leprechaunTale);

    }//onClick

}//class

