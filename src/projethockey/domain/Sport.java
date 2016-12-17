package projethockey.domain;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

/**
 *
 * @author Alexandre
 */
public class Sport implements java.io.Serializable{ 
    private String name;
    private String dimensionUnit;
    private Float horizontalSize;
    private Float verticalSize;
    private int nbPlayer;
    private boolean unlimitedPlayer;
    private int numberMaxTeam;
    //private var objectAssocied;
    
    //make buffered image serializable
    transient BufferedImage imgField;
    
    Sport() {
        this.name = null;
        this.imgField = null;
        this.dimensionUnit = null;
        this.horizontalSize = (float) 0.0;
        this.verticalSize = (float) 0.0;
        this.nbPlayer = 1;
        this.unlimitedPlayer = false;
        this.numberMaxTeam = 1;
    }
    
    public Sport(Sport sport) {
        this.name = sport.name;
        this.imgField = sport.imgField;
        this.dimensionUnit = sport.dimensionUnit;
        this.horizontalSize = sport.horizontalSize;
        this.verticalSize = sport.verticalSize;
        this.nbPlayer = sport.nbPlayer;
        this.unlimitedPlayer = sport.unlimitedPlayer;
        this.numberMaxTeam = sport.numberMaxTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDimentionUnit() {
        return dimensionUnit;
    }

    public void setDimentionUnit(String dimentionUnit) {
        this.dimensionUnit = dimentionUnit;
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
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
    
    public BufferedImage getImg() {
        return this.imgField;
    }

    public void setImg(BufferedImage imgField) {
        this.imgField = imgField;
    }
    
    public boolean isUnlimitedPlayer() {
        return unlimitedPlayer;
    }    
    
    public void setPlayerLimit(boolean pUnlimitedPlayer){
        this.unlimitedPlayer = pUnlimitedPlayer;
    }

    public int getNumberMaxTeam() {
        return numberMaxTeam;
    }

    public void setNumberMaxTeam(int numberMaxTeam) {
        this.numberMaxTeam = numberMaxTeam;
    }

    public void reset() {
        this.verticalSize = (float) 0;
        this.horizontalSize = (float) 0;
        this.name = "";
        this.imgField = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
        this.dimensionUnit = "";
        this.nbPlayer = 1;
        
    }
    
    public boolean isTeamListValid(ArrayList<Team> listTeam) {
        boolean isValid = true;
        
        //Is the number of player and the category of player alright
        if(!this.unlimitedPlayer) {
            for(Team team : listTeam) {
                if (team.getListPlayer().size() > this.nbPlayer) {
                    isValid = false;
                    System.out.println("sport is invalid");
                }
                               
            }
        }     
        
        return isValid;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(imgField, "png", out);
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        imgField = ImageIO.read(in);
    }
    
    public boolean isValid() {
        
        // To complete.
        boolean checkBool = true;
        
        // check if the image exists
        if (this.imgField == null){
            checkBool = false;
        }
        
        // check the validity of the name
        if (this.name == null || this.name.isEmpty()) {
            checkBool = false;
        }
        
        // we need dimensions
        if (this.dimensionUnit == null || this.dimensionUnit.isEmpty()) {
            checkBool = false;
        }
        
        // The size of the field must be strictly positive
        if (this.horizontalSize <= 0 || this.verticalSize <= 0) {
            checkBool = false;
        }
        
        if (this.nbPlayer < 1) {
            checkBool = false;
        }
        
        if (this.numberMaxTeam < 1) {
            checkBool = false;
        }
        
        return checkBool;
    }
            
}
