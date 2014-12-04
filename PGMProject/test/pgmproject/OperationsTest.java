/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmproject;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author tlaurent
 */
public class OperationsTest {
    
    public OperationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of seuillage method, of class Operations.
     */
    @Test
    public void testSeuillage() {
        System.out.println("seuillage");
        PGM img = new PGM();
        img.lecturePGM("degrade.pgm");
        int seuil = 127;
        PGM expResult = new PGM();
        expResult.lecturePGM("degradeseuille.pgm");//degrade.pgm seuillé par GIMP
        PGM result = Operations.seuillage(img, seuil);
        assertEquals(expResult, result);
        //assertEquals(expResult, result);
    }

    /**
     * Test of difference method, of class Operations.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        PGM img1 = new PGM();
        img1.lecturePGM("img1.pgm");
        PGM img2 = new PGM();
        img2.lecturePGM("img2.pgm");
        PGM expResult = new PGM();
        expResult.lecturePGM("imgdiff.pgm");
        PGM result = Operations.difference(img1, img2);
        assertEquals(expResult, result);
    }
}