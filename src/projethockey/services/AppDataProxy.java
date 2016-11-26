package projethockey.services;
import projethockey.domain.Controller;
import projethockey.domain.Sport;
import projethockey.domain.CategoryPlayer;
import projethockey.domain.CategoryObstacle;
import projethockey.domain.Strategy;
import projethockey.domain.Player;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author znuxor
 */
// This class deals with the application's main data, excluding strategies
public class AppDataProxy{
    public static void saveData(Controller pController) {      
        try (ObjectOutputStream saveObjectFile = new ObjectOutputStream(new FileOutputStream("saveFile.ser"))) {
            // Save the sport, category player, category object and strategy and players
            saveObjectFile.writeObject(pController.getSportArray());
            saveObjectFile.writeObject(pController.getCategoryPlayerArray());
            saveObjectFile.writeObject(pController.getCategoryObstacleArray());
            saveObjectFile.writeObject(pController.getStrategyArray());
            saveObjectFile.writeObject(pController.getPlayerArray());
            
            saveObjectFile.close();
        }
        catch (IOException e) {
            System.out.println("IOException");
            System.out.println(e);
        }
    }

    public static void loadData(Controller pController) {
        
        try (ObjectInputStream loadImputObjectFile = new ObjectInputStream(new FileInputStream("saveFile.ser"))) {
            // load sports, categoryPlayers, load categoryObstacles, load strategy, load players
            pController.setSportArray((ArrayList<Sport>) loadImputObjectFile.readObject());
            pController.setCategoryPlayerArray((ArrayList<CategoryPlayer>) loadImputObjectFile.readObject());
            pController.setCategoryObstacleArray((ArrayList<CategoryObstacle>) loadImputObjectFile.readObject());
            pController.setStrategyArray((ArrayList<Strategy>) loadImputObjectFile.readObject());
            pController.setPlayerArray((ArrayList<Player>) loadImputObjectFile.readObject());
            
            loadImputObjectFile.close();
        }        
        catch (IOException e) {
            System.out.println("IOException");
            System.out.println(e);
            // LOG INFO HERE
        }
        catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            System.out.println(e);
            // LOG HERE
        }

        // Do the rest of the data too
    }
}
