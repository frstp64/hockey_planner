/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import projethockey.gui.MainWindow;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import projethockey.services.AppDataProxy;
import javax.imageio.*;
/**
 *
 * @author znuxor
 */
public class Controller {
    // Sport
    private Sport mPlaceHolderSport; // Contains the parameters for the new sport
    private ArrayList<Sport> sportArray;
    private String selectedSport;
    
    // CategoryPlayer
    private CategoryPlayer mPlaceHolderCategoryPlayer; // Contains the parameters for the new CategoryPlayer
    private ArrayList<CategoryPlayer> categoryPlayerArray;
    private String selectedCategoryPlayer;
    
    private projetHockeyInterface mMainWindow; // A reference to the window
    
    // The constructor
    public Controller(MainWindow pMainWindow) {
        this.mMainWindow = pMainWindow;
        
        // Sport
        mPlaceHolderSport = new Sport();
        sportArray = new ArrayList<Sport>();
        // CategoryPlayer
        mPlaceHolderCategoryPlayer = new CategoryPlayer();
        categoryPlayerArray = new ArrayList<CategoryPlayer>();
        
        AppDataProxy.loadData(this);
        
        this.selectedSport = "";
        this.setSelectedCategoryPlayer("");
        
        // Update the array list
        if (!sportArray.isEmpty()) {
            publishSportsNames();
        }
        if (!categoryPlayerArray.isEmpty()) {
            publishCategoryPlayerNames();
        }
    }
    
    // A simple global subscriber to get a reference to the window
    public void subscribeWindow(MainWindow pMainWindow)
    {
        this.mMainWindow = pMainWindow;
    }
    
    
    // -------------------- Sport --------------------
    public void setSportName(String pSportName) {
        this.mPlaceHolderSport.setName(pSportName);
    }
    
    public void setSportUnits(String pUnits) {
        this.mPlaceHolderSport.setDimentionUnit(pUnits);
        
    }
    
    public void setSportHorizontalSize(Float pHorizSize) {
        this.mPlaceHolderSport.setHorizontalSize(pHorizSize);
        
    }
    
    public void setSportVerticalSize(Float pVertSize) {
        this.mPlaceHolderSport.setVerticalSize(pVertSize);
        
    }
    
    public void setSportPlayerNumber(int pPlayerNumber) {
        this.mPlaceHolderSport.setNbPlayer(pPlayerNumber);
        this.mMainWindow.publishPlayerNumber(pPlayerNumber);
    }
    public void setSportCategoryNumber(int pCategoryNumber) {
        this.mMainWindow.publishObjectTypeNumber(pCategoryNumber);
    }
    
    public void setSportPlayers(ArrayList<String> typeArray, ArrayList<String> playerRoleArray) {
        this.mPlaceHolderSport.setPlayers(typeArray, playerRoleArray);
    }

    
    public void setSportObjectTypeNumber(int pObjectNumber) {
        this.mPlaceHolderSport.setNbPlayer(pObjectNumber);
        this.mMainWindow.publishObjectTypeNumber(pObjectNumber);
    }
    
    public void setSportObjects(ArrayList<String> typeArray, ArrayList<Integer> numberArray) {
        this.mPlaceHolderSport.setObjects(typeArray, numberArray);
    }
    
    public void resetPlaceHolderSport() {
        this.mPlaceHolderSport.reset();
        this.mMainWindow.publishDimensions(this.mPlaceHolderSport.getHorizontalSize(), this.mPlaceHolderSport.getVerticalSize());
        //this.mMainWindow.publishExistingSports(); //??
        this.mMainWindow.publishSportName(this.mPlaceHolderSport.getName());
        this.mMainWindow.publishUnits(this.mPlaceHolderSport.getDimentionUnit());
        this.mMainWindow.publishPlayerNumber(this.mPlaceHolderSport.getNbPlayer());
        //void publishPlayers(); //??
        //void publishObjects(); //??
        //void publishFieldPicture();
    }
    
