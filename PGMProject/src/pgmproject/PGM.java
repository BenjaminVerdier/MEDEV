/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmproject;

import java.util.List;

/**
 *
 * @author Fabien
 */
public class PGM {
    private final int maxNiveauGris; //Le maximum des niveaux de gris possible
    private final int largeur; //Largeur de l'image
    private final int hauteur; //Hauteur de l'image
    
    private List<Integer> niveauxGris; //Les niveaux de gris des pixels de l'image
    
    /**
     * Constructeur à 4 paramètres de la classe PGM.
     * @param maxNivGris de type int : le niveau de gris maximal de l'image
     * @param largeur de type int : la largeur de l'image
     * @param hauteur de type int : la hauteur de l'image
     * @param nivGris de type List d'entiers : la liste des niveaux de gris des pixels
     */
    public PGM(int maxNivGris, int largeur, int hauteur, List<Integer> nivGris){
        maxNiveauGris = maxNivGris;
        this.largeur=largeur;
        this.hauteur=hauteur;
        niveauxGris=nivGris;
    }
    /**
     * Constructeur à 3 paramètres de la classe PGM. La liste des niveaux de gris
     * est initialisée vide.
     * @param maxNivGris de type int : le niveau de gris maximal de l'image
     * @param largeur de type int : la largeur de l'image
     * @param hauteur de type int : la hauteur de l'image
     */
    public PGM(int maxNivGris, int largeur, int hauteur){
        maxNiveauGris = maxNivGris;
        this.largeur=largeur;
        this.hauteur=hauteur;
    }
    
    /**
     * Constructeur de recopie de la classe PGM
     * @param a de type PGM : l'image à recopier
     */
    public PGM(PGM a){
        this.maxNiveauGris=a.maxNiveauGris;
        this.largeur=a.largeur;
        this.hauteur=a.hauteur;
        this.niveauxGris=a.niveauxGris;
    }
    /**
     * Getter sur l'attribut maxNiveauGris
     * @return de type int : le niveau de gris maximal de l'image
     */
    public int getMaxNiveauGris() {
        return maxNiveauGris;
    }
     /**
     * Getter sur l'attribut largeur
     * @return de type int : la largeur de l'image
     */
    public int getLargeur() {
        return largeur;
    }
     /**
     * Getter sur l'attribut hauteur
     * @return de type int : la hauteur de l'image
     */
    public int getHauteur() {
        return hauteur;
    }
     /**
     * Getter sur l'attribut niveauxGris
     * @return de type Liste d'entiers : les niveaux de gris des pixels de l'image
     */
    public List<Integer> getNiveauxGris() {
        return niveauxGris;
    }
    /**
     * Setter sur l'attribut niveauxGris
     * @param niveauxGris : la liste d'entiers qu'on veut obtenir dans l'attribut
     */
    public void setNiveauxGris(List<Integer> niveauxGris) {
        this.niveauxGris = niveauxGris;
    }
    
    
}
