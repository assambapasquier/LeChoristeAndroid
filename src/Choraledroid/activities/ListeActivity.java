/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Choraledroid.activities;

import ManagerDAO.ChantCategoriesDAO;
import ManagerDAO.ChantsDAO;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pasquierase
 */
public class ListeActivity extends Activity {
    ListView liste = null;
    int premierId = 0;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // ToDo add your GUI initialization code here
        setContentView(R.layout.liste);
        liste = (ListView) findViewById(R.id.listChant);
        List<String> chants = new ArrayList<String>();
        //on cherche les chants
        ChantCategoriesDAO ch_cat_dao = new ChantCategoriesDAO(this);
        ChantsDAO ch_dao = new ChantsDAO(this);
        ch_cat_dao.open();
        ch_dao.open();
        //je récupere la categorie
        Intent j = getIntent();
        int cat = j.getIntExtra("categorie", 0);
        Cursor c = ch_cat_dao.retournerChants(cat); //liste des chant dont la cat a ete choisie
        boolean premier = false;
        while (c.moveToNext()){
            //afficheToast(""+c.getInt(c.getColumnIndex("chant")));
            String chanson = new String(((ch_dao.retournerChant(c.getInt(c.getColumnIndex("chant")))).getTitre()));
            //afficheToast(chanson);
            if(premier==false){
                premierId = c.getInt(c.getColumnIndex("chant"));
                premier = true;
            }
            chants.add(chanson);
        }
        c.close();
        ch_cat_dao.close();
        ch_dao.close();
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        R.layout.taille, chants);
        liste.setAdapter(adapter);
        liste.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             afficherChant(position+premierId);
         }
         });
    }
    //lorsque l'activité a termine son cycle de vie
    //on fait les nettoyage et les vidange (de la memoire utilisé)
    @Override
    protected void onDestroy() {
            //le code se met ici avant destroy()
            
            super.onDestroy();
    }

    //lorsque l'activité démarre
    @Override
    protected void onStart() {
            super.onStart();
            //le code se met ici apres start()
    }

    //lorsque l'activité passe en arrière Plan
    @Override
    protected void onStop() {
            //le code se met ici avant onStop()
            super.onStop();
    }

    //lorsque l'activité revient de la veille
    @Override
    protected void onRestart() {
            super.onRestart();
            //le code se met ici
    }

    //lorsque l'activité va en pause
    @Override
    protected void onPause(){
            //le code ici
            //Intent i = new Intent(this, MainActivity.class);
            //startActivity(i);
            super.onPause();
    }

    //lorsque l'activité revient de la pause
    @Override
    protected void onResume(){
            super.onResume();
            //le code ici
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
    
    protected void afficherChant(int position){
        Intent k = new Intent(ListeActivity.this, LectureActivity.class);
        k.putExtra("chanson", position);
        startActivityForResult(k,10);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
