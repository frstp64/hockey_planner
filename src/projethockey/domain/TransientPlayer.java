package projethockey.domain;

public class TransientPlayer implements java.io.Serializable {
    private float posX;
    private float posY;
    private Player player;
    private boolean visible;
    
    public TransientPlayer(float posX, float posY, float pAngle, Player player, boolean visible) {
        this.posX = posX;
        this.posY = posY;
        this.player = new Player(player);
        this.visible = visible;
    }
    
    public TransientPlayer(TransientPlayer transientPlayer) {
        //System.out.println("copied a player: " + transientPlayer.getPlayer().getName());
        this.posX = transientPlayer.posX;
        this.posY = transientPlayer.posY;
        this.player = new Player(transientPlayer.player);
        this.visible = transientPlayer.visible;
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
}