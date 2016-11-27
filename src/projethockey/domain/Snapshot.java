package projethockey.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Alexandre
 */
public class Snapshot {
    private int idChange;
    private ArrayList<TransientPlayer> listTransientPlayer;
    private ArrayList<Obstacle> listObstacle;
    private boolean trashed;
    private int timeStamp;
    private String typeSnapshot;

    public Snapshot(int timeStamp) {
        this.timeStamp = timeStamp;
        this.trashed = false;
        this.typeSnapshot = "TODOLATER";
        this.listTransientPlayer = new ArrayList();
        this.listObstacle = new ArrayList();
        this.idChange = -1;
    }

    public Snapshot(Snapshot snapshot) {
        this.idChange = snapshot.idChange;
        this.listTransientPlayer = snapshot.listTransientPlayer;
        this.listObstacle = snapshot.listObstacle;
        this.trashed = snapshot.trashed;
        this.timeStamp = snapshot.timeStamp;
        this.typeSnapshot = snapshot.typeSnapshot;        
    }
    
    public Snapshot(int idChange, ArrayList<TransientPlayer> plistTransientPlayer, ArrayList<Obstacle> listObstacle, boolean trashed, int timeStamp, String typeSnapshot) {
        this.idChange = idChange;
        //this.listTransientPlayer = plistTransientPlayer.;
        this.listObstacle = listObstacle;
        this.trashed = trashed;
        this.timeStamp = timeStamp;
        this.typeSnapshot = typeSnapshot;
    }

    public int getIdChange() {
        return idChange;
    }

    public void setIdChange(int idChange) {
        this.idChange = idChange;
    }

    public List<TransientPlayer> getListTransientPlayer() {
        return listTransientPlayer;
    }

    public void setListTransientPlayer(ArrayList<TransientPlayer> plistTransientPlayer) {
        this.listTransientPlayer = plistTransientPlayer;
    }

    public List<Obstacle> getListObstacle() {
        return listObstacle;
    }

    public void setListObstacle(ArrayList<Obstacle> listObstacle) {
        this.listObstacle = listObstacle;
    }

    public boolean isTrashed() {
        return trashed;
    }

    public void setTrashed(boolean trashed) {
        this.trashed = trashed;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTypeSnapshot() {
        return typeSnapshot;
    }

    public void setTypeSnapshot(String typeSnapshot) {
        this.typeSnapshot = typeSnapshot;
    }
        
    
    public List<Player> getOrCreateListPlayer() {
        throw new UnsupportedOperationException();
        //return listPlayer;
    }

    public List<Obstacle> getOrCreateListObstacle() {
        throw new UnsupportedOperationException();
        //return listObstacle;
    }
    
    // Deals with dubloons
    public void addPlayer(Player pPlayer, float posX, float posY, float pAngle) {
        
        TransientPlayer transientPlayer;
        boolean playerAlreadyExists = false;
        for (TransientPlayer anExistingTransientPlayer: this.listTransientPlayer) {
            if (anExistingTransientPlayer.getPlayer().getName().equals(pPlayer.getName())) {
                playerAlreadyExists = true;
                break;
            }
        }
        if (!playerAlreadyExists) {
            transientPlayer = new TransientPlayer(posX, posY, pAngle, pPlayer, true);
            this.listTransientPlayer.add(transientPlayer);
        }
    }
    
    public void printPlayers(Scene sceneReference) {
        for (TransientPlayer aTransientPlayer: this.listTransientPlayer) {
            System.out.println("now printing " + aTransientPlayer.getPlayer().getName() + " at x=" + aTransientPlayer.getPosX() + " and y="+ aTransientPlayer.getPosY());
            sceneReference.putPlayer(
            aTransientPlayer.getPosX(),
            aTransientPlayer.getPosY(),
            aTransientPlayer.getPlayer().getCategoryPlayer().getImg(),
            aTransientPlayer.getPlayer().getName(),
            aTransientPlayer.getPlayer().getRole()
            );
            aTransientPlayer.getPosX();
            aTransientPlayer.getPosY();
        }
    }
    
    public TransientPlayer getTransientPlayer(String pPlayerName) throws Exception {
        for (TransientPlayer aTransientPlayer: this.listTransientPlayer) {
            if (aTransientPlayer.getPlayer().getName().equals(pPlayerName)) {
                return aTransientPlayer;
            }
        }
        throw new Exception("non-existent transient player");
    }
}