    public void saveSport() {
        // Ensure the sport is valid here.
        
        // If the sport exists, remove it from the list
        for (Sport aSport: sportArray) {
            if (aSport.getName().equals(this.mPlaceHolderSport.getName())) {
                System.out.println(aSport.getName());
                this.sportArray.remove(aSport);
                break;
            }
        }
        
        // Add the sport to the list
        sportArray.add(new Sport(this.mPlaceHolderSport));
        
        //Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);
        if (!sportArray.isEmpty()) {
            publishSportsNames();
        }
    }
    
    public void setSelectedSport(String pSelectedSport) {
        this.selectedSport = pSelectedSport;
    }
    
    public void removeSport() {
        // if one is selected, remove it
        if (!this.selectedSport.equals("")) {
            for (Sport aSport: sportArray) {
                if (aSport.getName().equals(this.selectedSport)) {
                    this.sportArray.remove(aSport);
                    break;
                }
            }
            this.selectedSport = "";
        }
        
        // Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);
        
        // Update display
        publishSportsNames();
    }
    
    public void publishSportsNames() {
        ArrayList<String> sportNameList = new ArrayList<String>();
            for (Sport aSport: sportArray) {
                sportNameList.add(aSport.getName());
            }
            this.mMainWindow.publishExistingSports(sportNameList.toArray(new String[sportNameList.size()]));
    }
    
    public ArrayList<Sport> getSportArray() {
        return sportArray;
    }
    public void setSportArray(ArrayList<Sport> pSportArray) {
        this.sportArray = pSportArray;
    }
    
    public void getSportImage() {
        String sportImagePath = this.mMainWindow.requestFilePath();
        if (!sportImagePath.equals("")) {
        try {
            java.awt.image.BufferedImage myImg = ImageIO.read(new File(sportImagePath));
            
            setSportImage(myImg);
            //this.mPlaceHolderSport.setImage();
        } catch (IOException ex) {
            System.out.println("Error happenedwhile reading image");
        }
        }
    }
    
    public void setSportImage(BufferedImage theFieldPicture) {
        this.mMainWindow.publishFieldPicture(theFieldPicture);
    }
    
    // -------------------- CategoryPlayer --------------------
    public void setCategoryPlayerName(String pCategoryPlayerName) {
        this.mPlaceHolderCategoryPlayer.setCategoryName(pCategoryPlayerName);
    }

    public void setCategoryPlayerHorizontalSize(Float pHorizSize) {
        this.mPlaceHolderCategoryPlayer.setHorizontalSize(pHorizSize);

    }

    public void setCategoryPlayerVerticalSize(Float pVertSize) {
        this.mPlaceHolderCategoryPlayer.setVerticalSize(pVertSize);

    }

    public void resetPlaceHolderCategoryPlayer() {
        
        // empty data
        this.mPlaceHolderCategoryPlayer.reset();
        // empty GUI values
        this.mMainWindow.publishCategoryPlayerDimensions(this.mPlaceHolderCategoryPlayer.getHorizontalSize(), this.mPlaceHolderCategoryPlayer.getVerticalSize());
        this.mMainWindow.publishCategoryPlayerName(this.mPlaceHolderCategoryPlayer.getCategoryName());
        // empty image label
        this.mMainWindow.publishCategoryPlayerIcon(null);
    }

    public void saveCategoryPlayer() {
        // Ensure the categoryPlayer is valid here.

        // If the categoryPlayer exists, remove it from the list
        for (CategoryPlayer aCategoryPlayer: categoryPlayerArray) {
            if (aCategoryPlayer.getCategoryName().equals(this.mPlaceHolderCategoryPlayer.getCategoryName())) {
                System.out.println(aCategoryPlayer.getCategoryName());
                this.categoryPlayerArray.remove(aCategoryPlayer);
                break;
            }
        }

        // Add the categoryPlayer to the list
        categoryPlayerArray.add(new CategoryPlayer(this.mPlaceHolderCategoryPlayer));

        //Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);
        if (!categoryPlayerArray.isEmpty()) {
            publishCategoryPlayerNames();
        }
    }

