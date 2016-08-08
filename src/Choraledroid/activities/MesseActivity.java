/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Choraledroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pasquierase
 */
public class MesseActivity extends Activity{
    ListView liste2 = null;
     @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messe);
        liste2 = (ListView) findViewById(R.id.listMesse);
        List<String> partiesMesse = new ArrayList<String>();
        partiesMesse.add("Procession");partiesMesse.add("Entrée");partiesMesse.add("Aspersion");
        partiesMesse.add("Kyrié");partiesMesse.add("Gloria");partiesMesse.add("Psaume");
        partiesMesse.add("Acclamation");partiesMesse.add("Crédo");partiesMesse.add("Prières Universelles");
        partiesMesse.add("Offrandes");partiesMesse.add("Sanctus");partiesMesse.add("Anamnèse");
        partiesMesse.add("Pater Noster");partiesMesse.add("Agnus Dei");partiesMesse.add("Communion");
        partiesMesse.add("Action de Grace"); partiesMesse.add("Envoi");
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        R.layout.taille, partiesMesse);
        liste2.setAdapter(adapter);
        liste2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            afficheChant(position+7);
         }
         });
    }
    //lorsque l'activité a termine son cycle de vie
    //on fait les nettoyage et les vidange (de la memoire utilisé)
    @Override
    protected void onDestroy() {
            //le code se met ici avant destroy()
            /*mPlayer.stop();
            mPlayer = null;*/
            super.onDestroy();
    }

    
    //lorsque l'activité démarre
    @Override
    protected void onStart() {
            super.onStart();
            //le code se met ici apres start()
            //mPlayer.start();
    }

    //lorsque l'activité passe en arrière Plan
    @Override
    protected void onStop() {
           
            super.onStop();
            /*if (mPlayer.isPlaying()) {
                mPlayer.stop();
            }*/
    }

    //lorsque l'activité revient de la veille
    @Override
    protected void onRestart() {
            super.onRestart();
            //le code se met ici
            //mPlayer.start();
    }

    //lorsque l'activité va en pause
    @Override
    protected void onPause(){
            //le code ici
            super.onPause();
            /*if (mPlayer.isPlaying()) {
                mPlayer.pause();
            }*/
    }

    //lorsque l'activité revient de la pause
    @Override
    protected void onResume(){
            super.onResume();
           /*if (mPlayer == null) {
                mPlayer = MediaPlayer.create(this, R.raw.bruit_accueil);
            }
        mPlayer.start();*/
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

    
    public void afficheToast(String text)
    {
       Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    protected void afficheChant(int categorie){
        //afficheToast(""+categorie);
        Intent i = new Intent(MesseActivity.this, ListeActivity.class);
        i.putExtra("categorie", categorie);
        startActivityForResult(i,10);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
