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
public class ObstacleTest {
    
    public ObstacleTest() {
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
     * Test of getPosition method, of class Obstacle.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Obstacle instance = new Obstacle();
        Position expResult = null;
        Position result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Obstacle.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        Position position = null;
        Obstacle instance = new Obstacle();
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrientation method, of class Obstacle.
     */
    @Test
    public void testGetOrientation() {
        System.out.println("getOrientation");
        Obstacle instance = new Obstacle();
        Orientation expResult = null;
        Orientation result = instance.getOrientation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrientation method, of class Obstacle.
     */
    @Test
    public void testSetOrientation() {
        System.out.println("setOrientation");
        Orientation orientation = null;
        Obstacle instance = new Obstacle();
        instance.setOrientation(orientation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoryObstacle method, of class Obstacle.
     */
    @Test
    public void testGetCategoryObstacle() {
        System.out.println("getCategoryObstacle");
        Obstacle instance = new Obstacle();
        CategoryObstacle expResult = null;
        CategoryObstacle result = instance.getCategoryObstacle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryObstacle method, of class Obstacle.
     */
    @Test
    public void testSetCategoryObstacle() {
        System.out.println("setCategoryObstacle");
        CategoryObstacle categoryObstacle = null;
        Obstacle instance = new Obstacle();
        instance.setCategoryObstacle(categoryObstacle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVisible method, of class Obstacle.
     */
    @Test
    public void testIsVisible() {
        System.out.println("isVisible");
        Obstacle instance = new Obstacle();
        boolean expResult = false;
        boolean result = instance.isVisible();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVisible method, of class Obstacle.
     */
    @Test
    public void testSetVisible() {
        System.out.println("setVisible");
        boolean visible = false;
        Obstacle instance = new Obstacle();
        instance.setVisible(visible);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
