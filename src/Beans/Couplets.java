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
public class Couplets {
    private int idCouplet;
    private String textCouplet;
    private int chant;
    private int rang;

    public Couplets(int idCouplet, String textCouplet, int chant, int rang) {
        super();
        this.idCouplet = idCouplet;
        this.textCouplet = textCouplet;
        this.chant = chant;
        this.rang = rang;
    }
    public Couplets() {
        super(); 
    }

    public int getIdCouplet() {
        return idCouplet;
    }

    public void setIdCouplet(int idCouplet) {
        this.idCouplet = idCouplet;
    }

    public String getTextCouplet() {
        return textCouplet;
    }

    public void setTextCouplet(String textCouplet) {
        this.textCouplet = textCouplet;
    }

    public int getChant() {
        return chant;
    }

    public void setChant(int chant) {
        this.chant = chant;
    }
    
    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

}
