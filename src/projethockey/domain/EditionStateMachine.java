/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

/**
 *
 * @author znuxor
 */
public class EditionStateMachine {

    public enum States {
        MOVEMENT,
        ROTATION,
        ADDING_PLAYER,
        MOVING_PLAYER,
        ROTATING_PLAYER,
        ZOOM_CLICK_1_UNPRESSED,
        ZOOM_CLICK_1_PRESSED,
        ZOOM_CLICK_2_UNPRESSED,
        ZOOM_CLICK_2_PRESSED
    }
    
    private Controller myController; // YES YES, VERY BAD PRACTICE, SORRY!
    
    private States currentState;
    private int mousePosX;
    private int mousePosY;
    private boolean plsShowStrings;
    private String currentAddedPlayer, currentMovingPlayer;
    
    public EditionStateMachine(Controller pController) {
        currentState = States.MOVEMENT;
        myController = pController;
        currentAddedPlayer = "";
        currentMovingPlayer = "";
    }
    
    public void switchToRotationMode() {
        currentState = States.ROTATION;
    }
    
    public void switchToMovementMode() {
        currentState = States.MOVEMENT;
    }
    
    public void updateMouse(int mousePosX, int mousePosY, boolean mouseButtonState) throws Exception {
        if (currentState.equals(States.MOVEMENT) && mouseButtonState) {
            // Button has been pressed in movement mode
            //System.out.println("Mode mouvement essayé");

            // To switch to player movement mode, we first need to have one intersecting the mouse
            String intersectingPlayer = this.myController.getScene().getIntersectingPlayerName(mousePosX, mousePosY);
            //System.out.println("Intersecting player is: " + intersectingPlayer);
            
            if (!intersectingPlayer.equals("NoneIntersecting")) {
                currentState = States.MOVING_PLAYER;
                this.currentMovingPlayer = intersectingPlayer;
            }
            
        } else if (currentState.equals(States.ADDING_PLAYER) && mouseButtonState) {
            // button pressed on the screen to add a player
            //System.out.println("asked to add a player!");
            currentState = States.MOVEMENT;
            int currentTime = this.myController.getCurrentTime();
            Strategy currentStrategy = this.myController.getCurrentStrategy();
            Snapshot currentSnapshot = currentStrategy.getCurrentSnapshot(currentTime);
            Player currentPlayer = this.myController.getPlayer(currentAddedPlayer);
            currentSnapshot.addPlayer(currentPlayer, this.myController.getScene().getNormalizedX(mousePosX), this.myController.getScene().getNormalizedY(mousePosY), 0);
            this.myController.drawCurrentFrame();
            
        } else if (currentState.equals(States.MOVING_PLAYER) && !mouseButtonState) {
            // Button has been unpressed in movement mode
            currentState = States.MOVEMENT;
            System.out.println("Mode mouvement en cours, vient d'être terminé");

            // 99% SURE THIS IS ACTUALLY DONE THX
        } else if (currentState.equals(States.ROTATION) && mouseButtonState) {
            System.out.println("Mode rotation");

            // Button has been pressed in Rotation mode
        } else if (currentState.equals(States.ROTATING_PLAYER) && !mouseButtonState) {
            // We return to rotation mode since we're done rotating the thing
            currentState = States.ROTATION;
            // 99% SURE THIS IS ACTUALLY DONE THX
        } else if (currentState.equals(States.ZOOM_CLICK_1_UNPRESSED) && mouseButtonState) {
            // Button has been pressed, we switch to press, nothing else to do
            currentState = States.ZOOM_CLICK_1_PRESSED;
            // 99% SURE THIS IS ACTUALLY DONE THX
        } else if (currentState.equals(States.ZOOM_CLICK_1_PRESSED) && !mouseButtonState) {
            // Button has been unpressed
            currentState = States.ZOOM_CLICK_2_UNPRESSED;
            this.myController.setZoomPoint1(mousePosX, mousePosY);
            System.out.println("Set point 1 for zoom");
        } else if (currentState.equals(States.ZOOM_CLICK_2_UNPRESSED) && mouseButtonState) {
            // Button has been pressed, we switch to press, nothing else to do
            currentState = States.ZOOM_CLICK_2_PRESSED;
            // 99% SURE THIS IS ACTUALLY DONE THX
        } else if (currentState.equals(States.ZOOM_CLICK_2_PRESSED) && !mouseButtonState) {
            // Button has been unpressed, we return to movement mode
            this.myController.setZoomPoint2(mousePosX, mousePosY);
            System.out.println("Set point 2 for zoom");
            this.myController.drawCurrentFrame();
            currentState = States.MOVEMENT;
        } else if (currentState.equals(States.MOVING_PLAYER) && mouseButtonState) {
            //System.out.println("player location changed");
            float relativeMousePosX = this.myController.getScene().getNormalizedX(mousePosX);
            float relativeMousePosY = this.myController.getScene().getNormalizedY(mousePosY);
            this.myController.getCurrentStrategy().getCurrentSnapshot(this.myController.getCurrentTime()).getTransientPlayer(currentMovingPlayer).setPosition(relativeMousePosX, relativeMousePosY);
            this.myController.drawCurrentFrame();
        }
        //System.out.println("x, y");
    }
    
    public void startZoomMode() {
        if (!this.myController.isZoomed()) {
            currentState = States.ZOOM_CLICK_1_UNPRESSED;
        }
        else {
            this.myController.unzoom();
            this.myController.drawCurrentFrame();
        }
    }
    
    public void switchToAddMode(String pPlayerIdentity) {
        this.currentState = States.ADDING_PLAYER;
        this.currentAddedPlayer = pPlayerIdentity;
        System.out.println("Just switched to add mode!");
    }
    
    public boolean getShowStringOption() {
        return this.plsShowStrings;
    }
    
    public void setShowStringOption(boolean newValue) {
        this.plsShowStrings = newValue;
        this.myController.drawCurrentFrame();
    }
}
