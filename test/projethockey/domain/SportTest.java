/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

import projethockey.domain.Sport;
import projethockey.domain.Orientation;
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
public class SportTest {
    
    public SportTest() {
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
     * Test of getName method, of class Sport.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Sport instance = new Sport();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Sport.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Sport instance = new Sport();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDimentionUnit method, of class Sport.
     */
    @Test
    public void testGetDimentionUnit() {
        System.out.println("getDimentionUnit");
        Sport instance = new Sport();
        String expResult = "";
        String result = instance.getDimentionUnit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDimentionUnit method, of class Sport.
     */
    @Test
    public void testSetDimentionUnit() {
        System.out.println("setDimentionUnit");
        String dimentionUnit = "";
        Sport instance = new Sport();
        instance.setDimentionUnit(dimentionUnit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbPlayer method, of class Sport.
     */
    @Test
    public void testGetNbPlayer() {
        System.out.println("getNbPlayer");
        Sport instance = new Sport();
        int expResult = 0;
        int result = instance.getNbPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNbPlayer method, of class Sport.
     */
    @Test
    public void testSetNbPlayer() {
        System.out.println("setNbPlayer");
        int nbPlayer = 0;
        Sport instance = new Sport();
        instance.setNbPlayer(nbPlayer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFieldOrientation method, of class Sport.
     */
    @Test
    public void testGetFieldOrientation() {
        System.out.println("getFieldOrientation");
        Sport instance = new Sport();
        Orientation expResult = null;
        Orientation result = instance.getFieldOrientation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFieldOrientation method, of class Sport.
     */
    @Test
    public void testSetFieldOrientation() {
        System.out.println("setFieldOrientation");
        Orientation fieldOrientation = null;
        Sport instance = new Sport();
        instance.setFieldOrientation(fieldOrientation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
