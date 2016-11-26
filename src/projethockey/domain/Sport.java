package projethockey.domain;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

/**
 *
 * @author Alexandre
 */
public class Sport implements java.io.Serializable{ 
    private String name;
    private BufferedImage imgField;
    private String dimentionUnit;
    private Float horizontalSize;
    private Float verticalSize;
    private int nbPlayer;
    private boolean unlimitedPlayer;
    private Orientation fieldOrientation;
    private ArrayList<CategoryPlayer> listCatPlayer;
    //private var objectAssocied;
    
    Sport() {
    }
    
    public Sport(Sport sport) {
        this.name = sport.name;
        this.imgField = sport.imgField;
        this.dimentionUnit = sport.dimentionUnit;
        this.horizontalSize = sport.horizontalSize;
        this.verticalSize = sport.verticalSize;
        this.nbPlayer = sport.nbPlayer;
        this.unlimitedPlayer = sport.unlimitedPlayer;
        this.fieldOrientation = sport.fieldOrientation;
        this.listCatPlayer = sport.listCatPlayer;
    }

    public Sport(String name, BufferedImage imgField, String dimentionUnit, Float horizontalSize, Float verticalSize, int nbPlayer, boolean unlimitedPlayer, Orientation fieldOrientation, ArrayList<CategoryPlayer> listCatPlayer) {
        this.name = name;
        this.imgField = imgField;
        this.dimentionUnit = dimentionUnit;
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        this.nbPlayer = nbPlayer;
        this.unlimitedPlayer = unlimitedPlayer;
        this.fieldOrientation = fieldOrientation;
        this.listCatPlayer = listCatPlayer;
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

    public ArrayList<CategoryPlayer> getListCatPlayer() {
        return listCatPlayer;
    }

    public void setListCatPlayer(ArrayList<CategoryPlayer> listCatPlayer) {
        this.listCatPlayer = listCatPlayer;
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
    
    
    public boolean isTeamListValid(ArrayList<Team> listTeam) {
        boolean isValid = true;
        
        //Is the number of player and the category of player alright
        if(this.nbPlayer < listTeam.size())
            isValid = false;
        else {
            for(Team team : listTeam) {
                for(Player player : team.getListPlayer()) {
                    if(!listCatPlayer.contains(player.getCategoryPlayer())) {
                        isValid = false;
                    }
                }                    
            }
        }     
        
        return isValid;
    }
            
}
