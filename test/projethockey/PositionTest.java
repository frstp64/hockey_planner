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
public class PositionTest {
    
    public PositionTest() {
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
     * Test of getPositionX method, of class Position.
     */
    @Test
    public void testGetPositionX() {
        System.out.println("getPositionX");
        Position instance = new Position();
        int expResult = 0;
        int result = instance.getPositionX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositionX method, of class Position.
     */
    @Test
    public void testSetPositionX() {
        System.out.println("setPositionX");
        int posX = 0;
        Position instance = new Position();
        instance.setPositionX(posX);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionY method, of class Position.
     */
    @Test
    public void testGetPositionY() {
        System.out.println("getPositionY");
        Position instance = new Position();
        int expResult = 0;
        int result = instance.getPositionY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositionY method, of class Position.
     */
    @Test
    public void testSetPositionY() {
        System.out.println("setPositionY");
        int posY = 0;
        Position instance = new Position();
        instance.setPositionY(posY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Position.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        Position position = null;
        Position instance = new Position();
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
