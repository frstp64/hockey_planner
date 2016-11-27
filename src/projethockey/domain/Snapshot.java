package projethockey.domain;

import java.util.List;
import java.util.Date;

/**
 *
 * @author Alexandre
 */
public class Snapshot {
    private int idChange;
    private List<TransientPlayer> listTransientPlayer;
    private List<Obstacle> listObstacle;
    private boolean trashed;
    private int timeStamp;
    private String typeSnapshot;

    public Snapshot() {
    }

    public Snapshot(Snapshot snapshot) {
        this.idChange = snapshot.idChange;
        this.listTransientPlayer = snapshot.listTransientPlayer;
        this.listObstacle = snapshot.listObstacle;
        this.trashed = snapshot.trashed;
        this.timeStamp = snapshot.timeStamp;
        this.typeSnapshot = snapshot.typeSnapshot;        
    }
    
    public Snapshot(int idChange, List<TransientPlayer> plistTransientPlayer, List<Obstacle> listObstacle, boolean trashed, int timeStamp, String typeSnapshot) {
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

    public void setListTransientPlayer(List<TransientPlayer> plistTransientPlayer) {
        this.listTransientPlayer = plistTransientPlayer;
    }

    public List<Obstacle> getListObstacle() {
        return listObstacle;
    }

    public void setListObstacle(List<Obstacle> listObstacle) {
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
            sceneReference.putPlayer(
            aTransientPlayer.getPosX(),
            aTransientPlayer.getPosY(),
            aTransientPlayer.getPlayer().getCategoryPlayer().getImg(),
            true,
            aTransientPlayer.getPlayer().getName(),
            aTransientPlayer.getPlayer().getRole()
            );
            aTransientPlayer.getPosX();
            aTransientPlayer.getPosY();
        }
    }
}
