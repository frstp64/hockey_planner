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
    
    public EditionStateMachine(Controller pController) {
        currentState = States.MOVEMENT;
        myController = pController;
    }
    
    public void switchToRotationMode() {
        currentState = States.ROTATION;
    }
    
    public void switchToMovementMode() {
        currentState = States.MOVEMENT;
    }
    
    public void updateMouse(int mousePosX, int mousePosY, boolean mouseButtonState) {
        System.out.println("updated mouse");
        if        (currentState.equals(States.MOVEMENT) && mouseButtonState) {
            // Button has been pressed in movement mode
            
            // To switch to player movement mode, we first need to have one intersecting the mouse
            //this.myController.checkIfIntersect()
        } else if (currentState.equals(States.MOVING_PLAYER) && !mouseButtonState) {
            // Button has been unpressed in movement mode
            currentState = States.MOVEMENT;
            // 99% SURE THIS IS ACTUALLY DONE THX
        } else if (currentState.equals(States.ROTATION) && mouseButtonState) {
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
            this.myController.setZoomPoint1(mousePosX, mousePosY);
            System.out.println("Set point 1 for zoom");
        } else if (currentState.equals(States.ZOOM_CLICK_2_UNPRESSED) && mouseButtonState) {
            // Button has been pressed, we switch to press, nothing else to do
            currentState = States.ZOOM_CLICK_1_PRESSED;
            // 99% SURE THIS IS ACTUALLY DONE THX
        } else if (currentState.equals(States.ZOOM_CLICK_2_PRESSED) && !mouseButtonState) {
            // Button has been unpressed, we return to movement mode
            this.myController.setZoomPoint2(mousePosX, mousePosY);
            System.out.println("Set point 2 for zoom");
            this.myController.drawCurrentFrame();
            System.out.println("remove me pls");;
        } 
    }
    
    public void startZoomMode() {
        currentState = States.ZOOM_CLICK_1_UNPRESSED;
    }
    
}
