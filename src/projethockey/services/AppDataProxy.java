/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.services;
import projethockey.domain.Controller;
import projethockey.domain.Sport;
import projethockey.domain.CategoryPlayer;
import projethockey.domain.CategoryObstacle;
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
        ObjectOutputStream saveCategoryPlayerFile = new ObjectOutputStream(new FileOutputStream("categoryPlayers.ser"));
        ObjectOutputStream saveCategoryObstacleFile = new ObjectOutputStream(new FileOutputStream("categoryObstacles.ser"));
        
        // Save the sport
        saveSportFile.writeObject(pController.getSportArray());
        // Save the categories
        saveCategoryPlayerFile.writeObject(pController.getCategoryPlayerArray());
        // Save the game objects
        saveCategoryObstacleFile.writeObject(pController.getCategoryObstacleArray());
        
        saveSportFile.close();
        saveCategoryPlayerFile.close();
        }
        catch (IOException e) {
            // LOG INFO HERE
        }
        
        // Do the rest of the data too
        
    }
    
    public static void loadData(Controller pController) {
        try {
            // load sports
            FileInputStream saveSportFile = new FileInputStream("sports.ser");
            ObjectInputStream objectFile = new ObjectInputStream(saveSportFile);
            pController.setSportArray((ArrayList<Sport>) objectFile.readObject());
            saveSportFile.close();
            
            //load categoryPlayers
            FileInputStream saveCategoryPlayerFile = new FileInputStream("categoryPlayers.ser");
            ObjectInputStream objectCategoryPlayerFile = new ObjectInputStream(saveCategoryPlayerFile);
            pController.setCategoryPlayerArray((ArrayList<CategoryPlayer>) objectCategoryPlayerFile.readObject());
            saveCategoryPlayerFile.close();
            
            //load categoryObstacles
            FileInputStream saveCategoryObstacleFile = new FileInputStream("categoryObstacles.ser");
            ObjectInputStream objectCategoryObstacleFile = new ObjectInputStream(saveCategoryObstacleFile);
            pController.setCategoryObstacleArray((ArrayList<CategoryObstacle>) objectCategoryObstacleFile.readObject());
            saveCategoryObstacleFile.close();
            
        }
        catch (IOException e) {
            System.out.println("shit1");
            System.out.println(e);
            // LOG INFO HERE
        }
        catch (ClassNotFoundException e) {
            System.out.println("shit2");
            // LOG HERE
        }
        
        // Do the rest of the data too
    }
}
