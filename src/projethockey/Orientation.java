package projethockey;

/**
 *
 * @author Alexandre
 */
public class Orientation {
    private int angle;
    
    public Orientation(){
        this.angle = 0;
    }
    
    public Orientation(int angle){
        this.angle = angle;
    }
    
    public Orientation(Orientation orientation){
        this.angle = orientation.angle;
    }
    
    
    public int getAngle() {
        return this.angle;
    }
    
    public void setAngle(int angle) {
        this.angle = angle;
    }
}
