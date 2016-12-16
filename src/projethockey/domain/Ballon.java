package projethockey.domain;

/**
 *
 * @author Alexandre
 */
public class Ballon extends Obstacle {
    private String nomSport;

    public Ballon() {
    }

    public String getNomSport() {
        return nomSport;
    }

    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }
}
