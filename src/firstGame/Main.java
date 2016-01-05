package firstGame;

import java.awt.EventQueue;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Main extends JFrame {

    public Main() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        setSize(1600, 1000);
        setResizable(false);
        
        setTitle("Duol");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Main ex = new Main();
                ex.setVisible(true);
            }
        });
        
    }
}