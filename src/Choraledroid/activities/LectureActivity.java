/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Choraledroid.activities;

import Beans.Chants;
import ManagerDAO.ChantCategoriesDAO;
import ManagerDAO.ChantsDAO;
import ManagerDAO.CoupletsDAO;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pasquierase
 */
public class LectureActivity extends Activity {
    ListView liste = null;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // ToDo add your GUI initialization code here
        setContentView(R.layout.lecture);
        liste = (ListView) findViewById(R.id.listChant);
        List<String> chanson = new ArrayList<String>();
        //on cherche le chant
        ChantsDAO ch_dao = new ChantsDAO(this);
        CoupletsDAO coup_dao = new CoupletsDAO(this);
        ArrayList<String> listeChanson = new ArrayList<String>();
        ch_dao.open();
        coup_dao.open();
        //je récupere le chant et ses couplets
        Intent j = getIntent();
        int chant = j.getIntExtra("chanson", 0);
        Chants c = ch_dao.retournerChant(chant);
        listeChanson.add("ref - "+c.getRefrain());
        ch_dao.close();
        Cursor cu = coup_dao.retournerCouplet(chant);
        //ArrayList<String> listeCoupl = new ArrayList<String>();
        int cmpteur=1;
        while (cu.moveToNext()){
            //afficheToast(""+c.getInt(c.getColumnIndex("chant")));
            String coupl = new String(cu.getString(cu.getColumnIndex("textCouplet")));
            listeChanson.add(""+cmpteur+" - "+coupl);
            cmpteur++;
        }
        cu.close();
        coup_dao.close();
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        R.layout.taille, listeChanson);
        liste.setAdapter(adapter);
      
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

}
