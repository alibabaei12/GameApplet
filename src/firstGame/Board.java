package firstGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.audio.*;
public class Board extends JPanel implements ActionListener {

    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 100;
    
    private final int ICRAFT_W = 1360;
    private final int ICRAFT_Z = 100;
    
    private final int DELAY = 10;
    private Timer timer;
    private Craft craft;
    private Craft2 craft2;
    private Thread thread;
    
    public Board() {

        initBoard();
    }

    private void initBoard() {
    	// creating the background
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        craft = new Craft(ICRAFT_X, ICRAFT_Y );
        craft2 = new Craft2(ICRAFT_W,ICRAFT_Z);
        timer = new Timer(DELAY, this);
        timer.start();
        
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        // create the background image
        ImageIcon ii = new ImageIcon("spaceBackground.png");
        Image image = ii.getImage();
        
        // create the collision image
        ImageIcon ii2 = new ImageIcon("ex1.png");
        Image img = ii2.getImage();
        
        ImageIcon ii3 = new ImageIcon("ex2.png");
        Image img2 = ii3.getImage();
        //create the rockets
        g2d.drawImage(image, 0, 0, null);
        
        // FRIST rocket
        // make sure if the craft is hit or not
        if(craft2.getHit() == false)
        {
        	g2d.drawImage(craft.getImage(), craft.getX(),  craft.getY(), this);
        }
        
        if(craft2.getHit()== true){
        g2d.drawImage(img, craft.getX() ,craft.getY() , this);
           timer.stop();
        }
               	  
        // SECOND rocket
        if(craft.getHit()== false)
        {
            g2d.drawImage(craft2.getImage(), craft2.getX(),craft2.getY(), this);
        }
        if(craft.getHit() == true)
        {
        	g2d.drawImage(img2,craft2.getX(),craft2.getY(), this);
        	timer.stop();
        }
                
        ArrayList ms = craft.getMissiles();
        ArrayList ms2 = craft2.getMissiles();
        
        Rectangle r1 = craft.getBounds(0 , 0);
        Rectangle r2 = craft2.getBounds(20,40);
        
        
        for (Object m1 : ms) {
        	
            Missile m = (Missile) m1;
            Rectangle mm1 = m.getmm();
            g2d.drawImage(m.getImage(), m.getX() +100,
                    m.getY()+50, this);
            
            if(r2.intersects(mm1))
            {
            	m.setVisible(false);
            	craft.setHit(true);
            }
        }
        
        
        for (Object m1 : ms2) {
            Missile m = (Missile) m1;
            Rectangle mm2 = m.getmm();
            g2d.drawImage(m.getImage(), m.getX(),
                    m.getY(), this);
            
            if(r1.intersects(mm2))
            {
            	m.setVisible(false);
            	craft2.setHit(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
        updateMissiles();
        updateMissiles2();
        updateCraft();
        updateCraft2();
        repaint();
        
    }

    private void updateMissiles() {
    	
        ArrayList ms = craft.getMissiles();
      
        for (int i = 0; i < ms.size(); i++) {

            Missile m = (Missile) ms.get(i);
           
            if (m.isVisible()) {
        
                m.move();
                
            } else {
                ms.remove(i);
            }
        }
    }
    
    private void updateMissiles2() {
        
        ArrayList ms2 = craft2.getMissiles();

        for (int i = 0; i < ms2.size(); i++) {
        	
            Missile m = (Missile) ms2.get(i);  
            
            if (m.isVisible()) {            	
                m.move2();  
                } 
            else {
                ms2.remove(i);
            }
        }
    }
    
    private void updateCraft() {
    	
        craft.move();
        
    }
    private void updateCraft2(){
    	craft2.move();
    }

    public void music(){
    	
    	  try {
    	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("bgm.wav").getAbsoluteFile());
    	        Clip clip = AudioSystem.getClip();
    	        clip.open(audioInputStream);
    	        clip.start();
    	    } catch(Exception ex) {
    	        System.out.println("Error with playing sound.");
    	        ex.printStackTrace();
    	    }
    }
    
    public void menue(Graphics g){
    	Graphics2D g2d = (Graphics2D) g;
    	setBackground(Color.black);
    	
    	
    }
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
            craft2.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
            craft2.keyPressed(e);
        }
    }
}