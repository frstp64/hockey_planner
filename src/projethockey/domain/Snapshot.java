package projethockey.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class Snapshot implements java.io.Serializable {
    private int idChange;
    private ArrayList<TransientPlayer> listTransientPlayer;
    private boolean trashed;
    private int timeStamp;
    private String typeSnapshot;

    public Snapshot(int timeStamp) {
        this.timeStamp = timeStamp;
        this.trashed = false;
        this.typeSnapshot = "TODOLATER";
        this.listTransientPlayer = new ArrayList();
        this.idChange = -1;
    }

     public Snapshot(Snapshot snapshot) {
        
        this.idChange = snapshot.idChange;
        this.listTransientPlayer = new ArrayList();
        for(TransientPlayer trans : snapshot.listTransientPlayer) {
            //System.out.println("I'm a player and my name is "+ trans.getPlayer().getName());
            this.listTransientPlayer.add(new TransientPlayer(trans));
        }
        for(TransientPlayer trans: this.listTransientPlayer) {
            //System.out.println("I'm a player and my name is "+ trans.getPlayer().getName());

        }
        //this.listObstacle = snapshot.listObstacle;
        this.trashed = snapshot.trashed;
        this.timeStamp = snapshot.timeStamp;
        this.typeSnapshot = snapshot.typeSnapshot;   
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
            //System.out.println("now printing " + aTransientPlayer.getPlayer().getName() + " at x=" + aTransientPlayer.getPosX() + " and y="+ aTransientPlayer.getPosY());
            sceneReference.putPlayer(
            aTransientPlayer.getPosX(),
            aTransientPlayer.getPosY(),
            aTransientPlayer.getPlayer().getCategoryPlayer().getImg(),
            aTransientPlayer.getPlayer().getName(),
            !aTransientPlayer.isVisible(),
            aTransientPlayer.getAngle()
                    
            );
        }
    }
    
    public TransientPlayer getTransientPlayer(String pPlayerName) throws Exception {
        for (TransientPlayer aTransientPlayer: this.listTransientPlayer) {
            if (aTransientPlayer.getPlayer().getName().equals(pPlayerName)) {
                return aTransientPlayer;
            }
        }
        System.out.println("player name: " + pPlayerName);
        throw new Exception("non-existent transient player: requested " + pPlayerName);
    }
    
    // also deals with the visibility, makes it false
    public void copyFromOtherSnapshot(Snapshot pSnapshot) {
        for (TransientPlayer aTransientPlayer: pSnapshot.listTransientPlayer) {
            TransientPlayer newTransientPlayer = new TransientPlayer(aTransientPlayer);
            //newTransientPlayer.setVisible(false);
            this.listTransientPlayer.add(newTransientPlayer);
        }
            
    }
    
    public void opacify() {
        for (TransientPlayer aTransientPlayer: this.listTransientPlayer) {
            aTransientPlayer.setVisible(false);
        }
    }
}
