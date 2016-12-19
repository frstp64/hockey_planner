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
        DELETION,
        DELETING,
        ADDING_PLAYER,
        MOVING_PLAYER,
        MOVING_OBJECT,
        ADDING_OBJECT,
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
    private String currentAddedPlayer, currentMovingPlayer, currentRotatingPlayer, currentAddedObject;
    private int currentMovingObject;
    private int initialRotationPosX, initialRotationPosY;
    private long initialTimeRealTime; // the initial time for real time modifications
    private String modificationMode;
    private boolean isPlayingStrategy;
    
    public EditionStateMachine(Controller pController) {
        currentState = States.MOVEMENT;
        myController = pController;
        currentAddedPlayer = "";
        currentMovingPlayer = "";
        modificationMode = "Image par image";
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

            // To switch to player movement mode, we first need to have one intersecting the mouse
            String intersectingPlayer = this.myController.getScene().getIntersectingPlayerName(mousePosX, mousePosY);
            int intersectingObject = this.myController.getScene().getIntersectingObstacleUID(mousePosX, mousePosY);
            
            long currentTime = this.myController.getCurrentTime();
            Strategy currentStrategy = this.myController.getCurrentStrategy();
            if (intersectingObject != -1 && !currentStrategy.isAnObstacle(intersectingObject)) {
                this.initialTimeRealTime = System.nanoTime()/1000000 - this.myController.getCurrentTime();
                currentState = States.MOVING_OBJECT;
                this.myController.actionWillHappen();
                this.currentMovingObject = intersectingObject;
            }
            else if (!intersectingPlayer.equals("NoneIntersecting")) {
                this.initialTimeRealTime = System.nanoTime()/1000000 - this.myController.getCurrentTime();
                currentState = States.MOVING_PLAYER;
                this.myController.actionWillHappen();
                this.currentMovingPlayer = intersectingPlayer;
            }
        } else if (currentState.equals(States.DELETION) && mouseButtonState) {
            // Butthon has been pressed in deletion mode
            // we try to delete an object, then return to movement mode
            int intersectingObstacle = this.myController.getScene().getIntersectingObstacleUID(mousePosX, mousePosY);
            String intersectingPlayer = this.myController.getScene().getIntersectingPlayerName(mousePosX, mousePosY);
            if (intersectingObstacle != -1) {
                currentState = States.MOVEMENT;
                this.myController.actionWillHappen();
                this.myController.getCurrentStrategy().eraseObstacle(intersectingObstacle);
                long currentTime = this.myController.getCurrentTime();
                this.myController.getCurrentStrategy().eraseGameObject(intersectingObstacle);
            }
            else if (!intersectingPlayer.equals("NoneIntersecting")) {
                currentState = States.MOVEMENT;
                this.myController.actionWillHappen();
                this.myController.getCurrentStrategy().erasePlayerAll(intersectingPlayer);
            }
                this.myController.drawCurrentFrame();
            
            
        } else if (currentState.equals(States.ADDING_PLAYER) && mouseButtonState) {
            // button pressed on the screen to add a player
            currentState = States.MOVEMENT;
            this.myController.actionWillHappen();
            long currentTime = this.myController.getCurrentTime();
            Strategy currentStrategy = this.myController.getCurrentStrategy();
            Snapshot currentSnapshot = currentStrategy.pullSnapshot(currentTime);
            Player currentPlayer = this.myController.getPlayer(currentAddedPlayer);
            currentSnapshot.tryAddPlayer(currentPlayer, this.myController.getScene().getNormalizedX(mousePosX), this.myController.getScene().getNormalizedY(mousePosY), 0);
            currentStrategy.insertSnapshot(currentSnapshot);
            this.myController.drawCurrentFrame();
            
        } else if (currentState.equals(States.ADDING_OBJECT) && mouseButtonState) {
            currentState = States.MOVEMENT;
            this.myController.actionWillHappen();
            long currentTime = this.myController.getCurrentTime();
            Strategy currentStrategy = this.myController.getCurrentStrategy();
            Snapshot currentSnapshot = currentStrategy.pullSnapshot(currentTime);
            CategoryObstacle currentObject = this.myController.getObject(currentAddedObject);
            currentStrategy.addNewObject(currentObject, currentTime, this.myController.getScene().getNormalizedX(mousePosX), this.myController.getScene().getNormalizedY(mousePosY));
            
            this.myController.drawCurrentFrame();
            
        } else if (currentState.equals(States.MOVING_PLAYER) && !mouseButtonState) {
            // Button has been unpressed in movement mode
            currentState = States.MOVEMENT;
        } else if (currentState.equals(States.MOVING_OBJECT) && !mouseButtonState) {
            currentState = States.MOVEMENT;

        } else if (currentState.equals(States.ROTATION) && mouseButtonState) {
            // To switch to player movement mode, we first need to have one intersecting the mouse
            String intersectingPlayer = this.myController.getScene().getIntersectingPlayerName(mousePosX, mousePosY);
            
            if (!intersectingPlayer.equals("NoneIntersecting")) {
                this.initialTimeRealTime = System.nanoTime()/1000000 - this.myController.getCurrentTime();
                currentState = States.ROTATING_PLAYER;
                this.myController.actionWillHappen();
                this.currentRotatingPlayer = intersectingPlayer;
                this.initialRotationPosX = mousePosX;
                this.initialRotationPosY = mousePosY;
            }
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
        } else if (currentState.equals(States.ZOOM_CLICK_2_UNPRESSED) && mouseButtonState) {
            // Button has been pressed, we switch to press, nothing else to do
            currentState = States.ZOOM_CLICK_2_PRESSED;
            // 99% SURE THIS IS ACTUALLY DONE THX
        } else if (currentState.equals(States.ZOOM_CLICK_2_PRESSED) && !mouseButtonState) {
            // Button has been unpressed, we return to movement mode
            this.myController.setZoomPoint2(mousePosX, mousePosY);
            this.myController.drawCurrentFrame();
            currentState = States.MOVEMENT;
        } else if (currentState.equals(States.MOVING_PLAYER) && mouseButtonState) {
                float relativeMousePosX = this.myController.getScene().getNormalizedX(mousePosX);
                float relativeMousePosY = this.myController.getScene().getNormalizedY(mousePosY);
                
            if (this.modificationMode.equals("Image par image")) {
                Snapshot aSnapshot = this.myController.getCurrentStrategy().pullSnapshot(this.myController.getCurrentTime());
                aSnapshot.getTransientPlayer(currentMovingPlayer).setPosition(relativeMousePosX, relativeMousePosY);
                aSnapshot.getTransientPlayer(currentMovingPlayer).setVisible(true);
                this.myController.getCurrentStrategy().insertSnapshot(aSnapshot);
                
            } else if (this.modificationMode.equals("Temps réel")) {
                Snapshot previousSnapshot = this.myController.getCurrentStrategy().pullSnapshot(this.myController.getCurrentTime());
                this.myController.setTime(System.nanoTime()/1000000 - this.initialTimeRealTime);
                Snapshot nextSnapshot = this.myController.getCurrentStrategy().pullSnapshot(this.myController.getCurrentTime());
                // we want to take the player and insert it in the new snapshot
                TransientPlayer theTransientPlayer = previousSnapshot.getTransientPlayer(currentMovingPlayer);
                
                //we check if there is an obstacle on the way. if so, we don't move the player
                if (this.myController.getScene().getIntersectingObstacleUID(mousePosX, mousePosY) == -1) {
                    nextSnapshot.tryAddPlayer(theTransientPlayer.getPlayer(), relativeMousePosX, relativeMousePosY, theTransientPlayer.getAngle());
                    this.myController.getCurrentStrategy().insertSnapshot(nextSnapshot);
                }
            }
            
            this.myController.drawCurrentFrame();
            
        } else if (currentState.equals(States.MOVING_OBJECT) && mouseButtonState) {
                float relativeMousePosX = this.myController.getScene().getNormalizedX(mousePosX);
                float relativeMousePosY = this.myController.getScene().getNormalizedY(mousePosY);
            if (this.modificationMode.equals("Image par image")) {
                Snapshot aSnapshot = this.myController.getCurrentStrategy().pullSnapshot(this.myController.getCurrentTime());
                aSnapshot.getTransientObject(currentMovingObject).setPosition(relativeMousePosX, relativeMousePosY);
                //aSnapshot.getTransientPlayer(currentMovingObject).setVisible(true);
                this.myController.getCurrentStrategy().insertSnapshot(aSnapshot);
                
            } else if (this.modificationMode.equals("Temps réel")) {
                Snapshot previousSnapshot = this.myController.getCurrentStrategy().pullSnapshot(this.myController.getCurrentTime());
                this.myController.setTime(System.nanoTime()/1000000 - this.initialTimeRealTime);
                
                Snapshot nextSnapshot = this.myController.getCurrentStrategy().pullSnapshot(this.myController.getCurrentTime());
                // we want to take the player and insert it in the new snapshot
                TransientObject theTransientObject = previousSnapshot.getTransientObject(currentMovingObject);
                nextSnapshot.tryAddObject(theTransientObject, relativeMousePosX, relativeMousePosY);
                this.myController.getCurrentStrategy().insertSnapshot(nextSnapshot);
            }
            
            this.myController.drawCurrentFrame();
            
        } else if (currentState.equals(States.ROTATING_PLAYER) && mouseButtonState) {
            float computedAngle = (float) Math.atan2(mousePosY-this.initialRotationPosY, mousePosX-this.initialRotationPosX);
            if (this.modificationMode.equals("Image par image")) {
                Snapshot aSnapshot = this.myController.getCurrentStrategy().pullSnapshot(this.myController.getCurrentTime());

                aSnapshot.getTransientPlayer(currentRotatingPlayer).setAngle(computedAngle);
                aSnapshot.getTransientPlayer(currentRotatingPlayer).setVisible(true);
                this.myController.getCurrentStrategy().insertSnapshot(aSnapshot);
            } else if (this.modificationMode.equals("Temps réel")) {
                Snapshot previousSnapshot = this.myController.getCurrentStrategy().pullSnapshot(this.myController.getCurrentTime());
                this.myController.setTime(System.nanoTime()/1000000 - this.initialTimeRealTime);
                Snapshot nextSnapshot = this.myController.getCurrentStrategy().pullSnapshot(this.myController.getCurrentTime());
                // we want to take the player and insert it in the new snapshot
                TransientPlayer theTransientPlayer = previousSnapshot.getTransientPlayer(currentMovingPlayer);
                nextSnapshot.tryAddPlayer(theTransientPlayer.getPlayer(), theTransientPlayer.getPosX(), theTransientPlayer.getPosY(), computedAngle);
                this.myController.getCurrentStrategy().insertSnapshot(nextSnapshot);
            }
            this.myController.drawCurrentFrame();
        }
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
    }
    
    public void switchtoAddModeObject(String pObjectName) {
        this.currentState = States.ADDING_OBJECT;
        this.currentAddedObject = pObjectName;
    }
    
    public boolean getShowStringOption() {
        return this.plsShowStrings;
    }
    
    public void setShowStringOption(boolean newValue) {
        this.plsShowStrings = newValue;
        this.myController.getScene().setStringShowOption(newValue);
        this.myController.drawCurrentFrame();
    }
    
    public void setModificationMode(String pMode) {
        this.modificationMode = pMode;
    }
    
    public String getModificationMode() {
        return this.modificationMode;
    }
    
    public boolean isPlaying() {
        return this.isPlayingStrategy;
    }
    
    public void startPlaying() {
        this.isPlayingStrategy = true;
    }
    public void stopPlaying() {
        this.isPlayingStrategy = false;
    }
    
    public void toggleRemovalMode() {
        if (!this.currentState.equals(States.DELETION)) {
            this.currentState = States.DELETION;
        }
        else {
            this.currentState = States.MOVEMENT;
        }
    }
}
