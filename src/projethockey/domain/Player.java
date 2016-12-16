package projethockey.domain;

/**
 *
 * @author Alexandre
 */
public class Player implements java.io.Serializable {
    private CategoryPlayer categoryPlayer;
    private String name;
    
    //private var gestion;

    public Player() {
        this.categoryPlayer = null;
        this.name = null;
        
    }

    public Player(Player player) {
        this.categoryPlayer = player.categoryPlayer;
        this.name = player.name;     
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
}
    