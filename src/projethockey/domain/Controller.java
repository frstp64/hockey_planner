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
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
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

    // CategoryObstacle
    private CategoryObstacle mPlaceHolderCategoryObstacle; // Contains the parameters for the new CategoryObstacle
    private ArrayList<CategoryObstacle> categoryObstacleArray;
    private String selectedCategoryObstacle;

    // Strategy
    private Strategy mPlaceHolderStrategy; // Contains the parameters for the new Strategy
    private ArrayList<Strategy> strategyArray;
    private String selectedStrategy;
    
    // Player (unique player)
    private Player mPlaceHolderPlayer; // Contains the parameters for the new Player
    private ArrayList<Player> playerArray;
    private String selectedPlayer;


    private projetHockeyInterface mMainWindow; // A reference to the window
    
    private Scene myScene;
    private Timer timer;
    private int timeViewer;
    public enum StrategyViewerState { Stop, Play, Pause}
    StrategyViewerState viewerState;
    
    // The constructor
    public Controller() {

        // Sport
        mPlaceHolderSport = new Sport();
        sportArray = new ArrayList<Sport>();
        // CategoryPlayer
        mPlaceHolderCategoryPlayer = new CategoryPlayer();
        categoryPlayerArray = new ArrayList<CategoryPlayer>();
        // CategoryObstacle
        mPlaceHolderCategoryObstacle = new CategoryObstacle();
        categoryObstacleArray = new ArrayList<CategoryObstacle>();
        // Strategy
        mPlaceHolderStrategy = new Strategy();
        strategyArray = new ArrayList<Strategy>();
        // Player
        mPlaceHolderPlayer = new Player();
        playerArray = new ArrayList<Player>();
        
        myScene = new Scene(300, 300);

        AppDataProxy.loadData(this);

        timer = new Timer();
        viewerState = StrategyViewerState.Stop;
        //timer.scheduleAtFixedRate(task, 1000, 0);
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
              playStrategyNextFrame();
            }
          }, 1000, 1000);
    }

    // A simple global subscriber to get a reference to the window
    public void subscribeWindow(MainWindow pMainWindow)
    {
        this.mMainWindow = pMainWindow;
        this.selectedSport = "";
        this.setSelectedCategoryPlayer("");
        this.setSelectedCategoryObstacle("");
        this.setSelectedStrategy("");
        this.setSelectedPlayer("");

        // Update the array list
        if (!sportArray.isEmpty()) {
            publishSportsNames();
        }
        if (!categoryPlayerArray.isEmpty()) {
            publishCategoryPlayerNames();
        }
        if (!categoryObstacleArray.isEmpty()) {
            publishCategoryObstacleNames();
        }
        if (!strategyArray.isEmpty()) {
            publishStrategyNames();
        }
        if (!playerArray.isEmpty()) {
            publishPlayerNames();
        }
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
        //this.selectedSport = pSelectedSport;
        
        // Set categoryPlayer's data in GUI.

        this.selectedSport = pSelectedSport;
        // Clean gui first.
        resetPlaceHolderCategoryPlayer();

        for (Sport aSport: sportArray) {
            if (aSport.getName().equals(this.selectedSport)) {
                // Change placeholder values
                this.mPlaceHolderSport = new Sport(aSport);

                // Publish placeholder's Data to GUI fields
                this.mMainWindow.publishSportName(this.mPlaceHolderSport.getName());
                this.mMainWindow.publishDimensions(aSport.getHorizontalSize(), aSport.getVerticalSize());
                this.mMainWindow.publishUnits(aSport.getDimentionUnit());
                this.mMainWindow.publishPlayerNumber(aSport.getNbPlayer());
                this.mMainWindow.publishSportIsUnlimited(aSport.isUnlimitedPlayer());
                //this.mMainWindow.publishObjectTypeNumber(aSport.);
                

                // load image and publish  to GUI
                String sportImagePath = this.mPlaceHolderSport.getImgPath();
                if (!sportImagePath.equals("")) {
                    try {
                        java.awt.image.BufferedImage myImg = ImageIO.read(new File(sportImagePath));

                        this.mMainWindow.publishFieldPicture(myImg); 
                    } catch (IOException ex) {
                        System.out.println("Error happenedwhile reading image");
                    }
                }

                break;
            }
        }
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
    
    public void refreshSport() {
        //if one is selected, refresh the text fields
        for (Sport aSport: sportArray) {
                if (aSport.getName().equals(this.selectedSport)) {
                    //
                    this.mMainWindow.publishSportName(aSport.getName());
                    this.mMainWindow.publishPlayerNumber(aSport.getNbPlayer());
                }
            }
            this.selectedSport = "";
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

    public void setPlayerLimit(boolean pUnlimitedPlayer){
        this.mPlaceHolderSport.setPlayerLimit(pUnlimitedPlayer);
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
            BufferedImage myImg = ImageIO.read(new File(categoryPlayerImagePath));

            setCategoryPlayerImage(myImg);
            this.mPlaceHolderCategoryPlayer.setImgPath(categoryPlayerImagePath);
        } catch (IOException ex) {
            System.out.println("Error happenedwhile reading image");
            System.out.println(ex);
        }
        }
    }

    public void setCategoryPlayerImage(BufferedImage thePicture) {
        this.mMainWindow.publishCategoryPlayerIcon(thePicture);
    }

    // -------------------- CategoryObstacle --------------------
    public void setCategoryObstacleName(String pCategoryObstacleName) {
        this.mPlaceHolderCategoryObstacle.setCategoryName(pCategoryObstacleName);
    }

    public void setCategoryObstacleHorizontalSize(Float pHorizSize) {
        this.mPlaceHolderCategoryObstacle.setHorizontalSize(pHorizSize);

    }

    public void setCategoryObstacleVerticalSize(Float pVertSize) {
        this.mPlaceHolderCategoryObstacle.setVerticalSize(pVertSize);

    }

    public void resetPlaceHolderCategoryObstacle() {

        // empty data
        this.mPlaceHolderCategoryObstacle.reset();
        // empty GUI values
        this.mMainWindow.publishCategoryObstacleDimensions(this.mPlaceHolderCategoryObstacle.getHorizontalSize(), this.mPlaceHolderCategoryObstacle.getVerticalSize());
        this.mMainWindow.publishCategoryObstacleName(this.mPlaceHolderCategoryObstacle.getCategoryName());
        this.mMainWindow.publishCategoryObstacleIsGameObject(this.mPlaceHolderCategoryObstacle.getIsGameObject());
        // empty image label
        this.mMainWindow.publishCategoryObstacleIcon(null);
    }

    public void saveCategoryObstacle() {
        // Ensure the categoryObstacle is valid here.

        // If the categoryObstacle exists, remove it from the list
        for (CategoryObstacle aCategoryObstacle: categoryObstacleArray) {
            if (aCategoryObstacle.getCategoryName().equals(this.mPlaceHolderCategoryObstacle.getCategoryName())) {
                System.out.println(aCategoryObstacle.getCategoryName());
                this.categoryObstacleArray.remove(aCategoryObstacle);
                break;
            }
        }

        // Add the categoryObstacle to the list
        categoryObstacleArray.add(new CategoryObstacle(this.mPlaceHolderCategoryObstacle));

        //Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);
        if (!categoryObstacleArray.isEmpty()) {
            publishCategoryObstacleNames();
        }
    }

    public void setSelectedCategoryObstacle(String pSelectedCategoryObstacle) {
        // Set categoryObstacle's data in GUI.

        this.selectedCategoryObstacle = pSelectedCategoryObstacle;
        // Clean gui first.
        resetPlaceHolderCategoryObstacle();

        for (CategoryObstacle aCategoryObstacle: categoryObstacleArray) {
            if (aCategoryObstacle.getCategoryName().equals(this.selectedCategoryObstacle)) {


                // Change placeholder values
                this.mPlaceHolderCategoryObstacle = new CategoryObstacle(aCategoryObstacle);

                // Publish placeholder's Data to GUI fields
                this.mMainWindow.publishCategoryObstacleName(this.mPlaceHolderCategoryObstacle.getCategoryName());
                this.mMainWindow.publishCategoryObstacleDimensions(this.mPlaceHolderCategoryObstacle.getHorizontalSize(), this.mPlaceHolderCategoryObstacle.getVerticalSize());
                this.mMainWindow.publishCategoryObstacleIsGameObject(this.mPlaceHolderCategoryObstacle.getIsGameObject());

                // load image and publish  to GUI
                String categoryObstacleImagePath = this.mPlaceHolderCategoryObstacle.getImgPath();
                if (!categoryObstacleImagePath.equals("")) {
                try {
                    java.awt.image.BufferedImage myImg = ImageIO.read(new File(categoryObstacleImagePath));

                    this.mMainWindow.publishCategoryObstacleIcon(myImg);
                    //this.mPlaceHolderCategoryObstacle.setImage();
                } catch (IOException ex) {
                    System.out.println("Error happenedwhile reading image");
                }
                }


                break;
            }
        }
    }

    public void removeCategoryObstacle() {
        // if one is selected, remove it
        if (!this.selectedCategoryObstacle.equals("")) {
            for (CategoryObstacle aCategoryObstacle: categoryObstacleArray) {
                if (aCategoryObstacle.getCategoryName().equals(this.selectedCategoryObstacle)) {
                    this.categoryObstacleArray.remove(aCategoryObstacle);
                    break;
                }
            }
            this.selectedCategoryObstacle = "";
        }

        // Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);

        // Update display
        publishCategoryObstacleNames();
    }

    public void publishCategoryObstacleNames() {
        ArrayList<String> categoryObstacleNameList = new ArrayList<String>();
            for (CategoryObstacle aCategoryObstacle: categoryObstacleArray) {
                categoryObstacleNameList.add(aCategoryObstacle.getCategoryName());
            }
            this.mMainWindow.publishExistingCategoryObstacle(categoryObstacleNameList.toArray(new String[categoryObstacleNameList.size()]));
    }

    public ArrayList<CategoryObstacle> getCategoryObstacleArray() {
        return categoryObstacleArray;
    }
    public void setCategoryObstacleArray(ArrayList<CategoryObstacle> pCategoryObstacleArray) {
        this.categoryObstacleArray = pCategoryObstacleArray;
    }

    public void getCategoryObstacleImage() {
        String categoryObstacleImagePath = this.mMainWindow.requestFilePath();
        if (!categoryObstacleImagePath.equals("")) {
        try {
            java.awt.image.BufferedImage myImg = ImageIO.read(new File(categoryObstacleImagePath));

            setCategoryObstacleImage(myImg);
            this.mPlaceHolderCategoryObstacle.setImgPath(categoryObstacleImagePath);
        } catch (IOException ex) {
            System.out.println("Error happenedwhile reading image");
        }
        }
    }

    public void setCategoryObstacleImage(BufferedImage thePicture) {
        this.mMainWindow.publishCategoryObstacleIcon(thePicture);
    }

    public void setObstacleIsGameObject(Boolean gameObject) {
        this.mPlaceHolderCategoryObstacle.setIsGameObject(gameObject);
    }

    // -------------------- Strategy --------------------
    public void setStrategyName(String pStrategyName) {
        this.mPlaceHolderStrategy.setName(pStrategyName);
    }

    public void resetPlaceHolderStrategy() {

        // empty data
        //this.mPlaceHolderStrategy.reset();
        // empty GUI values
        this.mMainWindow.publishStrategyName(this.mPlaceHolderStrategy.getName());
        //TODO
        //this.mMainWindow.publishStrategySport(this.mPlaceHolderStrategy.getCategoryName());

    }

    public void saveStrategy() {
        // save strategy to strategy array. This is not a save snapshot.
        // Ensure the Strategy is valid here.

        // TODO fix this with saving in the strategy dir, one strategy per folder.
        // If the Strategy exists, remove it from the list
        for (Strategy aStrategy: strategyArray) {
            if (aStrategy.getName().equals(this.mPlaceHolderStrategy.getName())) {
                System.out.println(aStrategy.getName());
                this.strategyArray.remove(aStrategy);
                break;
            }
        }

        // Add the Strategy to the list
        strategyArray.add(new Strategy(this.mPlaceHolderStrategy));

        //Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);
        if (!strategyArray.isEmpty()) {
            publishStrategyNames();
        }
    }

    public void setSelectedStrategy(String pSelectedStrategy) {
        // Set Strategy's data in GUI.

        this.selectedStrategy = pSelectedStrategy;
        // Clean gui first.
        resetPlaceHolderStrategy();

        for (Strategy aStrategy: strategyArray) {
            if (aStrategy.getName().equals(this.selectedStrategy)) {


                // Change placeholder values
                this.mPlaceHolderStrategy = new Strategy(aStrategy);

                // Publish placeholder's Data to GUI fields
                this.mMainWindow.publishStrategyName(this.mPlaceHolderStrategy.getName());

                
                }


                break;
            }
        }

    public void removeStrategy() {
        // if one is selected, remove it
        if (!this.selectedStrategy.equals("")) {
            for (Strategy aStrategy: strategyArray) {
                if (aStrategy.getName().equals(this.selectedStrategy)) {
                    this.strategyArray.remove(aStrategy);
                    break;
                }
            }
            this.selectedStrategy = "";
        }

        // Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);

        // Update display
        publishStrategyNames();
    }

    public void publishStrategyNames() {
        ArrayList<String> StrategyNameList = new ArrayList<String>();
            for (Strategy aStrategy: strategyArray) {
                StrategyNameList.add(aStrategy.getName());
            }
            this.mMainWindow.publishExistingStrategies(StrategyNameList.toArray(new String[StrategyNameList.size()]));
    }

    public ArrayList<Strategy> getStrategyArray() {
        return strategyArray;
    }
    public void setStrategyArray(ArrayList<Strategy> pStrategyArray) {
        this.strategyArray = pStrategyArray;
    }
    
    public void setStrategySport(Sport pSport) {
        // maybe keep a selectedStrategySport pointer?
        setStrategySportName(pSport.getName());
    }

    public void setStrategySportName(String sportName) {
        this.mPlaceHolderStrategy.setSportName(sportName);
    }
    
    // -------------------- Player --------------------
    public void setPlayerName(String pPlayerName) {
        this.mPlaceHolderPlayer.setName(pPlayerName);
    }
    
    public void resetPlaceHolderPlayer() {

        // empty data
        this.mPlaceHolderPlayer.reset();
        // empty GUI values
        this.mMainWindow.publishPlayerName(this.mPlaceHolderPlayer.getName());
    }
    
    public void removePlayer() {
        // if one is selected, remove it
        if (!this.selectedPlayer.equals("")) {
            for (Player aPlayer: playerArray) {
                if (aPlayer.getName().equals(this.selectedPlayer)) {
                    this.playerArray.remove(aPlayer);
                    break;
                }
            }
            this.selectedPlayer = "";
        }

        // Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);

        // Update display
        publishPlayerNames();
    }
    
    public void savePlayer() {
        // Ensure the player is valid here.

        // If the player exists, remove it from the list
        for (Player aPlayer: playerArray) {
            if (aPlayer.getName().equals(this.mPlaceHolderPlayer.getName())) {
                System.out.println(aPlayer.getName());
                this.playerArray.remove(aPlayer);
                break;
            }
        }

        // Add the player to the list
        playerArray.add(new Player(this.mPlaceHolderPlayer));

        //Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);
        if (!playerArray.isEmpty()) {
            publishPlayerNames();
        }
    }
    
    public void setSelectedPlayer(String pSelectedPlayer) {
        //this.selectedPlayer = pSelectedPlayer;

        // Set player's data in GUI.

        this.selectedPlayer = pSelectedPlayer;
        // Clean gui first.
        resetPlaceHolderPlayer();

        for (Player aPlayer: playerArray) {
            if (aPlayer.getName().equals(this.selectedPlayer)) {
                // Change placeholder values
                this.mPlaceHolderPlayer = new Player(aPlayer);

                // Publish placeholder's Data to GUI fields
                this.mMainWindow.publishPlayerName(this.mPlaceHolderPlayer.getName());
                this.mMainWindow.publishPlayerCategory(aPlayer.getCategoryPlayerName());

                break;
            }
        }
    }
    
    public void publishPlayerNames() {
        ArrayList<String> PlayerNameList = new ArrayList<String>();
            for (Player aPlayer: playerArray) {
                PlayerNameList.add(aPlayer.getName());
            }
            this.mMainWindow.publishExistingPlayers(PlayerNameList.toArray(new String[PlayerNameList.size()]));
    }
    
    
    
    
    public void playStrategy() {
        
        // test stuff
        BufferedImage whitePic = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        whitePic.setRGB(0, 0, 256*256*253 + 256*253 + 253);
        whitePic.setRGB(9, 9, 256*256*253 + 256*253 + 253);

        for(int i = 0; i < 3000000; i++) {

        myScene.putPicture(whitePic, 150, 150);
        this.mMainWindow.publishScene(myScene.getScenePicture());
        }
        
        viewerState = (!viewerState.equals(StrategyViewerState.Play)) ? StrategyViewerState.Play : StrategyViewerState.Pause;
    }
    
    public void playStrategyNextFrame() {
        if(viewerState.equals(StrategyViewerState.Play))
        {
            timeViewer++;
            //The animation here
            //this.mPlaceHolderStrategy.getFrame();
        }
    }
      
    public void playStepBackTimeFrame() {
        timeViewer -=2;
        playStrategyNextFrame();
    }
    
    public void playStepFowardTimeFrame() {
        playStrategyNextFrame();
    }
}
