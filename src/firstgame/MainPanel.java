/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author yuni-net
 */
public class MainPanel extends JPanel implements Runnable, KeyListener {
    
    public MainPanel() {
        setPreferredSize(new Dimension(width, height));
        
    }
    
    public void init() {
        bucket = new Bucket();
        bucket.init(this);
        
        apple = new Apple();
        apple.init(this);
        
        setFocusable(true);
        addKeyListener(this);

        thread = new Thread(this);
        thread.start();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        bucket.draw(g, this);
        apple.draw(g, this);
    }
    
    public void run() {
        while(true)
        {
            bucket.update();
            apple.update(bucket.isLeft());
            
            repaint();
            
            try {
                Thread.sleep(33);   // 30fps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void keyTyped(KeyEvent e) {
        // todo
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        bucket.keyPressed(key);
    }
    
    public void keyReleased(KeyEvent e) {
        // todo
    }
    
    private static final int width = 835;
    private static final int height = 480;
    
    private Thread thread;
    
    private Bucket bucket;
    private Apple apple;
   
}
