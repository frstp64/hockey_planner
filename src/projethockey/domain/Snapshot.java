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
    private ArrayList<TransientObject> listTransientObject;
    private boolean trashed;
    private long timeStamp;
    private String typeSnapshot;

    public Snapshot(long timeStamp) {
        this.timeStamp = timeStamp;
        this.trashed = false;
        this.typeSnapshot = "TODOLATER";
        this.listTransientPlayer = new ArrayList();
        this.listTransientObject = new ArrayList();
        this.idChange = -1;
    }

     public Snapshot(Snapshot snapshot) {
        
        this.idChange = snapshot.idChange;
        this.listTransientPlayer = new ArrayList();
        for(TransientPlayer trans : snapshot.listTransientPlayer) {
            this.listTransientPlayer.add(new TransientPlayer(trans));
        }
        for(TransientPlayer trans: this.listTransientPlayer) {

        }
        this.listTransientObject = new ArrayList();
        for(TransientObject trans : snapshot.listTransientObject) {
            this.listTransientObject.add(new TransientObject(trans));
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

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
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
    
    // Deals with dubloons, will just override it
    public void tryAddPlayer(Player pPlayer, float posX, float posY, float pAngle) {
        
        TransientPlayer transientPlayer;
        boolean playerAlreadyExists = false;
        for (TransientPlayer anExistingTransientPlayer: this.listTransientPlayer) {
            if (anExistingTransientPlayer.getPlayer().getIdentity().equals(pPlayer.getIdentity())) {
                playerAlreadyExists = true;
                anExistingTransientPlayer.setPosition(posX, posY);
                anExistingTransientPlayer.setAngle(pAngle);
                break;
            }
        }
        if (!playerAlreadyExists) {
            transientPlayer = new TransientPlayer(posX, posY, pAngle, pPlayer, true);
            this.listTransientPlayer.add(transientPlayer);
        }
    }
    // Deals with dubloons, will just override it
    public void tryAddObject(TransientObject pObj, float posX, float posY) {
        
        TransientObject transientObject;
        boolean objAlreadyExists = false;
        for (TransientObject anExistingTransientObject: this.listTransientObject) {
            if (anExistingTransientObject.getUID() == pObj.getUID()) {
                objAlreadyExists = true;
                anExistingTransientObject.setPosition(posX, posY);
                break;
            }
        }
        if (!objAlreadyExists) {
            transientObject = new TransientObject(pObj);
            transientObject.setPosition(posX, posY);
            this.listTransientObject.add(transientObject);
        }
    }
    
    public void addObject(TransientObject pObject) {
        this.listTransientObject.add(pObject);
    }
    
    public void printPlayers(Scene sceneReference) {
        for (TransientPlayer aTransientPlayer: this.listTransientPlayer) {
            sceneReference.putPlayer(
            aTransientPlayer.getPosX(),
            aTransientPlayer.getPosY(),
            aTransientPlayer.getPlayer().getCategoryPlayer().getImg(),
            aTransientPlayer.getPlayer().getIdentity(),
            !aTransientPlayer.isVisible(),
            aTransientPlayer.getAngle()
                    
            );
        }
    }
    
    public void printObjects(Scene sceneReference) {
        for (TransientObject aTransientObject: this.listTransientObject) {
            sceneReference.putObject(aTransientObject);
        }
    }
    
    public TransientPlayer getTransientPlayer(String pPlayerIdentity) throws Exception {
        for (TransientPlayer aTransientPlayer: this.listTransientPlayer) {
            if (aTransientPlayer.getPlayer().getIdentity().equals(pPlayerIdentity)) {
                return aTransientPlayer;
            }
        }
        System.out.println("player identity: " + pPlayerIdentity);
        throw new Exception("non-existent transient player: requested " + pPlayerIdentity);
    }
    
    public TransientObject getTransientObject(int pUID) throws Exception {
        for (TransientObject aTransientObject: this.listTransientObject) {
            if (aTransientObject.getUID() == pUID ) {
                return aTransientObject;
            }
        }
        throw new Exception("non-existent transient object");
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

    void removeObject(int pObstacleUID) {
        for(int i = 0; i < this.listTransientObject.size(); i++) {
            if (this.listTransientObject.get(i).getUID() == pObstacleUID) {
                this.listTransientObject.remove(i);
                break;
            }
        }
    }

    List<TransientObject> getListTransientObject() {
        return this.listTransientObject;
    }

}
