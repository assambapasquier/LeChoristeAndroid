package Choraledroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity{
    /** Called when the activity is first created. */
    MediaPlayer click;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
        /*final View imgLouange, imgAdoration, imgMesse, imgMariage, imgAutre, imgAime, imgCareme;
        imgLouange = findViewById(R.id.louange);
        imgAdoration = findViewById(R.id.adoration);
        imgMesse = findViewById(R.id.messe);
        imgMariage = findViewById(R.id.mariage);
        imgAutre = findViewById(R.id.autre);
        imgCareme = findViewById(R.id.careme);
        //imgAime = findViewById(R.id.jaime);*/
        click = MediaPlayer.create(this, R.raw.click);
        /*mPlayer = MediaPlayer.create(this, R.raw.bruit_accueil);
        mPlayer.setLooping(true);
	mPlayer.setVolume(30, 30);*/
        click.setVolume(50, 50);
        //mPlayer.start();
        
        //on fait les ecouteurs sur les images
        /*imgLouange.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                //afficheToast("Louange");
                click.start();
                listeLouange();
            }
        });*/
        
        /*imgAdoration.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
               //afficheToast("Adoration");
                click.start();
                listeAdoration();
            }
        });
        imgMesse.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                //afficheToast("Messe");
                click.start();
                listeMesse();
            }
        });
        imgMariage.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                //afficheToast("Mariage");
                click.start();
                listeMariage();
            }
        });
        imgAutre.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                //afficheToast("Autre");
                click.start();
                listeAutre();
            }
        });
        imgCareme.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                //afficheToast("Autre");
                click.start();
                listeCareme();
            }
        });*/
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

    /*@Override 
    public void onBackPressed(){
      if (mPlayer != null){
          if(mPlayer.isPlaying())
              mPlayer.stop();

          mPlayer.release();
      }
    }*/
    
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
    
    public void clickLouange(View v){
         click.start();
         listeLouange();
        //afficheToast("louange");
    }
    public void clickAdoration(View v){
         click.start();
         listeAdoration(); 
    }
    public void clickMesse(View v){
         click.start();
         listeMesse();    
    }
    public void clickCareme(View v){
         click.start();
         listeCareme();    
    }
    public void clickMariage(View v){
         click.start();
         listeMariage();    
    }
    public void clickAutre(View v){
         click.start();
         listeAutre();    
    }
    public void clickJaime(View v){
         afficheToast("j'aime");   
    }

    /*--------------------------------------------------------------------------------*/
    
    protected void listeLouange(){
        Intent i = new Intent(MainActivity.this, ListeActivity.class);
        i.putExtra("categorie", 8);
        startActivityForResult(i,0);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    protected void listeAdoration(){
        Intent i = new Intent(MainActivity.this, ListeActivity.class);
        i.putExtra("categorie", 2);
        startActivityForResult(i,0);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    protected void listeMesse(){
        Intent i = new Intent(MainActivity.this, MesseActivity.class);
        startActivityForResult(i,0);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    protected void listeMariage(){
        Intent i = new Intent(MainActivity.this, ListeActivity.class);
         i.putExtra("categorie", 4);
        startActivityForResult(i,0);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    protected void listeAutre(){
        Intent i = new Intent(MainActivity.this, ListeActivity.class);
        i.putExtra("categorie", 5);
        startActivityForResult(i,0);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
       
    }
    protected void listeCareme(){
        Intent i = new Intent(MainActivity.this, ListeActivity.class);
        i.putExtra("categorie", 23);
        startActivityForResult(i,0);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    
    
}
