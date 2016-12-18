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
public class BlackBoard extends Scene {
    public BlackBoard(int pSceneSizeX, int pSceneSizeY) {
        super(pSceneSizeX, pSceneSizeY);
    }
    
    public void drawStrategy(Strategy pStrategy) {
        // We start by drawing the players at their starting position
        Snapshot starterSnapshot = pStrategy.pullStarterSnapshot();
        starterSnapshot.printPlayers(this);
    }
}
