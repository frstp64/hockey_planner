/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexandre
 */
public class BallonTest {
    
    public BallonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNomSport method, of class Ballon.
     */
    @Test
    public void testGetNomSport() {
        System.out.println("getNomSport");
        Ballon instance = new Ballon();
        String expResult = "";
        String result = instance.getNomSport();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomSport method, of class Ballon.
     */
    @Test
    public void testSetNomSport() {
        System.out.println("setNomSport");
        String nomSport = "";
        Ballon instance = new Ballon();
        instance.setNomSport(nomSport);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
