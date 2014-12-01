/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmproject;

import java.util.LinkedList;
/**
 * Histogramme d'une image PGM.
 * @author tlaurent
 */
public class Histogramme {
    
    private int[] valeurs;
    
    /**
     * Constructeur par défaut, construit un tableau de 256 entiers nuls.
     */
    public Histogramme() {
        valeurs = new int[256];
    }
    /**
     * Constructeur pour tout niveau de gris maximum.
     * @param img 
     */
    public Histogramme(PGM img) {
        valeurs = new int[img.getMaxNiveauGris()+1];
        this.analyse(img);
    }
    
    /**
     * Analyse l'image PGM en paramètre pour obtenir les niveaux de gris.
     * @param img de type PGM : Image à analyser
     */
    public void analyse(PGM img){
        for(int i : img.getNiveauxGris()){
            valeurs[i]++;
        }
    }
    
    /**
     * Renvoie le nombre maximal d'apparitions de niveau de gris dans l'histogramme.
     * @return : Le maximum de l'attribut valeurs.
     */
    public int getMaxValeurs(){
        int max = 0;
        for(int i : this.valeurs){
            if (i > max){
                max = i;
            }
        }
        return max;
    }
    
    /**
     * Génération de l'histogramme en PGM
     * @return : Renvoie l'histogramme sous la forme d'un objet PGM que l'on pourra afficher.
     */
    public PGM affichage(){
        PGM img = new PGM(255, valeurs.length*5, this.getMaxValeurs());
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i = this.getMaxValeurs(); i > 0; i--){
            for (int j = 0; j < valeurs.length; j++){
                if (valeurs[j] >= i){
                    list.push(255);
                    list.push(255);
                    list.push(255);
                    list.push(255);
                    list.push(0);
                }
                else {
                    list.push(0);
                    list.push(0);
                    list.push(0);
                    list.push(0);
                    list.push(0);
                }
            }
        }
        img.setNiveauxGris(list);
        return img;
    }
}
