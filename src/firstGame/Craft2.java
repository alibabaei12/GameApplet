package firstGame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Craft2 extends Sprite {
	// create 2 ints for the movement of the craft
	// horizantal
    private int dx;
    private int dy;
   
    // speed of the craft
    private final int SPEED = 5;
    
    // create an array to store the bullets in them
    private ArrayList missiles;
    
    
    // create a constructor to get the x and y axis of the craft from the sprite class 
    // also inisilize all the private variables
    public Craft2(int x, int y ) {
        super(x, y);
        
        initCraft();
    }
    private void initCraft() {

        missiles = new ArrayList();
      
        loadImage("cr2.png"); 
        getImageDimensions();
    }
    
    // the movement of the craft
    public void move() {
    	// dx dy dw dz are the speed
    	x += dx; 
    	y += dy;
       
    }
    
    // return the missile objects
    public ArrayList getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        // if kilck the fire botton it fires
        
        if(key == KeyEvent.VK_SLASH){
        	fire();
        }
        
        // movements
        if (key == KeyEvent.VK_LEFT) { 
        	if(x <= 1250){ // dont go behind 1250
        		dx = 0;
        	}
        	else{
        		dx = -SPEED;
        	}
          }
        
        if (key == KeyEvent.VK_RIGHT) {
            if( x>= 1400)
            	dx = 0;
            else
        	dx = SPEED;
        }

        if (key == KeyEvent.VK_UP) {
        	if(y<= 30)
        		dy = 0 ;
        	else
            dy = -SPEED;
        }

        if (key == KeyEvent.VK_DOWN) {
        	if(y>= 780)
        		dy= 0;
        	else
            dy = SPEED;
        }
        
    }
    //where the missiles are placed
    public void fire() {
        missiles.add(new Missile(x + 100 , y+50 ));   
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        //dont move if the user let go of the botton
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}