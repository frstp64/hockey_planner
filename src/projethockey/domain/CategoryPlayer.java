package projethockey.domain;
import java.awt.image.BufferedImage;
/**
 *
 * @author Alexandre
 */
public class CategoryPlayer implements java.io.Serializable{
    public BufferedImage imgPlayer;
    private String catName;
    private String imgPath;
    private int scale;
    private Position positionDefault;
    private Float horizontalSize;
    private Float verticalSize;
    
    public CategoryPlayer() {
    }
    
    public CategoryPlayer(String catName, String imgPath, Position positionDefault, int scale) {
        this.catName = catName;
        this.imgPath = imgPath;
        this.positionDefault = positionDefault;
        this.scale = scale;
    }
    
    public CategoryPlayer(CategoryPlayer categoryPlayer) {
        this.catName = categoryPlayer.catName;
        this.imgPath = categoryPlayer.imgPath;
        this.positionDefault = categoryPlayer.positionDefault;
        this.scale = categoryPlayer.scale;
        this.horizontalSize = categoryPlayer.horizontalSize;
        this.verticalSize = categoryPlayer.verticalSize;
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
    
    public Position getPositionDefault() {
        return this.positionDefault;
    }
    
    public void setPositionDefault(Position positionDefault) {
        this.positionDefault = positionDefault;
    }
    
    public int getScale() {
        return this.scale;
    }    
            
    public void setScale(int scale) {
       this.scale = scale;
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
    
    public void reset() {
        this.verticalSize = (float) 0;
        this.horizontalSize = (float) 0;
        this.catName = "";
        this.imgPath = "";
    }
}
