/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Color;
/**
 *
 * @author Khaled
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  JFrame jf=new JFrame();
        jf.setSize(600, 600);
        
        MovingBalls mb=new MovingBalls();
        
       
        mb.Balls.add(new Ball(100,40,1));
        mb.Balls.add(new Ball(160,40,2));
        mb.Balls.add(new Ball(180,40,3));
        mb.Balls.add(new Ball(200,40,1));
        mb.Balls.add(new Ball(240,40,2));
        mb.Balls.add(new Ball(260,40,3));
        mb.Balls.add(new Ball(320,40,3));
        mb.Balls.add(new Ball(350,40,1));
        mb.Balls.add(new Ball(400,40,2));
        mb.Balls.add(new Ball(460,40,3));
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb) ;
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
}
