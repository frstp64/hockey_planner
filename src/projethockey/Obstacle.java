package projethockey;

/**
 *
 * @author Alexandre
 */
public class Obstacle {
    private Position position;
    private Orientation orientation;
    private CategoryObstacle categoryObstacle;
    private boolean visible;

    public Obstacle() {
    }

    public Obstacle(Obstacle obstacle) {
        this.position = obstacle.position;
        this.orientation = obstacle.orientation;
        this.categoryObstacle = obstacle.categoryObstacle;
        this.visible = obstacle.visible;
    }
    
    public Obstacle(Position position, Orientation orientation, CategoryObstacle categoryObstacle, boolean visible) {
        this.position = position;
        this.orientation = orientation;
        this.categoryObstacle = categoryObstacle;
        this.visible = visible;
    }    
    
    
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public CategoryObstacle getCategoryObstacle() {
        return categoryObstacle;
    }

    public void setCategoryObstacle(CategoryObstacle categoryObstacle) {
        this.categoryObstacle = categoryObstacle;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
