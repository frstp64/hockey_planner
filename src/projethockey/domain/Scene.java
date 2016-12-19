/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.lang.Integer.max;
import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.awt.AlphaComposite;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

/**
 *
 * @author znuxor
 */

public class Scene {
    
    float ratioIdealPlayer = (float) 0.02; // The target percentage of area
    protected int sceneSizeX, sceneSizeY; // The size in pixels of the scene
    private boolean isZoomed;
    private int zoomX1, zoomX2, zoomY1, zoomY2; // the Coordinates in pixels of the zoom
    private ArrayList<Integer> playerCoordX1; //list of the X coordinates of each player, normalized
    private ArrayList<Integer> playerCoordY1; // same, Y coordinates, normalized
    private ArrayList<Integer> playerCoordX2; //list of the X coordinates of each player, normalized
    private ArrayList<Integer> playerCoordY2; // same, Y coordinates, normalized
    private ArrayList<String> playerNames;
    private ArrayList<Integer> objectCoordX1; //list of the X coordinates of each player, normalized
    private ArrayList<Integer> objectCoordY1; // same, Y coordinates, normalized
    private ArrayList<Integer> objectCoordX2; //list of the X coordinates of each player, normalized
    private ArrayList<Integer> objectCoordY2; // same, Y coordinates, normalized
    private ArrayList<Integer> objectUIDs;
    
    protected BufferedImage sceneImage;
    private BufferedImage backgroundPicture;
    private boolean showTextOption;
    
    private Sport sport;
    
    public Scene(int pSceneSizeX, int pSceneSizeY, Sport pSport) {
        sceneSizeX = pSceneSizeX;
        sceneSizeY = pSceneSizeY;
        isZoomed = false;
        sceneImage = new BufferedImage(sceneSizeX, sceneSizeY, BufferedImage.TYPE_INT_ARGB);
        playerCoordX1 =  new ArrayList();
        playerCoordY1 =  new ArrayList();
        playerCoordX2 =  new ArrayList();
        playerCoordY2 =  new ArrayList();
        playerNames =  new ArrayList();
        objectCoordX1 =  new ArrayList();
        objectCoordY1 =  new ArrayList();
        objectCoordX2 =  new ArrayList();
        objectCoordY2 =  new ArrayList();
        objectUIDs =  new ArrayList();
        this.showTextOption = false;
        this.sport = pSport;
    }
    
    public void setBackground(BufferedImage pbackgroundPicture) {
        backgroundPicture = pbackgroundPicture;
    }
    
    public void setSceneSize(int pSceneSizeX, int pSceneSizeY) {
        sceneSizeX = pSceneSizeX;
        sceneSizeY = pSceneSizeY;
        sceneImage = new BufferedImage(sceneSizeX, sceneSizeY, BufferedImage.TYPE_INT_ARGB);
    }
    public void cleanScene() {
        Graphics2D cloneG = sceneImage.createGraphics();
        cloneG.drawImage(backgroundPicture.getScaledInstance(sceneSizeX, sceneSizeY, BufferedImage.SCALE_FAST), 0, 0, null);
        playerCoordX1 =  new ArrayList();
        playerCoordY1 =  new ArrayList();
        playerCoordX2 =  new ArrayList();
        playerCoordY2 =  new ArrayList();
        playerNames =  new ArrayList();
        objectCoordX1 =  new ArrayList();
        objectCoordY1 =  new ArrayList();
        objectCoordX2 =  new ArrayList();
        objectCoordY2 =  new ArrayList();
        objectUIDs =  new ArrayList();
    }
    
