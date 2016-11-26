/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author znuxor
 */
public interface sportSubscribable {

    // change sport name in interface
    void publishExistingSports(String[] plistSportsNames); //??
    void publishSportName(String pSportName);
    void publishDimensions(Float pdimX, Float pdimY);
    void publishUnits(String punits);
    void publishPlayerNumber(int playerNumber);
    void publishSportIsUnlimited(boolean isUnlimited);
    void publishFieldPicture(BufferedImage thePicture);
    
    String requestFilePath();
    void publishObjectTypeNumber(int objectTypeNumber);
    void publishScene(BufferedImage pSceneImage);
    
    void publishCategoryPlayerName(String pCategoryPlayerName);
    void publishCategoryPlayerDimensions(Float pdimX, Float pdimY);
    void publishExistingCategoryPlayer(String[] plistCategoryPlayerName); //??
    void publishCategoryPlayerIcon(BufferedImage thePicture);
    
    void publishCategoryObstacleName(String pCategoryPlayerName);
    void publishCategoryObstacleDimensions(Float pdimX, Float pdimY);
    void publishExistingCategoryObstacle(String[] plistCategoryPlayerName); //??
    void publishCategoryObstacleIsGameObject(Boolean pGameObject);
    void publishCategoryObstacleIcon(BufferedImage thePicture);
    
    void publishStrategyName(String pCategoryPlayerName);
    void publishExistingStrategies(String[] plistStrategyName);
    
    void publishPlayerName(String pPlayerName);
    void publishExistingPlayers(String[] plistPlayerName);
    void publishPlayerCategoryName(String pPlayerCategoryName);
    
    void publishTeamName(String pTeamName);
    void publishExistingTeams(String[] plistTeamName);
    //TODO publish Existing Team Players
    
    //TODO
    // void publishStrategySport
    // void publishStrategyPlayers
    // void publishStrategyObjects
    
}
