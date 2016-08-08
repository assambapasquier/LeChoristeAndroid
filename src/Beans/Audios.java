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
public class Audios {
    private int idAudio;
    private String cheminAudio;
    private int taille;
    private int chant;

    public Audios(int idAudio, String cheminAudio, int taille, int chant) {
        super();
        this.idAudio = idAudio;
        this.cheminAudio = cheminAudio;
        this.taille = taille;
        this.chant = chant;
    }
    public Audios() {
        super();
        
    }

    public int getIdAudio() {
        return idAudio;
    }

    public void setIdAudio(int idAudio) {
        this.idAudio = idAudio;
    }

    public String getCheminAudio() {
        return cheminAudio;
    }

    public void setCheminAudio(String cheminAudio) {
        this.cheminAudio = cheminAudio;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getChant() {
        return chant;
    }

    public void setChant(int chant) {
        this.chant = chant;
    }
 
}
