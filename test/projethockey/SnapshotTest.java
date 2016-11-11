/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey;

import java.util.Date;
import java.util.List;
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
public class SnapshotTest {
    
    public SnapshotTest() {
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
     * Test of getIdChange method, of class Snapshot.
     */
    @Test
    public void testGetIdChange() {
        System.out.println("getIdChange");
        Snapshot instance = new Snapshot();
        int expResult = 0;
        int result = instance.getIdChange();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdChange method, of class Snapshot.
     */
    @Test
    public void testSetIdChange() {
        System.out.println("setIdChange");
        int idChange = 0;
        Snapshot instance = new Snapshot();
        instance.setIdChange(idChange);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListPlayer method, of class Snapshot.
     */
    @Test
    public void testGetListPlayer() {
        System.out.println("getListPlayer");
        Snapshot instance = new Snapshot();
        List<Player> expResult = null;
        List<Player> result = instance.getListPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListPlayer method, of class Snapshot.
     */
    @Test
    public void testSetListPlayer() {
        System.out.println("setListPlayer");
        List<Player> listPlayer = null;
        Snapshot instance = new Snapshot();
        instance.setListPlayer(listPlayer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListObstacle method, of class Snapshot.
     */
    @Test
    public void testGetListObstacle() {
        System.out.println("getListObstacle");
        Snapshot instance = new Snapshot();
        List<Obstacle> expResult = null;
        List<Obstacle> result = instance.getListObstacle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListObstacle method, of class Snapshot.
     */
    @Test
    public void testSetListObstacle() {
        System.out.println("setListObstacle");
        List<Obstacle> listObstacle = null;
        Snapshot instance = new Snapshot();
        instance.setListObstacle(listObstacle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTrashed method, of class Snapshot.
     */
    @Test
    public void testIsTrashed() {
        System.out.println("isTrashed");
        Snapshot instance = new Snapshot();
        boolean expResult = false;
        boolean result = instance.isTrashed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTrashed method, of class Snapshot.
     */
    @Test
    public void testSetTrashed() {
        System.out.println("setTrashed");
        boolean trashed = false;
        Snapshot instance = new Snapshot();
        instance.setTrashed(trashed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeStamp method, of class Snapshot.
     */
    @Test
    public void testGetTimeStamp() {
        System.out.println("getTimeStamp");
        Snapshot instance = new Snapshot();
        Date expResult = null;
        Date result = instance.getTimeStamp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimeStamp method, of class Snapshot.
     */
    @Test
    public void testSetTimeStamp() {
        System.out.println("setTimeStamp");
        Date timeStamp = null;
        Snapshot instance = new Snapshot();
        instance.setTimeStamp(timeStamp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeSnapshot method, of class Snapshot.
     */
    @Test
    public void testGetTypeSnapshot() {
        System.out.println("getTypeSnapshot");
        Snapshot instance = new Snapshot();
        String expResult = "";
        String result = instance.getTypeSnapshot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTypeSnapshot method, of class Snapshot.
     */
    @Test
    public void testSetTypeSnapshot() {
        System.out.println("setTypeSnapshot");
        String typeSnapshot = "";
        Snapshot instance = new Snapshot();
        instance.setTypeSnapshot(typeSnapshot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrCreateListPlayer method, of class Snapshot.
     */
    @Test
    public void testGetOrCreateListPlayer() {
        System.out.println("getOrCreateListPlayer");
        Snapshot instance = new Snapshot();
        List<Player> expResult = null;
        List<Player> result = instance.getOrCreateListPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrCreateListObstacle method, of class Snapshot.
     */
    @Test
    public void testGetOrCreateListObstacle() {
        System.out.println("getOrCreateListObstacle");
        Snapshot instance = new Snapshot();
        List<Obstacle> expResult = null;
        List<Obstacle> result = instance.getOrCreateListObstacle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
