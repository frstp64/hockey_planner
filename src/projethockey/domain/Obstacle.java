package projethockey.domain;

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
