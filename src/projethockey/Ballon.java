package projethockey;

/**
 *
 * @author Alexandre
 */
public class Ballon extends Obstacle {
    private String nomSport;

    public Ballon() {
    }

    public Ballon(String nomSport, Obstacle obstacle) {
        super(obstacle);
        this.nomSport = nomSport;
    }

    public Ballon(String nomSport, Position position, Orientation orientation, CategoryObstacle categoryObstacle, boolean visible) {
        super(position, orientation, categoryObstacle, visible);
        this.nomSport = nomSport;
    }

    public String getNomSport() {
        return nomSport;
    }

    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }
}
