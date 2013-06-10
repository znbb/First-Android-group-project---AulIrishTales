package com.example.AulIrishTales;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

//CREATED BY ZARA
//APP PUT TOGETHER BY ZARA

/**
 * Created with IntelliJ IDEA.
 * User: Zara
 * Date: 02/04/2013
 * Time: 17:01
 * Credit Page
 */
public class CreditPage extends Activity implements RatingBar.OnRatingBarChangeListener

{
    private RatingBar ratingBar;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditpage);

        //Setting up the rating bar
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        //Setting the listener on the rating bar.
        ratingBar.setOnRatingBarChangeListener(this);
    }//onCreate

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b)
    {
        //A toast to show what rating the user has entered.
        Toast.makeText(CreditPage.this,
                String.valueOf(ratingBar.getRating()),
                Toast.LENGTH_SHORT).show();

        //Taking the user back to the main menu
        Intent phoneMainMenu = new Intent(Intent.ACTION_MAIN);
        phoneMainMenu.addCategory(Intent.CATEGORY_HOME);
        phoneMainMenu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(phoneMainMenu);
    }//onRatingChanged

}//class

