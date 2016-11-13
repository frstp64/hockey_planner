/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

import projethockey.gui.MainWindow;

/**
 *
 * @author znuxor
 */
public class Controller {
    private Sport mPlaceHolderSport; // Contains the parameters for the new sport
    private MainWindow mMainWindow; // A reference to the window
    
    // The constructor
    public Controller() {
        mPlaceHolderSport = new Sport();
        
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
}
