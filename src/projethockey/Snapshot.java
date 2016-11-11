package projethockey;

import java.util.List;
import java.util.Date;

/**
 *
 * @author Alexandre
 */
public class Snapshot {
    private int idChange;
    private List<Player> listPlayer;
    private List<Obstacle> listObstacle;
    private boolean trashed;
    private Date timeStamp;
    private String typeSnapshot;

    public Snapshot() {
    }

    public Snapshot(Snapshot snapshot) {
        this.idChange = snapshot.idChange;
        this.listPlayer = snapshot.listPlayer;
        this.listObstacle = snapshot.listObstacle;
        this.trashed = snapshot.trashed;
        this.timeStamp = snapshot.timeStamp;
        this.typeSnapshot = snapshot.typeSnapshot;        
    }
    
    public Snapshot(int idChange, List<Player> listPlayer, List<Obstacle> listObstacle, boolean trashed, Date timeStamp, String typeSnapshot) {
        this.idChange = idChange;
        this.listPlayer = listPlayer;
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

    public List<Player> getListPlayer() {
        return listPlayer;
    }

    public void setListPlayer(List<Player> listPlayer) {
        this.listPlayer = listPlayer;
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
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
}
