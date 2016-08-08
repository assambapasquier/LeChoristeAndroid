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
public class ChantCategories {
    private int chant;
    private int categorie;

    public ChantCategories(int chant, int categorie) {
        super();
        this.chant = chant;
        this.categorie = categorie;
    }
    public ChantCategories() {
        super();
        
    }

    public int getChant() {
        return chant;
    }

    public void setChant(int chant) {
        this.chant = chant;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }
}
