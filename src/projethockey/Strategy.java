package projethockey;

import java.util.List;
import java.util.Date;


/**
 *
 * @author Alexandre
 */
public class Strategy {
    //private var interfaceUser;
    private float playBackSpeed;
    private Date deltaTimeFrame;
    private String sportName;
    private List<Snapshot> listSnapshot;

    public Strategy() {
    }
    
    public Strategy(Strategy strategy) {
        this.playBackSpeed = strategy.playBackSpeed;
        this.deltaTimeFrame = strategy.deltaTimeFrame;
        this.sportName = strategy.sportName;
        this.listSnapshot = strategy.listSnapshot;
    }

    public Strategy(float playBackSpeed, Date deltaTimeFrame, String sportName, List<Snapshot> listSnapshot) {
        this.playBackSpeed = playBackSpeed;
        this.deltaTimeFrame = deltaTimeFrame;
        this.sportName = sportName;
        this.listSnapshot = listSnapshot;
    }

    public float getPlayBackSpeed() {
        return playBackSpeed;
    }

    public void setPlayBackSpeed(float playBackSpeed) {
        this.playBackSpeed = playBackSpeed;
    }

    public Date getDeltaTimeFrame() {
        return deltaTimeFrame;
    }

    public void setDeltaTimeFrame(Date deltaTimeFrame) {
        this.deltaTimeFrame = deltaTimeFrame;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public List<Snapshot> getListSnapshot() {
        return listSnapshot;
    }

    public void setListSnapshot(List<Snapshot> listSnapshot) {
        this.listSnapshot = listSnapshot;
    }
            
    /*
                Public methodes
    */
    
    public void getFrame() {
        throw new UnsupportedOperationException();
    }
    
    public void setFrame() {
        throw new UnsupportedOperationException();
    }
    
    public void trashFrame() {
        throw new UnsupportedOperationException();
    }
    
    public void cleanUp() {
        throw new UnsupportedOperationException();
    }
    
    public void getSnapShotAfterTime() {
        throw new UnsupportedOperationException();
    }
    
    public void getCurrentSnapshot() {
        throw new UnsupportedOperationException();
    }
    
    public Snapshot getOrCreate(Date time) {
        throw new UnsupportedOperationException();
    }
            
    
}
