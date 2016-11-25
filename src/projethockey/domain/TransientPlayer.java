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
    private Position postion;
    private Orientation orientation;
    private Player player;
    private boolean visible;

    
    public TransientPlayer(TransientPlayer transientPlayer) {
        this.postion = transientPlayer.postion;
        this.orientation = transientPlayer.orientation;
        this.player = transientPlayer.player;
        this.visible = transientPlayer.visible;
    }
    
    public TransientPlayer(Position postion, Orientation orientation, Player player, boolean visible) {
        this.postion = postion;
        this.orientation = orientation;
        this.player = player;
        this.visible = visible;
    }

    public Position getPostion() {
        return postion;
    }

    public void setPostion(Position postion) {
        this.postion = postion;
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