/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;
import java.awt.image.BufferedImage;
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
    void publishPlayers(); //??
    void publishObjects(); //??
    void publishFieldPicture(BufferedImage thePicture);
    String requestFilePath();
    
}