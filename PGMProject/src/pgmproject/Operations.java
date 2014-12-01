/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmproject;

import java.util.LinkedList;
/**
 *
 * @author tlaurent
 */
public final class Operations {
    
    public PGM seuillage(PGM img, int seuil){
        PGM result = new PGM(img);
        
        LinkedList<Integer> list = (LinkedList)img.getNiveauxGris();
        
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
    
    public PGM difference(PGM img1, PGM img2){
        try{
            if (img1.getHauteur() != img2.getHauteur() || img1.getLargeur() != img2.getLargeur()){
                throw (new DifferentSizeException());
            }
        } catch (Exception e){
            System.out.println("Les deux images doivent être de la même taille.");
        }
        
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i =0; i< img1.getNiveauxGris().size(); i++){
            list.push(Math.abs(img1.getNiveauxGris().get(i) - img2.getNiveauxGris().get(i)));
        }
        
        return new PGM(img1.getMaxNiveauGris(),img1.getHauteur(),img1.getLargeur(),list);
        
    }
    
}
