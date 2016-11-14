/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

import projethockey.gui.MainWindow;
import java.util.ArrayList;
import projethockey.services.AppDataProxy;
/**
 *
 * @author znuxor
 */
public class Controller {
    private Sport mPlaceHolderSport; // Contains the parameters for the new sport
    private ArrayList<Sport> sportArray;
    private MainWindow mMainWindow; // A reference to the window
    private String selectedSport;
    
    // The constructor
    public Controller(MainWindow pMainWindow) {
        this.mMainWindow = pMainWindow;
        mPlaceHolderSport = new Sport();
        sportArray = new ArrayList<Sport>();
        AppDataProxy.loadData(this);
        
        this.selectedSport = "";
        
        // Update the array list
        if (!sportArray.isEmpty()) {
            publishSportsNames();
        }
    }
    
    // A simple global subscriber to get a reference to the window
    public void subscribeWindow(MainWindow pMainWindow)
    {
        this.mMainWindow = pMainWindow;
    }
    
    
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
        //this.mMainWindow.
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
    }
}
