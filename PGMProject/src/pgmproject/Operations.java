/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmproject;

import java.util.ArrayList;
/**
 * Regroupe les fonctions de seuillage et de comparaison de deux images.
 * @author tlaurent
 */
public final class Operations {
    
    /**
     * Réalise le seuillage d'une image.
     * @param img de type PGM : L'image à seuiller.
     * @param seuil de type int : Le seuil à respecter.
     * @return : L'image après seuillage.
     */
    public static PGM seuillage(PGM img, int seuil){
        PGM result = new PGM(img);
        
        ArrayList<Integer> list;
        list = (ArrayList<Integer>) img.getNiveauxGris();
        
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) < seuil){
                list.set(i, 0);
            }
            else{
                list.set(i,img.getMaxNiveauGris());
            }
        }
        result.setNiveauxGris(list);
        return result;
    }
    
    /**
     * Réalise la différence en valeur absolue entre deux images
     * @param img1 de type PGM : La première image à comparer.
     * @param img2 de type PGM : La secoonde image à comparer.
     * @return : La différence entre les deux images.
     */
    public static PGM difference(PGM img1, PGM img2){
        try{
            if (img1.getHauteur() != img2.getHauteur() || img1.getLargeur() != img2.getLargeur()){
                throw (new DifferentSizeException());
            }
        } catch (Exception e){
            System.out.println("Les deux images doivent être de la même taille.");
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i =0; i< img1.getNiveauxGris().size(); i++){
            list.add(Math.abs(img1.getNiveauxGris().get(i) - img2.getNiveauxGris().get(i)));
            System.out.println(img1.getNiveauxGris().get(i) - img2.getNiveauxGris().get(i));
        }
        
        return new PGM(img1.getMaxNiveauGris(),img1.getHauteur(),img1.getLargeur(),list);
        
    }
    
}
