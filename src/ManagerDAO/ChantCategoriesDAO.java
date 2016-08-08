/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagerDAO;

import Beans.ChantCategories;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 * @author pasquierase
 */
public class ChantCategoriesDAO {

    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;
    
    public ChantCategoriesDAO(Context context)
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
    
    public long ajouter(ChantCategories ch_cat) {
        // Ajout d'un enregistrement dans la table
        ContentValues values = new ContentValues();
        values.put("chant", ch_cat.getChant());
        values.put("categorie", ch_cat.getCategorie());
        
        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert("ChantCategories",null,values);
    }
    
    public int supprimer(ChantCategories ch_cat){
        String where = "chant = ? AND categorie = ?";
        String[] whereArgs = {ch_cat.getChant()+"",ch_cat.getCategorie()+"" };

        return db.delete("ChantCategories", where, whereArgs);
    }
    
    public int modifier(ChantCategories ch_cat){
        ContentValues values = new ContentValues();
    	values.put("chant", ch_cat.getChant());
        values.put("categorie", ch_cat.getCategorie());
        String where = "chant = ? AND categorie = ?";
        String[] whereArgs = {ch_cat.getChant()+"", ch_cat.getCategorie()+""};
        return db.update("ChantCategories", values, where, whereArgs);
    }
    
    public Cursor retournerChants(int categorie){//retourner le chant dont le code est idChant
        
        return db.rawQuery("SELECT * FROM Chants_Categories WHERE categorie = "+categorie, null);
    }
    public Cursor tousLesChantCategories() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM ChantCategories", null);
    }
}

