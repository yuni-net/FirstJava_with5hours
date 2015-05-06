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
public class Bucket {
    
    
    public void init(MainPanel mainPanel) {
        is_left = false;
        y = 480-158;
        
        image = Toolkit.getDefaultToolkit().getImage("bucket.png");
        
        MediaTracker tracker  = new MediaTracker(mainPanel);
        tracker.addImage(image, 0);
        
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
           
    }
    public void update() {
        int cx = 417-122;
        if(is_left==false)
        {
            cx += 245;
        }
        
        x = cx-122;

    }
    
    public void draw(Graphics g, MainPanel mainPanel) {
        g.drawImage(image, x, y, mainPanel);
    }
    
    
    public void keyPressed(int key) {
        if(key==KeyEvent.VK_LEFT) {
            is_left = true;
        }
        
        if(key==KeyEvent.VK_RIGHT) {
            is_left = false;
        }
    }
    
    boolean isLeft() {
        return is_left;
    }
   
    private boolean is_left;
    private int x;
    private int y;
    private Image image;
}