    public void putPicture(Image itemPicture, int locX, int locY, boolean isTransparent) {
        
        Graphics2D cloneG = sceneImage.createGraphics();
        if(isTransparent)
            cloneG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2F));
        cloneG.drawImage(itemPicture, locX, locY, null); // might require some cutting
    }    
    
    public void putText(int locX, int locY, String pStringToShow) {
        
        Graphics2D cloneG = sceneImage.createGraphics();
         cloneG.setColor(Color.RED);
         cloneG.drawString(pStringToShow, locX, locY);
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
        // The iteration
        int realCoordX = (int) (((float) this.sceneSizeX) * this.getNormalizedX(coordX));
        int realCoordY = (int) (((float) this.sceneSizeY) * this.getNormalizedY(coordY));
        for(int j = playerNames.size() - 1; j >= 0; j--){
            //pass
            if (realCoordX <= playerCoordX2.get(j)
             && realCoordX >= playerCoordX1.get(j)
             && realCoordY <= playerCoordY2.get(j)
             && realCoordY >= playerCoordY1.get(j)) {
                System.out.println("intersection happened!");
                return playerNames.get(j);
            }
    }
        
        return "NoneIntersecting"; // None intersecting
    }
    
    public int getIntersectingObstacleUID(int coordX, int coordY) {
        // The iteration
        int realCoordX = (int) (((float) this.sceneSizeX) * this.getNormalizedX(coordX));
        int realCoordY = (int) (((float) this.sceneSizeY) * this.getNormalizedY(coordY));
        for(int j = objectUIDs.size() - 1; j >= 0; j--){
            //pass
            if (realCoordX <= objectCoordX2.get(j)
             && realCoordX >= objectCoordX1.get(j)
             && realCoordY <= objectCoordY2.get(j)
             && realCoordY >= objectCoordY1.get(j)) {
                System.out.println("intersection happened!");
                return objectUIDs.get(j);
            }
    }
        
        return -1; // None intersecting
    }
    
    private float absoluteToRelativeCoordX(int pCoordX) {
        return ((float) pCoordX)/sceneSizeX;
    }
    
    private float absoluteToRelativeCoordY(int pCoordY) {
        return ((float) pCoordY)/sceneSizeY;
    }
    
    public void putPlayer(float pCoordX, float pCoordY, Image playerImage, String playerName, boolean isTransparent, float pAngle) {
        // Size computation
        int imArea = playerImage.getWidth(null) * playerImage.getHeight(null);
        int sceneArea = sceneSizeX * sceneSizeY;
        float sideFactor = (float) sqrt( (double) ratioIdealPlayer * (double) sceneArea/imArea);
        int wantedWidth  = (int) (playerImage.getWidth(null)  *  sideFactor);
        int wantedHeight = (int) (playerImage.getHeight(null) * sideFactor);
        
        // Position computation
        int wantedX1 = (int) (pCoordX*sceneSizeX)-wantedWidth/2;
        int wantedX2 = wantedX1+wantedWidth;
        int wantedY1 = (int) (pCoordY*sceneSizeY)-wantedHeight/2;
        int wantedY2 = wantedY1+wantedWidth;
        float wantedRelativeX1 = ((float) wantedX1)/sceneSizeX;
        float wantedRelativeX2 = ((float) wantedX2)/sceneSizeX;
        float wantedRelativeY1 = ((float) wantedY1)/sceneSizeY;
        float wantedRelativeY2 = ((float) wantedY2)/sceneSizeY;
        this.playerCoordX1.add(wantedX1);
        this.playerCoordX2.add(wantedX2);
        this.playerCoordY1.add(wantedY1);
        this.playerCoordY2.add(wantedY2);
        this.playerNames.add(playerName);
        
        AffineTransform myTransform = new AffineTransform();
        myTransform.rotate(pAngle, playerImage.getWidth(null)/2, playerImage.getHeight(null)/2);
        AffineTransformOp myOp = new AffineTransformOp(myTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        Image playerImageToShow = myOp.filter((BufferedImage) playerImage, null);


        this.putPicture(playerImageToShow.getScaledInstance(max(10, wantedWidth), max(10, wantedHeight), BufferedImage.SCALE_FAST), wantedX1, wantedY1, isTransparent);
       
        // TODO: show the strings
        if(this.showTextOption) {
            
            this.putText(wantedX1, wantedY1+10, playerName);
        }
    }
    
    public void putObject(TransientObject pObject) {
        // Size computation (pixels
        int objectWidth = (int) (pObject.getObject().getHorizontalSize() / this.sport.getHorizontalSize() * this.sceneSizeX);
        int objectHeight = (int) (pObject.getObject().getVerticalSize() / this.sport.getVerticalSize() * this.sceneSizeY);
        
        
        // Position computation
        int wantedX1 = (int) (pObject.getPosX()*this.sceneSizeX)-objectWidth/2;
        int wantedX2 = wantedX1+objectWidth;
        int wantedY1 = (int) (pObject.getPosY()*this.sceneSizeY)-objectHeight/2;
        int wantedY2 = wantedY1+objectHeight;
        float wantedRelativeX1 = ((float) wantedX1)/sceneSizeX;
        float wantedRelativeX2 = ((float) wantedX2)/sceneSizeX;
        float wantedRelativeY1 = ((float) wantedY1)/sceneSizeY;
        float wantedRelativeY2 = ((float) wantedY2)/sceneSizeY;
        this.objectCoordX1.add(wantedX1);
        this.objectCoordX2.add(wantedX2);
        this.objectCoordY1.add(wantedY1);
        this.objectCoordY2.add(wantedY2);
        this.objectUIDs.add(pObject.getUID());

        System.out.println("objectinfo");
        System.out.println(pObject.getPosX());
        System.out.println(wantedX1);
        System.out.println(wantedY1);

        this.putPicture(pObject.getObject().getImg().getScaledInstance(max(10, objectWidth), max(10, objectHeight), BufferedImage.SCALE_FAST), wantedX1, wantedY1, false);
       
    }
    
    public boolean isZoomed() {
        return this.isZoomed;
    }
    
    
    // Deals with the zoom too!
    public float getNormalizedX(int pixelX) {
        float relativeX;
        if(isZoomed) {
        relativeX = ((((float)pixelX)/sceneSizeX)*(zoomX2-zoomX1) + zoomX1)/sceneSizeX;        
        } else {
            relativeX =  (float)pixelX/sceneSizeX;
        }
        if (relativeX < 0) {
            relativeX = 0;
        } else if (relativeX > 1) {
            relativeX = 1;
        }
        return relativeX;
    }
    public float getNormalizedY(int pixelY) {
        float relativeY;
        if(isZoomed) {
            relativeY = ((((float)pixelY)/sceneSizeY)*(zoomY2-zoomY1) + zoomY1)/sceneSizeY;
        } else {
            relativeY = (float)pixelY/sceneSizeY;
        }
        if (relativeY < 0) {
            relativeY = 0;
        } else if (relativeY > 1) {
            relativeY = 1;
        }
        return relativeY;
    }
    
    public void setStringShowOption(boolean newValue) {
        this.showTextOption = newValue;
    }
    
    // remove the collision detection for the printed objects, they are effectively stuck to thebackground
    public void setAsBg() {
        playerCoordX1 = new ArrayList(); 
        playerCoordY1 = new ArrayList();
        playerCoordX2 = new ArrayList();
        playerCoordY2 = new ArrayList();
        playerNames = new ArrayList();
    }
}
