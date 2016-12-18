/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
    void publishMousePosition(String punits);
    void publishTeamNumber(int number);
    void publishPlayerNumber(int playerNumber);
    void publishSportIsUnlimited(boolean isUnlimited);
    void publishFieldPicture(BufferedImage thePicture);
    
    String requestFilePath();
    void publishObjectTypeNumber(int objectTypeNumber);
    void publishScene(Image pSceneImage);
    
    void publishCategoryPlayerName(String pCategoryPlayerName);
    void publishExistingCategoryPlayer(String[] plistCategoryPlayerName); //??
    void publishCategoryPlayerIcon(BufferedImage thePicture);
    
    void publishCategoryObstacleName(String pCategoryPlayerName);
    void publishCategoryObstacleDimensions(Float pdimX, Float pdimY);
    void publishExistingCategoryObstacle(String[] plistCategoryPlayerName); //??
    void publishCategoryObstacleIsGameObject(Boolean pGameObject);
    void publishCategoryObstacleIcon(BufferedImage thePicture);
    
    void publishStrategyName(String pCategoryPlayerName);
    void publishExistingStrategies(String[] plistStrategyName);
    void publishStrategyPlayers(String[] plistStrategyPlayers);
    void publishStrategyTeams(ArrayList<String> plistTeamNames);
    
    void publishPlayerName(String pPlayerName);
    void publishExistingPlayers(String[] plistPlayerName);
    void publishPlayerCategoryName(String pPlayerCategoryName);
    
    void publishTeamName(String pTeamName);
    void publishExistingTeams(String[] plistTeamName);
    void publishTeamPlayers(ArrayList<String> pPlayerNames);
    
    void publishCurrentTime(float timeInSeconds);
    void publishCurrentSliderTime(long currentTime, long maxTime);
    
    void publishPreview(Image previewImage);
    
    
}
