package projethockey;

/**
 *
 * @author Alexandre
 */
public class Position {
    private int posX;
    private int posY;
    
    public Position() {
       this.posX = 0;
       this.posY = 0;
    }
    
    public Position(int posX, int posY) {
       this.posX = posX;
       this.posY = posY;
    }
    
    public Position(Position position) {
       this.posX = position.posX;
       this.posY = position.posY;
    }
        
    public int getPositionX() {
        return this.posX;
    }
    
    public void setPositionX(int posX) {
       this.posX = posX;
    }
    
    public int getPositionY() {
        return this.posY;
    }
        
    public void setPositionY(int posY) {
       this.posY = posY;
    }
    
    public void setPosition(Position position) {
       this.posX = position.posX;
       this.posY = position.posY;
    }
}
