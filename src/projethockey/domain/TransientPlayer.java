/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

/**
 *
 * @author Alexandre
 */
public class TransientPlayer {
    private float posX;
    private float posY;
    private Orientation orientation;
    private Player player;
    private boolean visible;
    
    public TransientPlayer(float posX, float posY, float pAngle, Player player, boolean visible) {
        this.posX = posX;
        this.posY = posY;
        this.player = player;
        this.visible = visible;
    }
    
    public TransientPlayer(TransientPlayer transientPlayer) {
        this.posX = transientPlayer.posX;
        this.posY = transientPlayer.posY;
        this.orientation = transientPlayer.orientation;
        this.player = transientPlayer.player;
        this.visible = transientPlayer.visible;
    }


    public float getPosX() {
        return posX;
    }
    
    public float getPosY() {
        return posY;
    }


    public void setPosition(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}