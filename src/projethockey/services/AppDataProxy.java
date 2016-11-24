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
import projethockey.domain.Strategy;
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
            ObjectOutputStream saveSportPlayerObjectFile = new ObjectOutputStream(new FileOutputStream("saveSportPlayerObjectFile.ser"));

            // Save the sport
            saveSportPlayerObjectFile.writeObject(pController.getSportArray());
            // Save the categories
            saveSportPlayerObjectFile.writeObject(pController.getCategoryPlayerArray());
            // Save the game objects
            saveSportPlayerObjectFile.writeObject(pController.getCategoryObstacleArray());

            saveSportPlayerObjectFile.close();

            // Save strategy. TODO
            // For now all strategy are save in the same file
            // Should be in a folder with a new file for every sport
            // Le arrayStrategy du controleur devrait seulement contenir des string et etre cree a partir des fichiers dans ce dossier.
            ObjectOutputStream saveStrategyFile = new ObjectOutputStream(new FileOutputStream("Strategy.ser"));
            // Save the Strategy array with strategy content
            saveStrategyFile.writeObject(pController.getStrategyArray());
            saveStrategyFile.close();

        }
        catch (IOException e) {
            System.out.println("IOException");
            System.out.println(e);
        }
    }

    public static void loadData(Controller pController) {
        try {            
            // load sports, categoryPlayers, load categoryObstacles
            FileInputStream saveSportPlayerObstacleFile = new FileInputStream("saveSportPlayerObjectFile.ser");
            ObjectInputStream objectImputSportPlayerObstacle = new ObjectInputStream(saveSportPlayerObstacleFile);
            pController.setSportArray((ArrayList<Sport>) objectImputSportPlayerObstacle.readObject());
            pController.setCategoryPlayerArray((ArrayList<CategoryPlayer>) objectImputSportPlayerObstacle.readObject());
            pController.setCategoryObstacleArray((ArrayList<CategoryObstacle>) objectImputSportPlayerObstacle.readObject());
            objectImputSportPlayerObstacle.close();
                        
            
            // load Strategy
            //TODO, save every strategy in a folder. On load, construct array only.
            // On chargement strategy, load the strategy file.
            // see save above.
            FileInputStream saveStrategyFile = new FileInputStream("Strategy.ser");
            ObjectInputStream objectStrategyFile = new ObjectInputStream(saveStrategyFile);
            pController.setStrategyArray((ArrayList<Strategy>) objectStrategyFile.readObject());
            saveStrategyFile.close();

        }
        catch (IOException e) {
            System.out.println("IOException");
            System.out.println(e);
            // LOG INFO HERE
        }
        catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            // LOG HERE
        }

        // Do the rest of the data too
    }
}
