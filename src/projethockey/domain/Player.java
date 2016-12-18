package projethockey.domain;

/**
 *
 * @author Alexandre
 */
public class Player implements java.io.Serializable {
    private CategoryPlayer categoryPlayer;
    private String name;
    private String nomEquipe;
    
    //private var gestion;

    public Player() {
        this.categoryPlayer = null;
        this.name = null;
        this.nomEquipe = "";
        
    }

    public Player(Player player) {
        this.categoryPlayer = player.categoryPlayer;
        this.name = player.name;     
        this.nomEquipe = player.nomEquipe;
    }

    public CategoryPlayer getCategoryPlayer() {
        return categoryPlayer;
    }
    
    public String getCategoryPlayerName() {
        return categoryPlayer.getCategoryName();
    }

    public void setCategoryPlayer(CategoryPlayer categoryPlayer) {
        this.categoryPlayer = categoryPlayer;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void reset() {
        this.categoryPlayer = null;
        this.name = null;
    }
    
    public boolean isValid() {
        if (this.categoryPlayer != null && this.name != null && !(this.name.isEmpty())) {
            return true;
        }
        else {
            return false;
        }
    }
    
    // The identity of a player, lets us have a player in multiple teams
    public String getIdentity() {
        return this.name + " " + this.nomEquipe;
    }
    
    public void setTeamName(String pTeamName) {
        this.nomEquipe = pTeamName;
    }
}
    