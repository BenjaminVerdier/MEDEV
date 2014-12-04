/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmproject;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Fabien
 */
public class PGMTest {
    
    public PGMTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of lecturePGM method, of class PGM.
     */
    @Test
    public void testLecturePGM() {
        System.out.println("lecturePGM");
        PGM a = new PGM();
        a.lecturePGM("lena.pgm");
        PGM b = new PGM();
        b.lecturePGM("Iena.pgm");
        assertEquals(512, a.getHauteur());
        assertEquals(512, a.getLargeur());
        assertEquals(255, a.getMaxNiveauGris());
        assertTrue(a.equals(b));
    }

    /**
     * Test of ecriturePGM method, of class PGM.
     */
    @Test
    public void testEcriturePGM() {
        System.out.println("ecriturePGM");
        PGM a = new PGM();
        a.lecturePGM("lena.pgm");
        PGM b = new PGM();
        a.ecriturePGM("lena2");
        b.lecturePGM("lena2.pgm");
        assertTrue(a.equals(b));
    }
    
}
