package firstGame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Craft extends Sprite {
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
    public Craft(int x, int y ) {
        super(x, y);
        
        initCraft();
    }
    private void initCraft() {

        missiles = new ArrayList();
      
        loadImage("cr1.png"); 
        
        getImageDimensions();
    }
    
    // the movement of the craft
    public void move() {
    	// dx dyaare the speed
    	x += dx; 
    	y += dy;
       
    }
    
    // return the missile objects
    public ArrayList getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        // if click the fire botton it fires
        
        if(key == KeyEvent.VK_SPACE){
        	fire();
        }
        
        // movements
        if (key == KeyEvent.VK_D) { 
        	if(x >= 50){ // dont go behind 1250
        		dx = 0;
        	}
        	else{
        		dx = SPEED;
        	}          
        }

        if (key == KeyEvent.VK_A) {
            if(x<= 10)
            	dx = 0;
            else
        	dx = -SPEED;
        }

        if (key == KeyEvent.VK_W) {
        	if(y<=10)
        		dy = 0;
        	else
            dy = -SPEED;
        }

        if (key == KeyEvent.VK_S) {
        	if(y >= 800)
        		dy = 0;
        	else
            dy = SPEED;
        }
        
    }
    //where the missiles are placed
    public void fire() {
        missiles.add(new Missile(x, y));   
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        //dont move if the user let go of the botton
        if (key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
}