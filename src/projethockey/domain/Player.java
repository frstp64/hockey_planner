package projethockey.domain;

/**
 *
 * @author Alexandre
 */
public class Player implements java.io.Serializable {
    private int objectAssocied;
    private CategoryPlayer categoryPlayer;
    private String name;
    private String role;
    private boolean visible;
    private int idEquipe;
    
    //private var gestion;

    public Player() {
    }

    public Player(Player player) {
        this.objectAssocied = player.objectAssocied;
        this.categoryPlayer = player.categoryPlayer;
        this.name = player.name;
        this.role = player.role;
        this.visible = player.visible;
        this.idEquipe = player.idEquipe;        
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

    public String getRole() {
        return this.getCategoryPlayerName();
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void reset() {
        this.categoryPlayer = new CategoryPlayer();
        this.name = "";
    }
}