/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author znuxor
 */
public class TransientObject implements java.io.Serializable {
    private float posX;
    private float posY;
    private CategoryObstacle object;
    private boolean visible;
    private int uID;
    
    // new object
    public TransientObject(float posX, float posY, CategoryObstacle pObstacle, boolean visible) {
        this.posX = posX;
        this.posY = posY;
        this.object = new CategoryObstacle(pObstacle);
        this.visible = visible;
        this.uID = ThreadLocalRandom.current().nextInt(-2000000, 2000000);
    }
    
    // a copy, so the same uid
    public TransientObject(TransientObject transientObject) {
        this.posX = transientObject.posX;
        this.posY = transientObject.posY;
        this.object = transientObject.object;
        this.visible = transientObject.visible;
        this.uID = transientObject.uID;
    }
    public float getPosX() {
        return posX;
    }
    
    public float getPosY() {
        return posY;
    }
    
    public CategoryObstacle getObject() {
        return this.object;
    }
    
    public int getUID() {
        return this.uID;
    }


    public void setPosition(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
