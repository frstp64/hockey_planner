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
    private ArrayList<Snapshot> listSnapshot;
    private String name;
    private Sport sport;
    private ArrayList<Team> listTeam;

    public Strategy() {
        listSnapshot = new ArrayList();
        listTeam = new ArrayList();
    }
    
    public Strategy(Strategy strategy) {
        this.playBackSpeed = strategy.playBackSpeed;
        this.deltaTimeFrame = strategy.deltaTimeFrame;
        this.listSnapshot = new ArrayList();
        for (Snapshot aSnapshot: strategy.listSnapshot) {
            this.listSnapshot.add(new Snapshot(aSnapshot));
        }
        this.name = strategy.name;
        this.sport = strategy.sport;
        this.listTeam = new ArrayList();
        for (Team aTeam: strategy.listTeam) {
            this.listTeam.add(new Team(aTeam));
        }
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSportName() {
        return this.sport.getName();
    }

    public List<Snapshot> getListSnapshot() {
        return listSnapshot;
    }

    public void setListSnapshot(ArrayList<Snapshot> listSnapshot) {
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
    
    public Snapshot getCurrentSnapshot(int wantedTime) {
        for (Snapshot aSnapshot: this.listSnapshot) {
            if (aSnapshot.getTimeStamp() ==wantedTime) {
                return aSnapshot;
            }
        }
        if (this.listSnapshot.size()!= 0) {
            return getLastSnapshotBefore(wantedTime); // SHOULD NOT HAPPEN
        } else {
            return getOrCreate(wantedTime);
        }
        
    }
        public Snapshot getLastSnapshotBefore(int wantedTime) {
            int maxTimeBefore = 0;
        for (Snapshot aSnapshot: this.listSnapshot) {
            if (aSnapshot.getTimeStamp() < wantedTime && aSnapshot.getTimeStamp() > maxTimeBefore) {
                maxTimeBefore = aSnapshot.getTimeStamp();
            }
        }
        return this.getCurrentSnapshot(maxTimeBefore); // SHOULD NOT HAPPEN
    }
    
    public Snapshot getOrCreate(int time) {
        for (Snapshot aSnapshot: this.listSnapshot) {
            if (aSnapshot.getTimeStamp() == time) {
                return aSnapshot;
            }
        }
        
        Snapshot newSnapshot = new Snapshot(time);
        this.listSnapshot.add(newSnapshot);
        return newSnapshot;
    }
            
    public boolean isStrategyValid() {
        if (this.name != null && !this.name.isEmpty() && sport.isTeamListValid(listTeam)) {
            return true;
        }
        else {
            return false;
        }
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
        System.out.println(pPlayerName);
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
    
    public int getBiggestTime() {
        int maxTime = 0;
        for (Snapshot aSnapshot: this.listSnapshot) {
            if (aSnapshot.getTimeStamp() > maxTime) {
                maxTime = aSnapshot.getTimeStamp();
            }
        }
        return maxTime;
    }
    
    public boolean frameExistsAtTime(int pTime) {
        
        boolean doesExist = false;
        for (Snapshot aSnapshot: this.listSnapshot) {
            if (aSnapshot.getTimeStamp() == pTime) {
                doesExist = true;
            }
        }
        return doesExist;
    }
    public void removeTeamByNumber(int teamNumberToRemove) {
        for (int i = teamNumberToRemove; i>0; i--) {
            this.listTeam.remove(this.listTeam.size()-1);
        }
    }
}