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
public class Player {
    private int objectAssocied;
    private CategoryPlayer categoryPlayer;
    private Orientation orientation;
    private Position position;
    private String role;
    private boolean visible;
    
    
    
    
    //private var gestion;

    public Player() {
    }

    public Player(Player player) {
        this.objectAssocied = player.objectAssocied;
        this.categoryPlayer = player.categoryPlayer;
        this.orientation = player.orientation;
        this.position = player.position;
        this.role = player.role;
        this.visible = player.visible;
    }
    
    public Player(int objectAssocied, CategoryPlayer categoryPlayer, Orientation orientation, Position position, String role, boolean visible) {
        this.objectAssocied = objectAssocied;
        this.categoryPlayer = categoryPlayer;
        this.orientation = orientation;
        this.position = position;
        this.role = role;
        this.visible = visible;
    }

    public int getObjectAssocied() {
        return objectAssocied;
    }

    public void setObjectAssocied(int objectAssocied) {
        this.objectAssocied = objectAssocied;
    }

    public CategoryPlayer getCategoryPlayer() {
        return categoryPlayer;
    }

    public void setCategoryPlayer(CategoryPlayer categoryPlayer) {
        this.categoryPlayer = categoryPlayer;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
