/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author znuxor
 */


public class Scene {
    private int sceneSizeX, sceneSizeY;
    private BufferedImage sceneImage;
    
    public Scene(int pSceneSizeX, int pSceneSizeY) {
        sceneSizeX = pSceneSizeX;
        sceneSizeY = pSceneSizeY;
        sceneImage = new BufferedImage(sceneSizeX, sceneSizeY, BufferedImage.TYPE_INT_RGB);
    }
    
    public void putBackground(BufferedImage backgroundPicture) {
        Graphics2D cloneG = sceneImage.createGraphics();
        cloneG.drawImage(backgroundPicture.getScaledInstance(sceneSizeX, sceneSizeY, 0), 0, 0, null);
    }
    
    public void putPicture(BufferedImage itemPicture, int locX, int locY) {
        
        Graphics2D cloneG = sceneImage.createGraphics();
        cloneG.drawImage(itemPicture, locX, locY, null); // might require some cutting
    }
    
    public BufferedImage getScenePicture() {
        return sceneImage;
    }
}
