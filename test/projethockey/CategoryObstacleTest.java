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
public class CategoryObstacleTest {
    
    public CategoryObstacleTest() {
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
     * Test of getCategoryName method, of class CategoryObstacle.
     */
    @Test
    public void testGetCategoryName() {
        System.out.println("getCategoryName");
        CategoryObstacle instance = new CategoryObstacle();
        String expResult = "";
        String result = instance.getCategoryName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryName method, of class CategoryObstacle.
     */
    @Test
    public void testSetCategoryName() {
        System.out.println("setCategoryName");
        String catName = "";
        CategoryObstacle instance = new CategoryObstacle();
        instance.setCategoryName(catName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImgPath method, of class CategoryObstacle.
     */
    @Test
    public void testGetImgPath() {
        System.out.println("getImgPath");
        CategoryObstacle instance = new CategoryObstacle();
        String expResult = "";
        String result = instance.getImgPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImgPath method, of class CategoryObstacle.
     */
    @Test
    public void testSetImgPath() {
        System.out.println("setImgPath");
        String imgPath = "";
        CategoryObstacle instance = new CategoryObstacle();
        instance.setImgPath(imgPath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionDefault method, of class CategoryObstacle.
     */
    @Test
    public void testGetPositionDefault() {
        System.out.println("getPositionDefault");
        CategoryObstacle instance = new CategoryObstacle();
        Position expResult = null;
        Position result = instance.getPositionDefault();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositionDefault method, of class CategoryObstacle.
     */
    @Test
    public void testSetPositionDefault() {
        System.out.println("setPositionDefault");
        Position positionDefault = null;
        CategoryObstacle instance = new CategoryObstacle();
        instance.setPositionDefault(positionDefault);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScale method, of class CategoryObstacle.
     */
    @Test
    public void testGetScale() {
        System.out.println("getScale");
        CategoryObstacle instance = new CategoryObstacle();
        int expResult = 0;
        int result = instance.getScale();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScale method, of class CategoryObstacle.
     */
    @Test
    public void testSetScale() {
        System.out.println("setScale");
        int scale = 0;
        CategoryObstacle instance = new CategoryObstacle();
        instance.setScale(scale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
