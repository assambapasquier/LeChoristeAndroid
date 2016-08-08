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
public class Chants {
    private int idChant;
    private String titre;
    private String refrain;
    private String auteur;

    public Chants(int idChant, String titre, String refrain, String auteur) {
        super();
        this.idChant = idChant;
        this.titre = titre;
        this.refrain = refrain;
        this.auteur = auteur;
    }

     public Chants() {
        super();
    }

    
    /**
     * @return the idChant
     */
    public int getIdChant() {
        return idChant;
    }

    /**
     * @param idChant the idChant to set
     */
    public void setIdChant(int idChant) {
        this.idChant = idChant;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the refrain
     */
    public String getRefrain() {
        return refrain;
    }

    /**
     * @param refrain the refrain to set
     */
    public void setRefrain(String refrain) {
        this.refrain = refrain;
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @param auteur the auteur to set
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
   
}
