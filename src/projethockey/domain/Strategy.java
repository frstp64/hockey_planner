package projethockey.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


/**
 *
 * @author Alexandre
 */
public class Strategy implements java.io.Serializable{
    //private var interfaceUser;
    private float playBackSpeed;
    private Date deltaTimeFrame;
    private List<Snapshot> listSnapshot;
    private String name;
    private Sport sport;
    private ArrayList<Team> listTeam;

    public Strategy() {
    }
    
    public Strategy(Strategy strategy) {
        this.playBackSpeed = strategy.playBackSpeed;
        this.deltaTimeFrame = strategy.deltaTimeFrame;
        this.listSnapshot = strategy.listSnapshot;
        this.name = strategy.name;
        this.sport = new Sport(strategy.sport);
        this.listTeam = strategy.listTeam;
    }

    public Strategy(float playBackSpeed, Date deltaTimeFrame, String sportName, List<Snapshot> listSnapshot, String name, Sport sport, ArrayList<Team> listTeam) {
        this.playBackSpeed = playBackSpeed;
        this.deltaTimeFrame = deltaTimeFrame;
        this.listSnapshot = listSnapshot;
        this.name = name;
        this.sport = sport;
        this.listTeam = listTeam;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return this.sport.getName();
    }

    public List<Snapshot> getListSnapshot() {
        return listSnapshot;
    }

    public void setListSnapshot(List<Snapshot> listSnapshot) {
        this.listSnapshot = listSnapshot;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public ArrayList<Team> getListTeam() {
        return listTeam;
    }

    public void setListTeam(ArrayList<Team> listTeam) {
        this.listTeam = listTeam;
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
    
    public Snapshot getCurrentSnapshot(int wantedTime) {
        for (Snapshot aSnapshot: this.listSnapshot) {
            if (aSnapshot.getTimeStamp() ==wantedTime) {
                return aSnapshot;
            }
        }
        return this.listSnapshot.get(0); // SHOULD NOT HAPPEN
    }
    
    public Snapshot getOrCreate(Date time) {
        throw new UnsupportedOperationException();
    }
            
    public boolean isStrategyValid() {
        return sport.isTeamListValid(listTeam);
    }

    public ArrayList<String> getTeamNames() {
        
        ArrayList<String> teamNames = new ArrayList();
        
        int index = 0;
        for(Team aTeam: this.listTeam){
            teamNames.add(aTeam.getName());
            index++;
        }
        return teamNames;
    }
    
    public boolean doesPlayerExist(String pPlayerName) {
        for (Team aTeam: this.listTeam) {
            if( aTeam.getPlayerNames().contains(pPlayerName)) {
                return true;
            }
        }
        return false;
    }
    
    public Player getPlayer(String pPlayerName) throws Exception {
        for (Team aTeam: this.listTeam) {
            if( aTeam.getPlayerNames().contains(pPlayerName)) {
                return aTeam.getPlayer(pPlayerName);
            }
        }
        throw new Exception("should have called doesPlayerExist before!");
    }
}