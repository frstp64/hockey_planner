/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.services;
import projethockey.domain.Controller;
import projethockey.domain.Sport;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author znuxor
 */
// This class deals with the application's main data, excluding strategies
public class AppDataProxy{
    public static void saveData(Controller pController) {
        try {
        ObjectOutputStream saveSportFile = new ObjectOutputStream(new FileOutputStream("sports.ser"));
        // Save the sport
        saveSportFile.writeObject(pController.getSportArray());
        // Save the categories
        
        // Save the game objects
        
        saveSportFile.close();
        }
        catch (IOException e) {
            // LOG INFO HERE
        }
        
        // Do the rest of the data too
        
    }
    public static void loadData(Controller pController) {
        try {
            FileInputStream saveSportFile = new FileInputStream("sports.ser");
            ObjectInputStream objectFile = new ObjectInputStream(saveSportFile);
            pController.setSportArray((ArrayList<Sport>) objectFile.readObject());
            saveSportFile.close();
        }
        catch (IOException e) {
            // LOG INFO HERE
        }
        catch (ClassNotFoundException e) {
            // LOG HERE
        }
        
        // Do the rest of the data too
    }
}
