/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagerDAO;

import Beans.Audios;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 * @author pasquierase
 */
public class AudiosDAO {
    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;
    
    public AudiosDAO(Context context)
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
    
    public long ajouter(Audios au) {
        // Ajout d'un enregistrement dans la table
        ContentValues values = new ContentValues();
        values.put("idAudio", au.getIdAudio());
        values.put("cheminAudio", au.getCheminAudio());
        values.put("taille", au.getTaille());
        values.put("chant", au.getChant());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert("Audios",null,values);
    }
    
    public int supprimer(Audios au){
        String where = "idAudio = ?";
        String[] whereArgs = {au.getIdAudio()+""};

        return db.delete("Audios", where, whereArgs);
    }
    
    public int modifier(Audios au){
        ContentValues values = new ContentValues();
    	values.put("idAudio", au.getIdAudio());
        values.put("cheminAudio", au.getCheminAudio());
        values.put("taille", au.getTaille());
        values.put("chant", au.getChant());
        String where = "idAudio = ?";
        String[] whereArgs = {au.getIdAudio()+""};
	
        return db.update("Audios", values, where, whereArgs);
    }
    
    public Audios retournerAudio(int idAudio){//retourner le chant dont le code est idChant
        Audios au = new Audios();
        Cursor c = db.rawQuery("SELECT * FROM Audios WHERE idAudio = "+idAudio, null);
        if (c.moveToFirst()) {
            au.setIdAudio(c.getInt(c.getColumnIndex("idAudio")));
            au.setCheminAudio(c.getString(c.getColumnIndex("chemin")));
            au.setTaille(c.getInt(c.getColumnIndex("taille")));
            au.setChant(c.getInt(c.getColumnIndex("chant")));
            c.close();
        }
        return au;
    }
    public Cursor tousLesAudios() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM Audios", null);
    }
}
