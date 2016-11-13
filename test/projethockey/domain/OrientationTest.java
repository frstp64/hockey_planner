/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

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
public class OrientationTest {
    
    public OrientationTest() {
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
     * Test of getAngle method, of class Orientation.
     */
    @Test
    public void testGetAngle() {
        System.out.println("getAngle");
        Orientation instance = new Orientation();
        int expResult = 0;
        int result = instance.getAngle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAngle method, of class Orientation.
     */
    @Test
    public void testSetAngle() {
        System.out.println("setAngle");
        int angle = 0;
        Orientation instance = new Orientation();
        instance.setAngle(angle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
