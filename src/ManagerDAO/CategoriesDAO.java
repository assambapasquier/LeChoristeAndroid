/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagerDAO;

import Beans.Categories;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 * @catthor pasquierase
 */
public class CategoriesDAO {
     private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;
    
    public CategoriesDAO(Context context)
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
    
    public long ajouter(Categories cat) {
        // Ajout d'un enregistrement dans la table
        ContentValues values = new ContentValues();
        values.put("idCategorie", cat.getIdCategorie());
        values.put("nomCategorie", cat.getNomCategorie());
        
        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert("Categories",null,values);
    }
    
    public int supprimer(Categories cat){
        String where = "idCategorie = ?";
        String[] whereArgs = {cat.getIdCategorie()+""};

        return db.delete("Categories", where, whereArgs);
    }
    
    public int modifier(Categories cat){
        ContentValues values = new ContentValues();
    	values.put("idCategorie", cat.getIdCategorie());
        values.put("nomCategorie", cat.getNomCategorie());
        String where = "idCategorie = ?";
        String[] whereArgs = {cat.getIdCategorie()+""};
	
        return db.update("Categories", values, where, whereArgs);
    }
    
    public Categories retournerCategorie(int idCategorie){//retourner le chant dont le code est idChant
        Categories cat = new Categories();
        Cursor c = db.rawQuery("SELECT * FROM Categories WHERE idCategorie = "+idCategorie, null);
        if (c.moveToFirst()) {
            cat.setIdCategorie(c.getInt(c.getColumnIndex("idCategorie")));
            cat.setNomCategorie(c.getString(c.getColumnIndex("nomCategorie")));
            c.close();
        }
        return cat;
    }
    public Cursor tousLesCategories() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM Categories", null);
    }
}