    public void setSelectedCategoryPlayer(String pSelectedCategoryPlayer) {
        // Set categoryPlayer's data in GUI.
        
        this.selectedCategoryPlayer = pSelectedCategoryPlayer;
        // Clean gui first.
        resetPlaceHolderCategoryPlayer();
        
        for (CategoryPlayer aCategoryPlayer: categoryPlayerArray) {
            if (aCategoryPlayer.getCategoryName().equals(this.selectedCategoryPlayer)) {
                
                
                // Change placeholder values
                this.mPlaceHolderCategoryPlayer = new CategoryPlayer(aCategoryPlayer);
                
                // Publish placeholder's Data to GUI fields
                this.mMainWindow.publishCategoryPlayerName(this.mPlaceHolderCategoryPlayer.getCategoryName());
                this.mMainWindow.publishCategoryPlayerDimensions(this.mPlaceHolderCategoryPlayer.getHorizontalSize(), this.mPlaceHolderCategoryPlayer.getVerticalSize());
                
                // load image and publish  to GUI
                String categoryPlayerImagePath = this.mPlaceHolderCategoryPlayer.getImgPath();
                if (!categoryPlayerImagePath.equals("")) {
                try {
                    java.awt.image.BufferedImage myImg = ImageIO.read(new File(categoryPlayerImagePath));

                    this.mMainWindow.publishCategoryPlayerIcon(myImg);
                    //this.mPlaceHolderCategoryPlayer.setImage();
                } catch (IOException ex) {
                    System.out.println("Error happenedwhile reading image");
                }
                }


                break;
            }
        }
    }

    public void removeCategoryPlayer() {
        // if one is selected, remove it
        if (!this.selectedCategoryPlayer.equals("")) {
            for (CategoryPlayer aCategoryPlayer: categoryPlayerArray) {
                if (aCategoryPlayer.getCategoryName().equals(this.selectedCategoryPlayer)) {
                    this.categoryPlayerArray.remove(aCategoryPlayer);
                    break;
                }
            }
            this.selectedCategoryPlayer = "";
        }

        // Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);

        // Update display
        publishCategoryPlayerNames();
    }

    public void publishCategoryPlayerNames() {
        ArrayList<String> categoryPlayerNameList = new ArrayList<String>();
            for (CategoryPlayer aCategoryPlayer: categoryPlayerArray) {
                categoryPlayerNameList.add(aCategoryPlayer.getCategoryName());
            }
            this.mMainWindow.publishExistingCategoryPlayer(categoryPlayerNameList.toArray(new String[categoryPlayerNameList.size()]));
    }

    public ArrayList<CategoryPlayer> getCategoryPlayerArray() {
        return categoryPlayerArray;
    }
    public void setCategoryPlayerArray(ArrayList<CategoryPlayer> pCategoryPlayerArray) {
        this.categoryPlayerArray = pCategoryPlayerArray;
    }

    public void getCategoryPlayerImage() {
        String categoryPlayerImagePath = this.mMainWindow.requestFilePath();
        if (!categoryPlayerImagePath.equals("")) {
        try {
            java.awt.image.BufferedImage myImg = ImageIO.read(new File(categoryPlayerImagePath));

            setCategoryPlayerImage(myImg);
            this.mPlaceHolderCategoryPlayer.setImgPath(categoryPlayerImagePath);
        } catch (IOException ex) {
            System.out.println("Error happenedwhile reading image");
        }
        }
    }

    public void setCategoryPlayerImage(BufferedImage thePicture) {
        this.mMainWindow.publishCategoryPlayerIcon(thePicture);
    }
}
