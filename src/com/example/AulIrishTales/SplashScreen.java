package com.example.AulIrishTales;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Zara
 * Date: 02/04/2013
 * Time: 13:03
 * Creating the Splash screen thread.
 * CREATED BY ZARA
 */
public class SplashScreen extends Activity

{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);


    Thread thread = new Thread()
    {
        public void run()
        {
            try
            {
               //Setting the timer
               sleep(3000);
            }//try

            catch (InterruptedException e)
            {
               e.printStackTrace();
            }//catch

            finally
            {
                //Splash.this, Menu.class
                Intent loadMain = new Intent(SplashScreen.this, MainMenu.class);
                startActivity(loadMain);
            }//Finally

        }//run

    };//thread

       //Starting the thread
       thread.start();

   }//onCreate

}//class

