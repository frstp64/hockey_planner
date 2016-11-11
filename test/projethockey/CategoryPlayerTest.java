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
public class CategoryPlayerTest {
    
    public CategoryPlayerTest() {
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
     * Test of getCategoryName method, of class CategoryPlayer.
     */
    @Test
    public void testGetCategoryName() {
        System.out.println("getCategoryName");
        CategoryPlayer instance = new CategoryPlayer();
        String expResult = "";
        String result = instance.getCategoryName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryName method, of class CategoryPlayer.
     */
    @Test
    public void testSetCategoryName() {
        System.out.println("setCategoryName");
        String catName = "";
        CategoryPlayer instance = new CategoryPlayer();
        instance.setCategoryName(catName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImgPath method, of class CategoryPlayer.
     */
    @Test
    public void testGetImgPath() {
        System.out.println("getImgPath");
        CategoryPlayer instance = new CategoryPlayer();
        String expResult = "";
        String result = instance.getImgPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImgPath method, of class CategoryPlayer.
     */
    @Test
    public void testSetImgPath() {
        System.out.println("setImgPath");
        String imgPath = "";
        CategoryPlayer instance = new CategoryPlayer();
        instance.setImgPath(imgPath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionDefault method, of class CategoryPlayer.
     */
    @Test
    public void testGetPositionDefault() {
        System.out.println("getPositionDefault");
        CategoryPlayer instance = new CategoryPlayer();
        Position expResult = null;
        Position result = instance.getPositionDefault();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositionDefault method, of class CategoryPlayer.
     */
    @Test
    public void testSetPositionDefault() {
        System.out.println("setPositionDefault");
        Position positionDefault = null;
        CategoryPlayer instance = new CategoryPlayer();
        instance.setPositionDefault(positionDefault);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScale method, of class CategoryPlayer.
     */
    @Test
    public void testGetScale() {
        System.out.println("getScale");
        CategoryPlayer instance = new CategoryPlayer();
        int expResult = 0;
        int result = instance.getScale();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScale method, of class CategoryPlayer.
     */
    @Test
    public void testSetScale() {
        System.out.println("setScale");
        int scale = 0;
        CategoryPlayer instance = new CategoryPlayer();
        instance.setScale(scale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
