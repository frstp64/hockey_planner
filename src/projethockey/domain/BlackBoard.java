/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethockey.domain;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author znuxor
 */
public class BlackBoard extends Scene {
    public BlackBoard(int pSceneSizeX, int pSceneSizeY, Sport pSport) {
        super(pSceneSizeX, pSceneSizeY, pSport);
    }
    
    public void drawStrategy(Strategy pStrategy) {
        // We start by drawing the players at their starting position
        Snapshot starterSnapshot = pStrategy.pullStarterSnapshot();
        starterSnapshot.printPlayers(this);
        
        // we then draw the lines
        pStrategy.printPlayerLines(this);
    }
    
    public void drawLine(float startRelX, float startRelY, float endRelX, float endRelY) {
        Graphics2D cloneG = sceneImage.createGraphics();
        BasicStroke myStyle = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        cloneG.setStroke(myStyle);
        cloneG.setColor(Color.black);
        int absoluteX1 = (int) (startRelX * this.sceneSizeX);
        int absoluteY1 = (int) (startRelY * this.sceneSizeY);
        int absoluteX2 = (int) (endRelX * this.sceneSizeX);
        int absoluteY2 = (int) (endRelY * this.sceneSizeY);
        cloneG.drawLine(absoluteX1, absoluteY1, absoluteX2, absoluteY2);
    }
}
