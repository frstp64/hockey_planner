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
import java.text.DecimalFormat;
import java.util.Calendar;
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
    
    //viewer strategy (currently loaded strategy)
    private Strategy loadedStrategy;
    
    // Player (unique player)
    private Player mPlaceHolderPlayer; // Contains the parameters for the new Player
    private ArrayList<Player> playerArray;
    private String selectedPlayer;
    
    // Team (unique team)
    private Team mPlaceHolderTeam; // Contains the parameters for the new Team
    private ArrayList<Team> teamArray;
    private String selectedTeam;
    
    // The state machine that kinda controls the edition mode
    private EditionStateMachine mMouseFSM;

    private projetHockeyInterface mMainWindow; // A reference to the window
    
    private Scene myScene;
    private Timer timer;
    private int timeViewer, intervalTimeinMS;
    public enum StrategyViewerState { Stop, Play, Pause}
    StrategyViewerState viewerState;
    
    // The arrays used for undo/redo
    private ArrayList<Strategy> undoList;
    private ArrayList<Strategy> redoList;
    
    int maxUndoRedo = 20; // The maximum undo/redo to be kept in array
    // The constructor
    public Controller() {

        // the FSM
        mMouseFSM = new EditionStateMachine(this);
        
        // The scene
        myScene = new Scene(100, 100);
        
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
        
        // Team
        mPlaceHolderTeam = new Team();
        teamArray = new ArrayList<Team>();
        
        myScene = new Scene(300, 300);

        AppDataProxy.loadData(this);

        timer = new Timer();
        viewerState = StrategyViewerState.Stop;
        //timer.scheduleAtFixedRate(task, 1000, 0);
        
        //timer.scheduleAtFixedRate(new TimerTask() {
        //    @Override
        //    public void run() {
        //      playStrategyNextFrame();
        //    }
        //  }, 1000, 1000);
        
        timeViewer = 0;
        intervalTimeinMS = 1000;
        
        undoList = new ArrayList();
        redoList = new ArrayList();
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
        this.setSelectedTeam("");

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
        if (!teamArray.isEmpty()) {
            publishTeamNames();
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
    
    public void setTeamNumber(int number) {
        this.mPlaceHolderSport.setNumberMaxTeam(number);
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
        this.mMainWindow.publishSportName(this.mPlaceHolderSport.getName());
        this.mMainWindow.publishUnits(this.mPlaceHolderSport.getDimentionUnit());
        this.mMainWindow.publishPlayerNumber(this.mPlaceHolderSport.getNbPlayer());
        this.mMainWindow.publishFieldPicture(this.mPlaceHolderSport.getImg()); 
    }

    public void saveSport() {
        // Ensure the sport is valid here.
        
        if (this.mPlaceHolderSport.isValid()) {

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
                this.mMainWindow.publishTeamNumber(aSport.getNumberMaxTeam());
                this.mMainWindow.publishPlayerNumber(aSport.getNbPlayer());
                this.mMainWindow.publishSportIsUnlimited(aSport.isUnlimitedPlayer());
                //this.mMainWindow.publishObjectTypeNumber(aSport.);
                

                // load image and publish  to GUI
                this.mMainWindow.publishFieldPicture(this.mPlaceHolderSport.getImg()); 

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

        } catch (IOException ex) {
            System.out.println("Error happenedwhile reading image");
        }
        }
    }

    public Sport getSportFromName(String sportName) {
        for(Sport aSport : this.sportArray)
            if(sportName.equals(aSport.getName()))
                return aSport;
        
        return new Sport();
    }
            
    
    public void setSportImage(BufferedImage theFieldPicture) {
        this.mPlaceHolderSport.setImg(theFieldPicture);
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
        if (this.mPlaceHolderCategoryPlayer.getImg() != null && this.mPlaceHolderCategoryPlayer.getCategoryName() != null) {

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
                this.mMainWindow.publishCategoryPlayerIcon(this.mPlaceHolderCategoryPlayer.getImg());

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
            } 
            catch (IOException ex) {
                System.out.println("Error happenedwhile reading image");
                System.out.println(ex);
            }
        }
    }

    public void setCategoryPlayerImage(BufferedImage thePicture) {
        this.mPlaceHolderCategoryPlayer.setImg(thePicture);
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
                    } 
                    catch (IOException ex) {
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
        //this.mMainWindow.publishStrategyName(this.mPlaceHolderStrategy.getName());
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
                this.mMainWindow.publishStrategyTeams(this.mPlaceHolderStrategy.getTeamNames());
                
                
                // publish all players in strategy to list.
                ArrayList<String> playerNames = new ArrayList<String>();
                for(Team aTeam: this.mPlaceHolderStrategy.getListTeam()){
                    for(Player aPlayer: aTeam.getListPlayer()){
                        playerNames.add(aPlayer.getName());
                    }
                }
                try{
                    this.mMainWindow.publishStrategyPlayers(playerNames.toArray(new String[playerNames.size()]));
                } catch (Exception Ex) {
                    this.selectedStrategy = "";
                }

            }
        }
        //System.out.println("We should have selected an existing strategy!");
    }

    public void removeSelectedStrategy(String pStrategyName) {
        // if one is selected, remove it
        if (!pStrategyName.equals("")) {
            for (Strategy aStrategy: strategyArray) {
                if (aStrategy.getName().equals(pStrategyName)) {
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
            if(this.mPlaceHolderStrategy.getSport() != null && aStrategy.getSportName().equals(this.mPlaceHolderStrategy.getSport().getName()))
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
        this.mPlaceHolderStrategy.setSport(pSport);
    }

    public void setStrategySportName(String sportName) {
        for (Sport aSport: sportArray) {
            if (aSport.getName().equals(sportName)) {
                setStrategySport(aSport);
                ArrayList<String> myTeamArray = new ArrayList();
                for (Team aTeam : this.mPlaceHolderStrategy.getListTeam()) {
                    myTeamArray.add(aTeam.getName());
                }
                int missingSize = aSport.getNbPlayer() - myTeamArray.size();
                for (int i = 0; i < missingSize; i++) {
                    myTeamArray.add("");
                }
                this.mMainWindow.publishStrategyTeams(myTeamArray);
                break;
            }
        }
    }
    
    public void setStrategyTeam(String[] pTeamList){
        // takes list of team names and adds Team list to placeHolderStrategy.
        
        ArrayList<Team> teamList = new ArrayList<Team>();
        
        for(String aTeamName: pTeamList){
            for (Team aTeam: teamArray) {
                if (aTeam.getName().equals(aTeamName)) {
                    // Change placeholder values
                    teamList.add( new Team(aTeam) );
                    
                    break;
                }
            }
        }
        
        this.mPlaceHolderStrategy.setListTeam(teamList);
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

        this.mPlaceHolderPlayer.setVisible(true);
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

        if (!this.selectedPlayer.equals("")) {
            for (Player aPlayer: playerArray) {
                if (aPlayer.getName().equals(this.selectedPlayer)) {
                    // Change placeholder values
                    this.mPlaceHolderPlayer = new Player(aPlayer);

                    // Publish placeholder's Data to GUI fields
                    this.mMainWindow.publishPlayerName(this.mPlaceHolderPlayer.getName());
                    this.mMainWindow.publishPlayerCategoryName(aPlayer.getCategoryPlayerName());

                    break;
                }
            }
        }
        else {this.mMainWindow.publishPlayerName("");}
    }
    
    public void publishPlayerNames() {
        ArrayList<String> PlayerNameList = new ArrayList<String>();
            for (Player aPlayer: playerArray) {
                PlayerNameList.add(aPlayer.getName());
            }
            this.mMainWindow.publishExistingPlayers(PlayerNameList.toArray(new String[PlayerNameList.size()]));
    }
    
    public ArrayList<Player> getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(ArrayList<Player> pPlayerArray) {
        this.playerArray = pPlayerArray;
    }
    
    public void setPlayerCategory(String pCategoryName) {
        for (CategoryPlayer aPlayer: categoryPlayerArray) {
            if (aPlayer.getCategoryName().equals(pCategoryName)) {
                // Change placeholder values
                this.mPlaceHolderPlayer.setCategoryPlayer(aPlayer);

                break;
            }
        }
    }
            
    
    // -------------------- Team --------------------
    public void setTeamName(String pTeamName) {
        this.mPlaceHolderTeam.setName(pTeamName);
    }

    public void resetPlaceHolderTeam() {

        // empty data
        this.mPlaceHolderTeam.reset();
        // empty GUI values
        this.mMainWindow.publishTeamName(this.mPlaceHolderTeam.getName());
    }

    public void removeTeam() {
        // if one is selected, remove it
        if (!this.selectedTeam.equals("")) {
            for (Team aTeam: teamArray) {
                if (aTeam.getName().equals(this.selectedTeam)) {
                    this.teamArray.remove(aTeam);
                    break;
                }
            }
            this.selectedTeam = "";
        }

        // Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);

        // Update display
        publishTeamNames();
    }

    public void saveTeam() {
        // Ensure the team is valid here.

        // If the team exists, remove it from the list
        for (Team aTeam: teamArray) {
            if (aTeam.getName().equals(this.mPlaceHolderTeam.getName())) {
                System.out.println(aTeam.getName());
                this.teamArray.remove(aTeam);
                break;
            }
        }

        // Add the team to the list
        teamArray.add(new Team(this.mPlaceHolderTeam));

        //Save to permanent memory
        projethockey.services.AppDataProxy.saveData(this);
        if (!teamArray.isEmpty()) {
            publishTeamNames();
        }
    }

    public void setSelectedTeam(String pSelectedTeam) {
        //this.selectedTeam = pSelectedTeam;

        // Set team's data in GUI.

        this.selectedTeam = pSelectedTeam;
        // Clean gui first.
        resetPlaceHolderTeam();

        for (Team aTeam: teamArray) {
            if (aTeam.getName().equals(this.selectedTeam)) {
                // Change placeholder values
                this.mPlaceHolderTeam = new Team(aTeam);

                // Publish placeholder's Data to GUI fields
                this.mMainWindow.publishTeamName(this.mPlaceHolderTeam.getName());
                this.mMainWindow.publishTeamPlayers(this.mPlaceHolderTeam.getPlayerNames());
                break;
            }
        }
    }

    public void publishTeamNames() {
        ArrayList<String> TeamNameList = new ArrayList<String>();
            for (Team aTeam: teamArray) {
                TeamNameList.add(aTeam.getName());
            }
            this.mMainWindow.publishExistingTeams(TeamNameList.toArray(new String[TeamNameList.size()]));
    }
    
    public ArrayList<Team> getTeamArray() {
        return teamArray;
    }

    public void setTeamArray(ArrayList<Team> pTeamArray) {
        this.teamArray = pTeamArray;
    }
    
    public void setTeamPlayerArray(String[] pPlayerNameArray) {
        
        ArrayList<Player> playerList = new ArrayList<Player>();
        // get playername from list and add him to our new list
        for (String aPlayerName: pPlayerNameArray) {
            for (Player aPlayer: playerArray) {
                if (aPlayer.getName().equals(aPlayerName)) {
                    // Change placeholder values
                    playerList.add( new Player(aPlayer) );

                    break;
                }
            }
        }
        
        this.mPlaceHolderTeam.setListPlayer(playerList);
        
    }
    
    
    
    public void toggleStrategyPlay() {
        if (!this.mMouseFSM.isPlaying()) {
            this.mMouseFSM.startPlaying();
            System.out.println("playStrategy appelé");
            long startTime = System.nanoTime();
            int maxTime = this.mPlaceHolderStrategy.getBiggestTime();
            long timeFromWhichToStartPlaying = this.timeViewer;
            while ((System.nanoTime() - startTime)/1000000 + timeFromWhichToStartPlaying < maxTime+100) {
                //the showing loop
                if (!this.mMouseFSM.isPlaying()) {
                    System.out.println("broke out of playing loop");
                    break;
                }
                this.timeViewer = (int) ((System.nanoTime()- startTime)/1000000 + timeFromWhichToStartPlaying);
                System.out.println("current time in viewing is " + this.timeViewer);
                drawCurrentFrame();
            }
            this.mMouseFSM.stopPlaying();
            System.out.println("fin Visualisation");
           //viewerState = (!viewerState.equals(StrategyViewerState.Play)) ? StrategyViewerState.Play : StrategyViewerState.Pause;
        } else {
            System.out.println("paused");
            this.mMouseFSM.stopPlaying();
        }
    }
    
    public void playStrategyNextFrame() {
        if(viewerState.equals(StrategyViewerState.Play))
        {
            //timeViewer++;
            //The animation here
            //this.loadedStrategy.getFrame();
        }
        this.drawCurrentFrame();
    }
      
    public void playStepBackTimeFrame() {
        timeViewer -= this.intervalTimeinMS;
        if (timeViewer < 0) {
            timeViewer = 0;
        }
        //playStrategyNextFrame();
        this.drawCurrentFrame();
    }
    
    public void playStepFowardTimeFrame() {
        timeViewer += this.intervalTimeinMS;
        int biggestTime = this.mPlaceHolderStrategy.getBiggestTime();
        if (timeViewer > biggestTime) {
            timeViewer = biggestTime;
        }
        this.drawCurrentFrame();
    }
    
    public void mouseMoved(int mousePosX, int mousePosY, boolean mousePressed) {
        try {
        this.mMouseFSM.updateMouse(mousePosX, mousePosY, mousePressed);
        }
        catch (Exception Ex) {
        System.out.println("exception in mouseMoved in Controller");
        System.out.println(Ex);
    }
    }
    
    public void initiateRotationMode() {
        this.mMouseFSM.switchToRotationMode();
    }
    
    public void stopRotationMode() {
        this.mMouseFSM.switchToMovementMode();
    }
    
    public void setZoomPoint1(int mousePosX, int mousePosY) {
        this.myScene.setPoint1(mousePosX, mousePosY);
    }
    
    public void setZoomPoint2(int mousePosX, int mousePosY) {
        this.myScene.setPoint2(mousePosX, mousePosY);
    }
    public void setSceneSize(int pSceneSizeX, int pSceneSizeY) {
        this.myScene.setSceneSize(pSceneSizeX, pSceneSizeY);
    }
    
    public void setSceneBackground() {
        myScene.setBackground(this.mPlaceHolderStrategy.getSport().getImg());
    }
    
    public void drawCurrentFrame() {
        // Draws the current frame on screen
        //this.mPlaceHolderStrategy.getFrame();
        myScene.cleanScene();
        Snapshot snapshotToPrint = this.mPlaceHolderStrategy.getCurrentSnapshot(timeViewer);
        snapshotToPrint.printPlayers(myScene);
        this.mMainWindow.publishScene(myScene.getScenePicture());
        this.mMainWindow.publishCurrentTime(snapshotToPrint.getTimeStamp()/1000);
        System.out.println("Just drew a frame!");
    }
        
    public void switchZoomMode() {
        this.mMouseFSM.startZoomMode();
    }
    
    public boolean isZoomed() {
        return this.myScene.isZoomed();
    }
    
    public void unzoom() {
        this.myScene.unzoom();
    }
    
    public void displayMouseCoordinates(int mousePosX, int mousePosY) {
        DecimalFormat formatterObject = new DecimalFormat("0.00");
        formatterObject.setMaximumFractionDigits(3);
        String xString = "X:" + formatterObject.format(this.myScene.getNormalizedX(mousePosX)*this.mPlaceHolderStrategy.getSport().getHorizontalSize()) + this.mPlaceHolderStrategy.getSport().getDimentionUnit();
        String yString = " Y:" + formatterObject.format(this.myScene.getNormalizedY(mousePosY)*this.mPlaceHolderStrategy.getSport().getVerticalSize()) + this.mPlaceHolderStrategy.getSport().getDimentionUnit();
        this.mMainWindow.publishMousePosition(xString+yString);
    }
    
    public void playerAddMode(String pPlayerName) {
        //TODO!
        if (this.mPlaceHolderStrategy.doesPlayerExist(pPlayerName)) {
            this.mMouseFSM.switchToAddMode(pPlayerName);
            this.mPlaceHolderStrategy.getCurrentSnapshot(timeViewer);
        }
        else {
            System.out.println("Selected player that does not exist!");
        }
    }
    
    public Strategy getCurrentStrategy () {
        return this.mPlaceHolderStrategy;
    }
    
    public int getCurrentTime() {
        return this.timeViewer;
    }
    
    public Player getPlayer(String pPlayerName) throws Exception{
        return this.mPlaceHolderStrategy.getPlayer(pPlayerName);
    }
    
    public Scene getScene() {
        return this.myScene;
    }
    
    public void setShowStringOption(boolean newValue) {
        this.mMouseFSM.setShowStringOption(newValue);
    }
    
    public void setIntervalTime(float timeValueInSecond) {
        this.intervalTimeinMS = (int) (timeValueInSecond*1000);
    }
    
    public void switchToNextFrame() {
        this.actionWillHappen();
        this.timeViewer += this.intervalTimeinMS;
        if (!this.mPlaceHolderStrategy.frameExistsAtTime(this.timeViewer)) {
        Snapshot oldSnapshot = this.mPlaceHolderStrategy.getLastSnapshotBefore(this.timeViewer);
            Snapshot newSnapshot = this.mPlaceHolderStrategy.getOrCreate(this.timeViewer);
            newSnapshot.copyFromOtherSnapshot(oldSnapshot);
        }
        this.drawCurrentFrame();
    }
    public void nukeAllSnapshots() {
    this.mPlaceHolderStrategy.setListSnapshot(new ArrayList());
}
    // This function updates the undo/redo lists, please use BEFORE modification
    public void actionWillHappen() {
        redoList = new ArrayList(); // the redo list is emptied
        if (this.mPlaceHolderStrategy == null) {
            System.out.println("wtf, actionWillHappen");
        }
        undoList.add(new Strategy(this.mPlaceHolderStrategy)); //Strategy is copied in the undo array
        if (undoList.size() > this.maxUndoRedo) {
            undoList.remove(0);
        }
        System.out.println("Action will happen!");
        
    }
    
    // This function executes an "undo" on the strategy
    public void tryUndo() {
        //first, check if the undo list isn't empty
        if (!undoList.isEmpty()) {
            redoList.add(new Strategy(this.mPlaceHolderStrategy)); // add current state to redoList
            this.mPlaceHolderStrategy = new Strategy(undoList.get(undoList.size()-1));
            undoList.remove(undoList.size()-1);
            
            System.out.println("Undo done!");
        }
        this.drawCurrentFrame();
    }
    
    public void tryRedo() {
        //first, check if the redo list isn't empty
        if (!redoList.isEmpty()) {
            undoList.add(new Strategy(this.mPlaceHolderStrategy));
            this.mPlaceHolderStrategy = new Strategy(redoList.get(redoList.size()-1));
            redoList.remove(redoList.size()-1);
            System.out.println("Redo done!");
        }
        this.drawCurrentFrame();
    }
    
    public void setModificationMode(String pMode) {
        this.mMouseFSM.setModificationMode(pMode);
    }
}
