package projethockey;

/**
 *
 * @author Alexandre
 */
public class CategoryObstacle {
    private String catName;
    private String imgPath;
    private Position positionDefault;
    private int scale;
    
    public CategoryObstacle(){
    }
    
    public CategoryObstacle(String catName, String imgPath, Position positionDefault, int scale) {
        this.catName = catName;
        this.imgPath = imgPath;
        this.positionDefault = positionDefault;
        this.scale = scale;
    }
    
    public CategoryObstacle(CategoryObstacle categoryObstacle) {
        this.catName = categoryObstacle.catName;
        this.imgPath = categoryObstacle.imgPath;
        this.positionDefault = categoryObstacle.positionDefault;
        this.scale = categoryObstacle.scale;
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
}
