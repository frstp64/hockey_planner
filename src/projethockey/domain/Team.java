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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getListPlayer() {
        return listPlayer;
    }
    
    public ArrayList<String> getPlayerNames() {
        
        ArrayList<String> playerNames = new ArrayList();
        
        int index = 0;
        for(Player aPlayer: this.listPlayer){
            playerNames.add(aPlayer.getName());
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
    
    public Player getPlayer(String pPlayerName) throws Exception {
        for (Player aPlayer: this.listPlayer) {
            if (aPlayer.getName().equals(pPlayerName)) {
                return aPlayer;
            }
        }
        throw new Exception("should have called doesPlayerExist");
    }
    
    
}
