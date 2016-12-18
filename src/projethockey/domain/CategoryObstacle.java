package projethockey.domain;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author Alexandre
 */
public class CategoryObstacle implements java.io.Serializable{
    private String catName;
    transient BufferedImage imgObstacle;
    private int scale;
    private Float horizontalSize;
    private Float verticalSize;
    private Boolean isGameObject;

    public CategoryObstacle(){
    }

    public CategoryObstacle(CategoryObstacle categoryObstacle) {
        this.catName = categoryObstacle.catName;
        this.scale = categoryObstacle.scale;
        this.horizontalSize = categoryObstacle.horizontalSize;
        this.verticalSize = categoryObstacle.verticalSize;
        this.isGameObject = categoryObstacle.isGameObject;
        this.imgObstacle = categoryObstacle.imgObstacle;
    }


    /*
            Get-Set
    */

    public String getCategoryName() {
        return this.catName;
    }

    public void setCategoryName(String catName) {
        this.catName = catName;
    }

    public void setHorizontalSize(Float pHorizontalSize) {
        this.horizontalSize = pHorizontalSize;
    }
    public float getHorizontalSize() {
        return this.horizontalSize;
    }

    public void setVerticalSize(Float pVerticalSize) {
        this.verticalSize = pVerticalSize;
    }

    public float getVerticalSize() {
        return this.verticalSize;
    }
    
    public void setIsGameObject(Boolean isGame) {
        this.isGameObject = isGame;
    }
    
    public BufferedImage getImg() {
        return this.imgObstacle;
    }
    
    public void setImg(BufferedImage obstacleImage) {
        this.imgObstacle = obstacleImage;
    }
    
    public Boolean getIsGameObject() {
        return this.isGameObject;
    }

    public void reset() {
        this.verticalSize = (float) 0;
        this.horizontalSize = (float) 0;
        this.catName = null;
        this.isGameObject = false;
        this.imgObstacle = null;
    }
    
    public boolean isValid() {
        if (this.imgObstacle == null){return false;}
        return true;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(imgObstacle, "png", out);
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        imgObstacle = ImageIO.read(in);
    }

}
