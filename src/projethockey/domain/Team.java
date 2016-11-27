package projethockey.domain;

import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class Team implements java.io.Serializable {
    private String name;
    private ArrayList<Player> listPlayer;
    
    public Team() {
    }

    public Team(Team team){
        this.name = team.name;
        this.listPlayer = team.listPlayer;
    }           
    
    public Team(String name, ArrayList<Player> listPlayer) {
        this.name = name;
        this.listPlayer = listPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getListPlayer() {
        return listPlayer;
    }
    
    public String[] getPlayerNames() {
        
        String[] playerNames = new String[this.listPlayer.size()];
        
        int index = 0;
        for(Player aPlayer: this.listPlayer){
            playerNames[index] = aPlayer.getName();
            index++;
        }
        return playerNames;
    }

    public void setListPlayer(ArrayList<Player> listPlayer) {
        this.listPlayer = listPlayer;
    }
    
    public void reset(){
        this.name = "";
        this.listPlayer = new ArrayList<Player>();
    }
    
    
}
