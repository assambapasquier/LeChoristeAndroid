/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagerDAO;

import Beans.Couplets;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 * @cothor pasquierase
 */
public class CoupletsDAO {
    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;
    
    public CoupletsDAO(Context context)
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
    
    public long ajouter(Couplets co) {
        // Ajout d'un enregistrement dans la table
        ContentValues values = new ContentValues();
        values.put("idCouplet", co.getIdCouplet());
        values.put("textCouplet", co.getTextCouplet());
        values.put("chant", co.getChant());
        values.put("rang", co.getRang());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert("Couplets",null,values);
    }
    
    public int supprimer(Couplets co){
        String where = "idCouplet = ?";
        String[] whereArgs = {co.getIdCouplet()+""};

        return db.delete("Couplets", where, whereArgs);
    }
    
    public int modifier(Couplets co){
        ContentValues values = new ContentValues();
    	values.put("idCouplet", co.getIdCouplet());
        values.put("textCouplet", co.getTextCouplet());
        values.put("chant", co.getChant());
        values.put("rang", co.getRang());
        String where = "idCouplet = ?";
        String[] whereArgs = {co.getIdCouplet()+""};
	
        return db.update("Couplets", values, where, whereArgs);
    }
    
    public Cursor retournerCouplet(int chant){//retourner le chant dont le code est idChant
        return db.rawQuery("SELECT textCouplet FROM Couplets WHERE chant = "+chant, null);
    }
    public Cursor tousLesCouplets() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM Couplets", null);
    }
}
