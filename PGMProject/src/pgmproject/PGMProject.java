/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmproject;
import GUI.*;
/**
 *
 * @author akagami
 */
public class PGMProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //PGM a = new PGM();
        //a.lecturePGM("lena.pgm");
        //a.ecriturePGM("lena2");
        //Histogramme hist = new Histogramme(a);
        //hist.affichage().ecriturePGM("test_hist");
        //Operations.seuillage(a, 127).ecriturePGM("test_seuillage");
        //Operations.difference(a, a).ecriturePGM("test_difference");
        GUI window = new GUI();
        window.setVisible(true);
    }
    
}
