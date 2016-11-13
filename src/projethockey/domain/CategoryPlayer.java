package projethockey.domain;

/**
 *
 * @author Alexandre
 */
public class CategoryPlayer {
    private String catName;
    private String imgPath;
    private int scale;
    private Position positionDefault;
    
    public CategoryPlayer(){
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
