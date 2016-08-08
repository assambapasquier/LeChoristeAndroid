/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagerDAO;

import Beans.Chants;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 * @author pasquierase
 */
public class ChantsDAO {
    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;
    
    public ChantsDAO(Context context)
    {
    	maBaseSQLite = new MySQLite(context);
    }

    public void open()
    {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        //on ferme l'accès à la BDD
        db.close();
    }
    
    public long ajouter(Chants ch) {
        // Ajout d'un enregistrement dans la table
        ContentValues values = new ContentValues();
        values.put("idChant", ch.getIdChant());
        values.put("titre", ch.getTitre());
        values.put("auteur", ch.getAuteur());
        values.put("refrain", ch.getRefrain());
        
        
        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert("Chants",null,values);
    }
    
    public int supprimer(Chants ch){
        String where = "idChant = ?";
        String[] whereArgs = {ch.getIdChant()+""};

        return db.delete("Chants", where, whereArgs);
    }
    
    public int modifier(Chants ch){
        ContentValues values = new ContentValues();
    	values.put("idChant", ch.getIdChant());
        values.put("titre", ch.getTitre());
        values.put("auteur", ch.getAuteur());
        values.put("refrain", ch.getRefrain());
        
        String where = "idChant = ?";
        String[] whereArgs = {ch.getIdChant()+""};
	
        return db.update("Chants", values, where, whereArgs);
    }
    
    public Chants retournerChant(int idChant){//retourner le chant dont le code est idChant
        Chants ch = new Chants();
        Cursor c = db.rawQuery("SELECT * FROM Chants WHERE idChant = "+idChant, null);
        if (c.moveToFirst()) {
            ch.setIdChant(c.getInt(c.getColumnIndex("idChant")));
            ch.setTitre(c.getString(c.getColumnIndex("titre")));
            ch.setAuteur(c.getString(c.getColumnIndex("auteur")));
            ch.setRefrain(c.getString(c.getColumnIndex("refrain")));
            
            c.close();
        }
        return ch;
    }
    public Cursor tousLesChants() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM Chants", null);
    }
}
