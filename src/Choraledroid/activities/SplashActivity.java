/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Choraledroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

/**
 *
 * @author pasquierase
 */
public class SplashActivity extends Activity{
    MediaPlayer mPlayer;
    private static int SPLASH_TIME_OUT = 5000; //5 secondes
     @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.splash);
        mPlayer = MediaPlayer.create(this, R.raw.bruit_accueil);
        mPlayer.setLooping(true);
        mPlayer.setVolume(50, 50);
        mPlayer.start();
        new Handler().postDelayed(new Runnable() {
            
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
 
    }
    //lorsque l'activité a termine son cycle de vie
    //on fait les nettoyage et les vidange (de la memoire utilisé)
    @Override
    protected void onDestroy() {
            //le code se met ici avant destroy()
            mPlayer.stop();
            super.onDestroy();
    }

    //lorsque l'activité démarre
    @Override
    protected void onStart() {
            super.onStart();
            //le code se met ici apres start()
            mPlayer.start();
    }

    //lorsque l'activité passe en arrière Plan
    @Override
    protected void onStop() {
            //le code se met ici avant onStop()
        mPlayer.stop();
            super.onStop();
    }

    //lorsque l'activité revient de la veille
    @Override
    protected void onRestart() {
            super.onRestart();
            //le code se met ici
            mPlayer.start();
    }

    //lorsque l'activité va en pause
    @Override
    protected void onPause(){
            //le code ici
            //Intent i = new Intent(this, MainActivity.class);
            //startActivity(i);
        mPlayer.pause();
            super.onPause();
    }

    //lorsque l'activité revient de la pause
    @Override
    protected void onResume(){
            super.onResume();
            //le code ici
            mPlayer.start();
    }

    //sauvegarder les donnée importantes
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
            //le code ici
            super.onSaveInstanceState(savedInstanceState);
    }

    //apres onCreate on recharge les données
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
            super.onRestoreInstanceState(savedInstanceState);
            //le code ici
    }
}
