package projethockey.domain;

/**
 *
 * @author Alexandre
 */
public class CategoryObstacle {
    private String catName;
    private String imgPath;
    private int scale;
    private Position positionDefault;
    private Float horizontalSize;
    private Float verticalSize;

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
        this.horizontalSize = categoryObstacle.horizontalSize;
        this.verticalSize = categoryObstacle.verticalSize;
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
