/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author yuni-net
 */
public class FirstGame extends JFrame {
    
    public FirstGame() {
        setTitle("first_test");
        setResizable(false);
        
        MainPanel panel = new MainPanel();
        panel.init();
        
        Container contentPane = getContentPane();
        contentPane.add(panel);
        
        pack(); // フレームサイズを自動調整
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FirstGame frame = new FirstGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
