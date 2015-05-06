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
public class Apple {
    public void init(MainPanel mainPanel) {
        alive = true;
        succeeded = false;
        
        x = 417-122-54;
        y = -138;
        
        image = Toolkit.getDefaultToolkit().getImage("apple.png");
        
        MediaTracker tracker  = new MediaTracker(mainPanel);
        tracker.addImage(image, 1);
        
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
           
    }
    
    boolean update(boolean bucketIsLeft) {
        y += 8;
        
        if(y>=480)
        {
            alive = false;
        }
        
        if(bucketIsLeft==false)
        {
            return false;
        }
         
        if(480-138-32<=y && y<=480-138)
        {
           succeeded = true;
           alive = false;
           return true;
        }
       
        
        return false;
    }
    
    public void draw(Graphics g, MainPanel mainPanel) {
        if(alive) {
            g.drawImage(image, x, y, mainPanel);
        }
        else {
            if(succeeded) {
                g.drawString("You Got a Apple!!", 30, 30);
            }
            else {
                g.drawString("you missed a apple...",30,30);
            }
        }

    }
    
    
   
   

    private boolean alive;
    private boolean succeeded;
    private int x;
    private int y;
    private Image image;
}
