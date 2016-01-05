package firstGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {

	// create int for the both rockets coordinates
    protected int x;
    protected int y;

    protected int width;
    protected int height;

    
    protected boolean vis;
    
    protected boolean hit;

    private Image image;

    public Sprite(int x, int y ){
        this.x = x;
        this.y = y;
        
        // to make sure the bullets are visible
        vis = true;
        
        // to check and see if the craft got hit or not
        hit = false;
    }

    //load images
    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
        
    }

    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
        
    }    
    
    // for first player
    public Image getImage() {
        return image;
    }
    
   
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX(int x){
    	this.x = x;
    }
    
    public void setY(int y){
    	this.y = y;
    }
    
    public boolean isVisible() {
        return vis;
    }
    
    public boolean getHit(){
    	return hit;
    }
    public void setVisible(boolean visible) {
        vis = visible;
    }
    
    public void setHit(boolean hited){
    	hit = hited;
    }

    public Rectangle getBounds(int a , int b) {
        return new Rectangle(x, y, width - a, height -b);
    }
    
}