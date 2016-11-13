package projethockey.domain;

/**
 *
 * @author Alexandre
 */
public class Sport {
    private String name;
    private String imgPath;
    private String dimentionUnit;
    private int nbPlayer;
    private Orientation fieldOrientation;
    private CategoryPlayer catPlayer;
    //private var objectAssocied;

    public Sport() {
    }
    
    public Sport(Sport sport) {
        this.name = sport.name;
        this.imgPath = sport.imgPath;
        this.dimentionUnit = sport.dimentionUnit;
        this.nbPlayer = sport.nbPlayer;
        this.fieldOrientation = sport.fieldOrientation;
        this.catPlayer = sport.catPlayer;
    }

    public Sport(String name, String imgPath, String dimentionUnit, int nbPlayer, Orientation fieldOrientation, CategoryPlayer catPlayer) {
        this.name = name;
        this.imgPath = imgPath;
        this.dimentionUnit = dimentionUnit;
        this.nbPlayer = nbPlayer;
        this.fieldOrientation = fieldOrientation;
        this.catPlayer = catPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDimentionUnit() {
        return dimentionUnit;
    }

    public void setDimentionUnit(String dimentionUnit) {
        this.dimentionUnit = dimentionUnit;
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }

    public Orientation getFieldOrientation() {
        return fieldOrientation;
    }

    public void setFieldOrientation(Orientation fieldOrientation) {
        this.fieldOrientation = fieldOrientation;
    }
}
