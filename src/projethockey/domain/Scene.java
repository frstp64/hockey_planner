/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;
import static java.lang.Math.min;
import java.util.ArrayList;

/**
 *
 * @author znuxor
 */

public class Scene {
    
    float ratioIdealPlayer = (float) 0.05; // The target percentage of area
    private int sceneSizeX, sceneSizeY; // The size in pixels of the scene
    private boolean isZoomed;
    private int zoomX1, zoomX2, zoomY1, zoomY2; // the Coordinates in pixels of the zoom
    private ArrayList<Float> playerCoordX1; //list of the X coordinates of each player, normalized
    private ArrayList<Float> playerCoordY1; // same, Y coordinates, normalized
    private ArrayList<Float> playerCoordX2; //list of the X coordinates of each player, normalized
    private ArrayList<Float> playerCoordY2; // same, Y coordinates, normalized
    private ArrayList<String> playerNames;
    
    private BufferedImage sceneImage;
    private BufferedImage backgroundPicture;
    
    public Scene(int pSceneSizeX, int pSceneSizeY) {
        sceneSizeX = pSceneSizeX;
        sceneSizeY = pSceneSizeY;
        isZoomed = false;
        sceneImage = new BufferedImage(sceneSizeX, sceneSizeY, BufferedImage.TYPE_INT_ARGB);
        playerCoordX1 =  new ArrayList();
        playerCoordY1 =  new ArrayList();
        playerCoordX2 =  new ArrayList();
        playerCoordX2 =  new ArrayList();
        playerNames =  new ArrayList();
    }
    
    public void setBackground(BufferedImage pbackgroundPicture) {
        backgroundPicture = pbackgroundPicture;
        Graphics2D cloneG = sceneImage.createGraphics();
        cloneG.drawImage(backgroundPicture.getScaledInstance(sceneSizeX, sceneSizeY, 0), 0, 0, null);
    }
    
    public void putPicture(BufferedImage itemPicture, int locX, int locY) {
        
        Graphics2D cloneG = sceneImage.createGraphics();
        cloneG.drawImage(itemPicture, locX, locY, null); // might require some cutting
    }
    
    public Image getScenePicture() {
        if (!isZoomed) {
            return sceneImage;
        } else { // returns the subpicture, scaled back to full size
            return sceneImage.getSubimage(min(zoomX1, zoomX2), 
                                          min(zoomY1, zoomY2),
                                          abs(zoomX2-zoomX1),
                                          abs(zoomY2-zoomY1)).getScaledInstance(sceneSizeX, sceneSizeY, BufferedImage.SCALE_FAST);
        }
    }
    
    public void unzoom() {
        isZoomed = false;
    }
    
    public void setPoint1(int pCoordX, int pCoordY) {
        zoomX1 = pCoordX;
        zoomY1 = pCoordY;
    }
    public void setPoint2(int pCoordX, int pCoordY) {
        zoomX2 = pCoordX;
        zoomY2 = pCoordY;
        isZoomed = true;
    }
    
    public String getIntersectingPlayerName(int coordX, int coordY) {
        float relativeCoordX = 0, relativeCoordY = 0;
        // The iteration
        for(int j = playerNames.size() - 1; j >= 0; j--){
            //pass
            if (relativeCoordX <= playerCoordX2.get(j)
             && relativeCoordX >= playerCoordX1.get(j)
             && relativeCoordY <= playerCoordY2.get(j)
             && relativeCoordY >= playerCoordY1.get(j)) {
                System.out.println("intersection happened!");
                return playerNames.get(j);
            }
    }
        return ""; // None intersecting
    }
    
    private float absoluteToRelativeCoordX(int pCoordX) {
        return ((float) pCoordX)/sceneSizeX;
    }
    
    private float absoluteToRelativeCoordY(int pCoordY) {
        return ((float) pCoordY)/sceneSizeY;
    }
    
    public void putPlayer(int pCoordX, int pCoordY, Image playerImage) {
        int imArea = playerImage.getWidth(null) * playerImage.getHeight(null);
        int sceneArea = sceneSizeX * sceneSizeY;
        float sideFactor = ratioIdealPlayer *sceneArea/imArea;
        int wantedWidth = playerImage.getWidth(null) * (int) sideFactor;
        
        int wantedHeight = playerImage.getHeight(null) * (int) sideFactor;
        playerImage.getScaledInstance(wantedWidth, wantedHeight, BufferedImage.SCALE_FAST);
    }
}
