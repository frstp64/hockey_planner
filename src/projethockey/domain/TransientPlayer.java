package projethockey.domain;

public class TransientPlayer implements java.io.Serializable {
    private float posX;
    private float posY;
    private float rotationRadians;
    private Player player;
    private boolean visible;
    private TransientObject gameObj;
    
    public TransientPlayer(float posX, float posY, float pAngle, Player player, boolean visible) {
        this.posX = posX;
        this.posY = posY;
        this.player = new Player(player);
        this.visible = visible;
        this.rotationRadians = pAngle;
    }
    
    public TransientPlayer(TransientPlayer transientPlayer) {
        this.posX = transientPlayer.posX;
        this.posY = transientPlayer.posY;
        this.player = transientPlayer.player;
        this.visible = transientPlayer.visible;
        this.rotationRadians = transientPlayer.rotationRadians;
        this.gameObj = new TransientObject(transientPlayer.gameObj);
    }


    public float getPosX() {
        return posX;
    }
    
    public float getPosY() {
        return posY;
    }


    public void setPosition(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public void setAngle(float pAngle) {
        this.rotationRadians = pAngle;
    }
    
    public float getAngle() {
        return this.rotationRadians;
    }
    
//    public void setGameObj(TransientObject aTransientObject) {
//        this.gameObj = aTransientObject;
//    }
//    
//    public boolean hasAGameObj() {
//        return this.gameObj == null;
//    }
//    public TransientObject getGameObj() {
//        return this.gameObj;
//    }
}