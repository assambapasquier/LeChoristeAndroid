/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

/**
 *
 * @author pasquierase
 */
public class Categories {
    private int idCategorie;
    private String nomCategorie;

    public Categories(int idCategorie, String nomCategorie) {
        super();
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }
    public Categories() {
        super();
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
 
}
