/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

import projethockey.domain.CategoryPlayer;
import projethockey.domain.Position;
import projethockey.domain.Player;
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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of getObjectAssocied method, of class Player.
     */
    @Test
    public void testGetObjectAssocied() {
        System.out.println("getObjectAssocied");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getObjectAssocied();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObjectAssocied method, of class Player.
     */
    @Test
    public void testSetObjectAssocied() {
        System.out.println("setObjectAssocied");
        int objectAssocied = 0;
        Player instance = new Player();
        instance.setObjectAssocied(objectAssocied);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoryPlayer method, of class Player.
     */
    @Test
    public void testGetCategoryPlayer() {
        System.out.println("getCategoryPlayer");
        Player instance = new Player();
        CategoryPlayer expResult = null;
        CategoryPlayer result = instance.getCategoryPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryPlayer method, of class Player.
     */
    @Test
    public void testSetCategoryPlayer() {
        System.out.println("setCategoryPlayer");
        CategoryPlayer categoryPlayer = null;
        Player instance = new Player();
        instance.setCategoryPlayer(categoryPlayer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrientation method, of class Player.
     */
    @Test
    public void testGetOrientation() {
        System.out.println("getOrientation");
        Player instance = new Player();
        Orientation expResult = null;
        Orientation result = instance.getOrientation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrientation method, of class Player.
     */
    @Test
    public void testSetOrientation() {
        System.out.println("setOrientation");
        Orientation orientation = null;
        Player instance = new Player();
        instance.setOrientation(orientation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class Player.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Player instance = new Player();
        Position expResult = null;
        Position result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Player.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        Position position = null;
        Player instance = new Player();
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class Player.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Player instance = new Player();
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRole method, of class Player.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        Player instance = new Player();
        instance.setRole(role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVisible method, of class Player.
     */
    @Test
    public void testIsVisible() {
        System.out.println("isVisible");
        Player instance = new Player();
        boolean expResult = false;
        boolean result = instance.isVisible();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVisible method, of class Player.
     */
    @Test
    public void testSetVisible() {
        System.out.println("setVisible");
        boolean visible = false;
        Player instance = new Player();
        instance.setVisible(visible);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
