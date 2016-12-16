package projethockey.domain;

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
    private String imgPath;
    private int scale;
    private Float horizontalSize;
    private Float verticalSize;
    private Boolean isGameObject;

    public CategoryObstacle(){
    }

    public CategoryObstacle(CategoryObstacle categoryObstacle) {
        this.catName = categoryObstacle.catName;
        this.imgPath = categoryObstacle.imgPath;
        this.scale = categoryObstacle.scale;
        this.horizontalSize = categoryObstacle.horizontalSize;
        this.verticalSize = categoryObstacle.verticalSize;
        this.isGameObject = categoryObstacle.isGameObject;
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

    public String getImgPath() {
        return this.imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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
    
    public Boolean getIsGameObject() {
        return this.isGameObject;
    }

    public void reset() {
        this.verticalSize = (float) 0;
        this.horizontalSize = (float) 0;
        this.catName = "";
        this.imgPath = "";
        this.isGameObject = false;
    }

}
