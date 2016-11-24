package projethockey.domain;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
/**
 *
 * @author Alexandre
 */
public class Sport implements java.io.Serializable{ 
    private String name;
    private String imgPath;
    private String dimentionUnit;
    private Float horizontalSize;
    private Float verticalSize;
    private int nbPlayer;
    private boolean unlimitedPlayer;
    private Orientation fieldOrientation;
    private CategoryPlayer catPlayer;
    //private var objectAssocied;
    
    Sport() {
    }
    
    public Sport(Sport sport) {
        this.name = sport.name;
        this.imgPath = sport.imgPath;
        this.dimentionUnit = sport.dimentionUnit;
        this.nbPlayer = sport.nbPlayer;
        this.fieldOrientation = sport.fieldOrientation;
        this.catPlayer = sport.catPlayer;
        this.unlimitedPlayer = sport.unlimitedPlayer;
    }

    public Sport(String name, String imgPath, String dimentionUnit, int nbPlayer, Orientation fieldOrientation, CategoryPlayer catPlayer) {
        this.name = name;
        this.imgPath = imgPath;
        this.dimentionUnit = dimentionUnit;
        this.nbPlayer = nbPlayer;
        this.fieldOrientation = fieldOrientation;
        this.catPlayer = catPlayer;
        this.unlimitedPlayer = false;
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
        this.unlimitedPlayer = true;
        this.nbPlayer = nbPlayer;
    }

    public Orientation getFieldOrientation() {
        return fieldOrientation;
    }

    public void setFieldOrientation(Orientation fieldOrientation) {
        this.fieldOrientation = fieldOrientation;
    }
    
    public void setHorizontalSize(Float pHorizontalSize) {
        this.horizontalSize = pHorizontalSize;
    }
    public float getHorizontalSize() {
        return this.horizontalSize;
    }
    
    public void setVerticalSize(Float pVerticalSize) {
        this.verticalSize = pVerticalSize;
    }
    
    public float getVerticalSize() {
        return this.verticalSize;
    }
    
    public void reset() {
        this.verticalSize = (float) 0;
        this.horizontalSize = (float) 0;
        this.name = "";
        this.imgPath = "";
        this.dimentionUnit = "";
        this.nbPlayer = 1;
        
    }
    
    public void setPlayers(ArrayList<String> typeArray, ArrayList<String> playerRoleArray) {
        // TODO
    }
    public void setObjects(ArrayList<String> typeArray, ArrayList<Integer> numberArray) {
        //TODO
    }
    
    public void setPlayerLimit(boolean pUnlimitedPlayer){
        this.unlimitedPlayer = pUnlimitedPlayer;
    }
}
