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
    private Snapshot obstaclePlane;
    
    private String name;
    private Sport sport;
    private ArrayList<Team> listTeam;

    public Strategy() {
        listSnapshot = new ArrayList();
        listTeam = new ArrayList();
        this.obstaclePlane = new Snapshot(0);
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
        this.obstaclePlane = new Snapshot(strategy.obstaclePlane);
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

    // Pulls a snapshot copy right at or before a given time
    // REQUIREMENT: listSnapshot is sorted by time, the must be at least one snapshot
    public Snapshot pullSnapshot(long wantedTime) {
        
        if (this.listSnapshot.size() == 0) {
            return new Snapshot(0);
        } else if (this.getBiggestTime() < wantedTime) {
            Snapshot aSnapshot = new Snapshot(this.listSnapshot.get(this.listSnapshot.size()-1));
            aSnapshot.setTimeStamp(wantedTime);
            return aSnapshot;
        }
        
        for (int index = 0; index < this.listSnapshot.size(); index++) {
            
            if (this.listSnapshot.get(index).getTimeStamp() > wantedTime) {
                // we return the last snapshot before trespassing
                
                Snapshot snapshotToReturn = new Snapshot(this.listSnapshot.get(index-1));
                snapshotToReturn.setTimeStamp(wantedTime);
                return snapshotToReturn;
            } else if (this.listSnapshot.get(index).getTimeStamp() == wantedTime) {
                Snapshot snapshotToReturn = new Snapshot(this.listSnapshot.get(index));
                snapshotToReturn.setTimeStamp(wantedTime);
                return snapshotToReturn;
            }
        }
        
        // should never happen
        return new Snapshot(0);
    }
    
    // Pulls a snapshot copy containing every item in the background, set as semi-visible items
    // Deals with the snapshots up to, but not including, wantedTime
    public Snapshot pullSnapshotBG(long wantedTime) {
        Snapshot snapshotToReturn = new Snapshot(wantedTime);
        for (int index = 0; index < this.listSnapshot.size(); index++) {
            // we're done
            if (this.listSnapshot.get(index).getTimeStamp() >= wantedTime) {
                break;
            }
            else {
                //We copy the info of the current frame to the frame to send
                snapshotToReturn.copyFromOtherSnapshot(this.listSnapshot.get(index));
            }
        }
        return snapshotToReturn;
    }
    
    // use with preview only!!!!!!
    public Snapshot pullStarterSnapshot() {
        Snapshot snapshotToReturn = new Snapshot(0);
        
        ArrayList<String> addedPlayers = new ArrayList();
        
        for (int index = 0; index < this.listSnapshot.size(); index++) {
            Snapshot currentSnapshot = this.listSnapshot.get(index);
            for(TransientPlayer aTransientPlayer: currentSnapshot.getListTransientPlayer()) {
                boolean containsIt = false;
                String theName = aTransientPlayer.getPlayer().getIdentity();
                if (!addedPlayers.contains(theName)) {
                    // a new player!
                    snapshotToReturn.tryAddPlayer(aTransientPlayer.getPlayer(), aTransientPlayer.getPosX(), aTransientPlayer.getPosY(), aTransientPlayer.getAngle());
                    addedPlayers.add(theName);
                }
            }
        }
        
        
        return snapshotToReturn;
    }
    
    // Inserts a snapshot at the requested time
    public void insertSnapshot(Snapshot pSnapshot) {
        boolean inserted = false;
        for (int index = 0; index < this.listSnapshot.size(); index++) {
            // we're done
            if(this.listSnapshot.get(index).getTimeStamp()  == pSnapshot.getTimeStamp()) {
                // This is the situation where they are both at the same time, that means we need to replace it
                this.listSnapshot.remove(index);
                this.listSnapshot.add(index, new Snapshot(pSnapshot));
                inserted = true;
                break;
            } else if (this.listSnapshot.get(index).getTimeStamp() > pSnapshot.getTimeStamp()) {
                // This is the situation where the new snapshot fits inbetween 2 old snapshots
                // in this case we insert it at the right location
                this.listSnapshot.add(index, new Snapshot(pSnapshot));
                inserted = true;
                break;
            }
        }
        
        if (!inserted) {
            // We are at the end and there's no fitting position before,
            // this means we need to insert the snapshot at the end
            this.listSnapshot.add(new Snapshot(pSnapshot));
        }
        
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
    
    public long getBiggestTime() {
        long maxTime = 0;
        for (Snapshot aSnapshot: this.listSnapshot) {
            if (aSnapshot.getTimeStamp() > maxTime) {
                maxTime = aSnapshot.getTimeStamp();
            }
        }
        return maxTime;
    }
    
    public void removeTeamByNumber(int teamNumberToRemove) {
        for (int i = teamNumberToRemove; i>0; i--) {
            this.listTeam.remove(this.listTeam.size()-1);
        }
    }
    
    // Completes the frames so there isn't any frame where a player "disappears"
    public void completeFrames() {
        //TODO
        Snapshot starterSnapshot = this.pullStarterSnapshot();
        for(TransientPlayer aTransientPlayer : starterSnapshot.getListTransientPlayer()) {
            Float playerLastX = null;
            Float playerLastY = null;
            Float playerLastAngle = null;
            for (Snapshot aSnapshot : this.listSnapshot) {
                try {
                    TransientPlayer tmpTransientPlayer = aSnapshot.getTransientPlayer(aTransientPlayer.getPlayer().getIdentity());
                    // it exists, we record it's position
                    playerLastX = tmpTransientPlayer.getPosX();
                    playerLastY = tmpTransientPlayer.getPosY();
                    playerLastAngle = tmpTransientPlayer.getAngle();
                } catch (Exception e) {
                    // This means the player does not exist
                    // If it has been seen before, we add it
                    if (playerLastX != null) {
                    aSnapshot.tryAddPlayer(aTransientPlayer.getPlayer(), playerLastX, playerLastY, playerLastAngle);
                    }
                }
            }
        }
        
    }
    
    public void printPlayerLines(BlackBoard pScene) {
        Snapshot starterSnapshot = this.pullStarterSnapshot(); // used to find all the players
        // we iterate over all the players, to find all of their positions, and then we draw the lines
        for(TransientPlayer aTransientPlayer : starterSnapshot.getListTransientPlayer()) {
            ArrayList<Float> thePlayerPosXList = new ArrayList();
            ArrayList<Float> thePlayerPosYList = new ArrayList();
            for (Snapshot aSnapshot : this.listSnapshot) {
                try {
                    TransientPlayer tmpTransientPlayer = aSnapshot.getTransientPlayer(aTransientPlayer.getPlayer().getIdentity());
                    thePlayerPosXList.add(tmpTransientPlayer.getPosX());
                    thePlayerPosYList.add(tmpTransientPlayer.getPosY());
                } catch (Exception e) {
                    // we do nothing, the player just doesn't exist in that particular frame
                }
            }
            
            // now we draw the lines
            for (int i = 0; i<thePlayerPosXList.size()-1; i++) {
                pScene.drawLine(thePlayerPosXList.get(i), thePlayerPosYList.get(i), thePlayerPosXList.get(i+1), thePlayerPosYList.get(i+1));
            }
        }
        
    }
    
    public void eraseObstacle(int pObstacleUID) {
        this.obstaclePlane.removeObject(pObstacleUID);
    }
    
    public void erasePlayerAll(String pPlayerIdentity) {
        // Erases the player from all the snapshots
        erasePlayerFromFuture(pPlayerIdentity, -1);
    }
    
    public void eraseGameObject(int pObjectUID) {
        for (Snapshot aSnapshot : this.listSnapshot) {
            List<TransientObject> transientObjectList = aSnapshot.getListTransientObject();
            for (int anObjIndex = 0; anObjIndex < transientObjectList.size(); anObjIndex++) {
                TransientObject aTransientObject = transientObjectList.get(anObjIndex);
                if (aTransientObject.getUID() == pObjectUID) {
                    transientObjectList.remove(anObjIndex);
                    break;
                }
            }
        }

    }
    
    public void erasePlayerFromFuture(String pPlayerIdentity, long timeToStartErasing) {
        //Erases the player from a point in time until the end
        for (Snapshot aSnapshot : this.listSnapshot) {
            if(aSnapshot.getTimeStamp() >= timeToStartErasing) {
                List<TransientPlayer> transientPlayerList = aSnapshot.getListTransientPlayer();
                for (int aPlayerIndex = 0; aPlayerIndex < transientPlayerList.size(); aPlayerIndex++) {
                    TransientPlayer aTransientPlayer = transientPlayerList.get(aPlayerIndex);
                    if (aTransientPlayer.getPlayer().getIdentity().equals(pPlayerIdentity)) {
                        transientPlayerList.remove(aPlayerIndex);
                        break;
                    }
                }
            }
        }
    }
    
    public void addNewObject(CategoryObstacle currentObject, long currentTime, float pPosX, float pPosY) {
        // adds a new object according to its type
        if (!currentObject.getIsGameObject()) {
            // It is an obstacle, it should be stored in the obstacle plane because it won't move
            // first, we instantiate a transient object
            TransientObject obstacleToAdd = new TransientObject(pPosX, pPosY, currentObject, true);
            // then, we add it to the obstacle plane. it's all automatic!
        this.obstaclePlane.addObject(obstacleToAdd);
        } else {
            // It is a game object, it should be stored in a normal frame because it is supposed to be here
            TransientObject gameObjectToAdd = new TransientObject(pPosX, pPosY, currentObject, true);
            Snapshot aSnapshot = this.pullSnapshot(currentTime);
            aSnapshot.addObject(gameObjectToAdd);
            this.insertSnapshot(aSnapshot);
        }
    }

    public Snapshot getObstaclePlane() {
        return this.obstaclePlane;
    }

    boolean isAnObstacle(int intersectingObjectUID) {
        for(TransientObject aTransientObject : this.obstaclePlane.getListTransientObject()) {
            if (aTransientObject.getUID() == intersectingObjectUID) {
                return true;
            }
        }
        return false;
    }
}