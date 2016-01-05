package firstGame;

import java.awt.Rectangle;

public class Missile extends Sprite {
	
	// the missiles final distinetion in x axsis
    private final int BOARD_WIDTH = 1600;
    private final int BOARD_WIDTH2 = 0;
    
    // speed of the missiles
    private final int MISSILE_SPEED = 10;
    
    public Missile(int x, int y ) {
        super(x, y);
        initMissile();
      
    }
    
    private void initMissile() {
        
        loadImage("fire.png");  
     
        getImageDimensions();
      
    }

  
    public void move() {
        
        x += MISSILE_SPEED;
        ;
        if (x > BOARD_WIDTH ) {
            vis = false;
        }
    }
    
    public void move2(){
    	x -= MISSILE_SPEED;
    	
        if (x < BOARD_WIDTH2 ) {
            vis = false;
        }      
    }
    
    public Rectangle getmm() {
        return new Rectangle(x, y, width, height);
    }
}