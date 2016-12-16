package projethockey.domain;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class CategoryPlayer implements java.io.Serializable{
    private String catName;
    //make buffered image serializable
    transient BufferedImage imgPlayer;
    
    public CategoryPlayer() {
        this.catName = null;
        this.imgPlayer = null;
    }
    
    public CategoryPlayer(CategoryPlayer categoryPlayer) {
        this.catName = categoryPlayer.catName;
        this.imgPlayer = categoryPlayer.imgPlayer;
    }
    
    public String getCategoryName() {
        return this.catName;
    }
    
    public void setCategoryName(String catName) {
        this.catName = catName;
    }
    
    public BufferedImage getImg() {
        return this.imgPlayer;
    }
    
    public void setImg(BufferedImage playerImage) {
        this.imgPlayer = playerImage;
    }
    
    public void reset() {
        this.catName = null;
        this.imgPlayer = null;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(imgPlayer, "png", out);
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        imgPlayer = ImageIO.read(in);
    }
    
    public boolean isValid() {
      if (this.getCategoryName() != null && !this.getCategoryName().isEmpty() && !(this.imgPlayer == null)) {
          System.out.println(this.imgPlayer);
          return true;
      }
      else {
          return false;
      }

    }
            
}
