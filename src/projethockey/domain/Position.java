package projethockey.domain;

/**
 *
 * @author Alexandre
 */
public class Position {
    private float posX;
    private float posY;
    
    public Position() {
       this.posX = 0;
       this.posY = 0;
    }
    
    public Position(float posX, float posY) {
       this.posX = posX;
       this.posY = posY;
    }
    
    public Position(Position position) {
       this.posX = position.posX;
       this.posY = position.posY;
    }
        
    public float getPositionX() {
        return this.posX;
    }
    
    public void setPositionX(int posX) {
       this.posX = posX;
    }
    
    public float getPositionY() {
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
