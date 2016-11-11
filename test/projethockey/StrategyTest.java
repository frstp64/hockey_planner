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
public class StrategyTest {
    
    public StrategyTest() {
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
     * Test of getPlayBackSpeed method, of class Strategy.
     */
    @Test
    public void testGetPlayBackSpeed() {
        System.out.println("getPlayBackSpeed");
        Strategy instance = new Strategy();
        float expResult = 0.0F;
        float result = instance.getPlayBackSpeed();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayBackSpeed method, of class Strategy.
     */
    @Test
    public void testSetPlayBackSpeed() {
        System.out.println("setPlayBackSpeed");
        float playBackSpeed = 0.0F;
        Strategy instance = new Strategy();
        instance.setPlayBackSpeed(playBackSpeed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeltaTimeFrame method, of class Strategy.
     */
    @Test
    public void testGetDeltaTimeFrame() {
        System.out.println("getDeltaTimeFrame");
        Strategy instance = new Strategy();
        Date expResult = null;
        Date result = instance.getDeltaTimeFrame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeltaTimeFrame method, of class Strategy.
     */
    @Test
    public void testSetDeltaTimeFrame() {
        System.out.println("setDeltaTimeFrame");
        Date deltaTimeFrame = null;
        Strategy instance = new Strategy();
        instance.setDeltaTimeFrame(deltaTimeFrame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSportName method, of class Strategy.
     */
    @Test
    public void testGetSportName() {
        System.out.println("getSportName");
        Strategy instance = new Strategy();
        String expResult = "";
        String result = instance.getSportName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportName method, of class Strategy.
     */
    @Test
    public void testSetSportName() {
        System.out.println("setSportName");
        String sportName = "";
        Strategy instance = new Strategy();
        instance.setSportName(sportName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListSnapshot method, of class Strategy.
     */
    @Test
    public void testGetListSnapshot() {
        System.out.println("getListSnapshot");
        Strategy instance = new Strategy();
        List<Snapshot> expResult = null;
        List<Snapshot> result = instance.getListSnapshot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListSnapshot method, of class Strategy.
     */
    @Test
    public void testSetListSnapshot() {
        System.out.println("setListSnapshot");
        List<Snapshot> listSnapshot = null;
        Strategy instance = new Strategy();
        instance.setListSnapshot(listSnapshot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrame method, of class Strategy.
     */
    @Test
    public void testGetFrame() {
        System.out.println("getFrame");
        Strategy instance = new Strategy();
        instance.getFrame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFrame method, of class Strategy.
     */
    @Test
    public void testSetFrame() {
        System.out.println("setFrame");
        Strategy instance = new Strategy();
        instance.setFrame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trashFrame method, of class Strategy.
     */
    @Test
    public void testTrashFrame() {
        System.out.println("trashFrame");
        Strategy instance = new Strategy();
        instance.trashFrame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cleanUp method, of class Strategy.
     */
    @Test
    public void testCleanUp() {
        System.out.println("cleanUp");
        Strategy instance = new Strategy();
        instance.cleanUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSnapShotAfterTime method, of class Strategy.
     */
    @Test
    public void testGetSnapShotAfterTime() {
        System.out.println("getSnapShotAfterTime");
        Strategy instance = new Strategy();
        instance.getSnapShotAfterTime();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentSnapshot method, of class Strategy.
     */
    @Test
    public void testGetCurrentSnapshot() {
        System.out.println("getCurrentSnapshot");
        Strategy instance = new Strategy();
        instance.getCurrentSnapshot();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrCreate method, of class Strategy.
     */
    @Test
    public void testGetOrCreate() {
        System.out.println("getOrCreate");
        Date time = null;
        Strategy instance = new Strategy();
        Snapshot expResult = null;
        Snapshot result = instance.getOrCreate(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
