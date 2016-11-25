/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projethockey.gui.MainWindow;

/**
 *
 * @author Alexandre
 */
public class ControllerTest {
    
    private Controller testController;
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MainWindow alpha = new MainWindow();
        
        testController = new Controller(alpha);
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void givenAValidSport_whenSaveSport_thenSportIsAddToWhateverList()
    {
        Sport sportTest = new Sport();
        
        
        
        testController.saveSport();
        
    }

    /**
     * Test of subscribeWindow method, of class Controller.
     */
    @Test
    public void testSubscribeWindow() {
        System.out.println("subscribeWindow");
        MainWindow pMainWindow = null;
        Controller instance = null;
        instance.subscribeWindow(pMainWindow);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportName method, of class Controller.
     */
    @Test
    public void testSetSportName() {
        System.out.println("setSportName");
        String pSportName = "";
        Controller instance = null;
        instance.setSportName(pSportName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportUnits method, of class Controller.
     */
    @Test
    public void testSetSportUnits() {
        System.out.println("setSportUnits");
        String pUnits = "";
        Controller instance = null;
        instance.setSportUnits(pUnits);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportHorizontalSize method, of class Controller.
     */
    @Test
    public void testSetSportHorizontalSize() {
        System.out.println("setSportHorizontalSize");
        Float pHorizSize = null;
        Controller instance = null;
        instance.setSportHorizontalSize(pHorizSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportVerticalSize method, of class Controller.
     */
    @Test
    public void testSetSportVerticalSize() {
        System.out.println("setSportVerticalSize");
        Float pVertSize = null;
        Controller instance = null;
        instance.setSportVerticalSize(pVertSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportPlayerNumber method, of class Controller.
     */
    @Test
    public void testSetSportPlayerNumber() {
        System.out.println("setSportPlayerNumber");
        int pPlayerNumber = 0;
        Controller instance = null;
        instance.setSportPlayerNumber(pPlayerNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportCategoryNumber method, of class Controller.
     */
    @Test
    public void testSetSportCategoryNumber() {
        System.out.println("setSportCategoryNumber");
        int pCategoryNumber = 0;
        Controller instance = null;
        instance.setSportCategoryNumber(pCategoryNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportPlayers method, of class Controller.
     */
    @Test
    public void testSetSportPlayers() {
        System.out.println("setSportPlayers");
        ArrayList<String> typeArray = null;
        ArrayList<String> playerRoleArray = null;
        Controller instance = null;
        instance.setSportPlayers(typeArray, playerRoleArray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportObjectTypeNumber method, of class Controller.
     */
    @Test
    public void testSetSportObjectTypeNumber() {
        System.out.println("setSportObjectTypeNumber");
        int pObjectNumber = 0;
        Controller instance = null;
        instance.setSportObjectTypeNumber(pObjectNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportObjects method, of class Controller.
     */
    @Test
    public void testSetSportObjects() {
        System.out.println("setSportObjects");
        ArrayList<String> typeArray = null;
        ArrayList<Integer> numberArray = null;
        Controller instance = null;
        instance.setSportObjects(typeArray, numberArray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetPlaceHolderSport method, of class Controller.
     */
    @Test
    public void testResetPlaceHolderSport() {
        System.out.println("resetPlaceHolderSport");
        Controller instance = null;
        instance.resetPlaceHolderSport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveSport method, of class Controller.
     */
    @Test
    public void testSaveSport() {
        System.out.println("saveSport");
        Controller instance = null;
        instance.saveSport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelectedSport method, of class Controller.
     */
    @Test
    public void testSetSelectedSport() {
        System.out.println("setSelectedSport");
        String pSelectedSport = "";
        Controller instance = null;
        instance.setSelectedSport(pSelectedSport);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSport method, of class Controller.
     */
    @Test
    public void testRemoveSport() {
        System.out.println("removeSport");
        Controller instance = null;
        instance.removeSport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of publishSportsNames method, of class Controller.
     */
    @Test
    public void testPublishSportsNames() {
        System.out.println("publishSportsNames");
        Controller instance = null;
        instance.publishSportsNames();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSportArray method, of class Controller.
     */
    @Test
    public void testGetSportArray() {
        System.out.println("getSportArray");
        Controller instance = null;
        ArrayList<Sport> expResult = null;
        ArrayList<Sport> result = instance.getSportArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportArray method, of class Controller.
     */
    @Test
    public void testSetSportArray() {
        System.out.println("setSportArray");
        ArrayList<Sport> pSportArray = null;
        Controller instance = null;
        instance.setSportArray(pSportArray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSportImage method, of class Controller.
     */
    @Test
    public void testGetSportImage() {
        System.out.println("getSportImage");
        Controller instance = null;
        instance.getSportImage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSportImage method, of class Controller.
     */
    @Test
    public void testSetSportImage() {
        System.out.println("setSportImage");
        BufferedImage theFieldPicture = null;
        Controller instance = null;
        instance.setSportImage(theFieldPicture);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryPlayerName method, of class Controller.
     */
    @Test
    public void testSetCategoryPlayerName() {
        System.out.println("setCategoryPlayerName");
        String pCategoryPlayerName = "";
        Controller instance = null;
        instance.setCategoryPlayerName(pCategoryPlayerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryPlayerHorizontalSize method, of class Controller.
     */
    @Test
    public void testSetCategoryPlayerHorizontalSize() {
        System.out.println("setCategoryPlayerHorizontalSize");
        Float pHorizSize = null;
        Controller instance = null;
        instance.setCategoryPlayerHorizontalSize(pHorizSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryPlayerVerticalSize method, of class Controller.
     */
    @Test
    public void testSetCategoryPlayerVerticalSize() {
        System.out.println("setCategoryPlayerVerticalSize");
        Float pVertSize = null;
        Controller instance = null;
        instance.setCategoryPlayerVerticalSize(pVertSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetPlaceHolderCategoryPlayer method, of class Controller.
     */
    @Test
    public void testResetPlaceHolderCategoryPlayer() {
        System.out.println("resetPlaceHolderCategoryPlayer");
        Controller instance = null;
        instance.resetPlaceHolderCategoryPlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCategoryPlayer method, of class Controller.
     */
    @Test
    public void testSaveCategoryPlayer() {
        System.out.println("saveCategoryPlayer");
        Controller instance = null;
        instance.saveCategoryPlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelectedCategoryPlayer method, of class Controller.
     */
    @Test
    public void testSetSelectedCategoryPlayer() {
        System.out.println("setSelectedCategoryPlayer");
        String pSelectedCategoryPlayer = "";
        Controller instance = null;
        instance.setSelectedCategoryPlayer(pSelectedCategoryPlayer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCategoryPlayer method, of class Controller.
     */
    @Test
    public void testRemoveCategoryPlayer() {
        System.out.println("removeCategoryPlayer");
        Controller instance = null;
        instance.removeCategoryPlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of publishCategoryPlayerNames method, of class Controller.
     */
    @Test
    public void testPublishCategoryPlayerNames() {
        System.out.println("publishCategoryPlayerNames");
        Controller instance = null;
        instance.publishCategoryPlayerNames();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoryPlayerArray method, of class Controller.
     */
    @Test
    public void testGetCategoryPlayerArray() {
        System.out.println("getCategoryPlayerArray");
        Controller instance = null;
        ArrayList<CategoryPlayer> expResult = null;
        ArrayList<CategoryPlayer> result = instance.getCategoryPlayerArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryPlayerArray method, of class Controller.
     */
    @Test
    public void testSetCategoryPlayerArray() {
        System.out.println("setCategoryPlayerArray");
        ArrayList<CategoryPlayer> pCategoryPlayerArray = null;
        Controller instance = null;
        instance.setCategoryPlayerArray(pCategoryPlayerArray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoryPlayerImage method, of class Controller.
     */
    @Test
    public void testGetCategoryPlayerImage() {
        System.out.println("getCategoryPlayerImage");
        Controller instance = null;
        instance.getCategoryPlayerImage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryPlayerImage method, of class Controller.
     */
    @Test
    public void testSetCategoryPlayerImage() {
        System.out.println("setCategoryPlayerImage");
        BufferedImage theFieldPicture = null;
        Controller instance = null;
        instance.setCategoryPlayerImage(theFieldPicture);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
