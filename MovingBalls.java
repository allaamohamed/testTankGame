/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
  


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;


//mesh 3aref besara7a a3ml eh l mafrod en kol 7aga mazbota we yeshta3'al ha7awel aboselek 3ala 7al  lw la2et ha2olek.. 5las merci ya omar t3btk.. 3ady mafesh ta3ab lw ma3reftesh te3mleh salemeh keda code bas tmaaam
public class MovingBalls extends JPanel implements Runnable{

   public ArrayList<Ball>Balls=new ArrayList<Ball>();
   public Tank BlueTank=new Tank("‪‪‪E:\\New folder\\TankBlueS.jpg");
   public Tank BlueTank2=new Tank("‪‪‪E:\\New folder\\TankBlueS.jpg");
   private JLabel Healthandscore;

   public MovingBalls()
    {
        Healthandscore=new JLabel();
        Healthandscore.setText("Health: "+ BlueTank.health+"  Player1Score  "+BlueTank.score+":"+BlueTank2.score+"  Player2Score"+ "  Health: "+ BlueTank2.health);
         
        setSize(600,600);
        setBackground(Color.red);
        BlueTank.pos.x=220;
        BlueTank.pos.y=340;
        BlueTank2.pos.x=420;
        BlueTank2.pos.y=340;
        this.addKeyListener(new keylist());
        add(Healthandscore);
       
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Test");
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
                repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: Balls)
        
        {
            g.setColor(OneBall.color1);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                
                if (OneBall.type == 1) {
                System.out.println("Hit Occurs" + OneBall.color1.toString());
                Balls.remove(OneBall);
                BlueTank.score++;
                break;
                }
                
                
                else if (OneBall.type == 2){
                    Ball b = new Ball(OneBall.x, OneBall.y, 1);
                    Ball b1 = new Ball(OneBall.x, OneBall.y, 1);
                }
                else if(OneBall.type==3){
                    Ball b = new Ball(OneBall.x, OneBall.y, 2);
                    Ball b1 = new Ball(OneBall.x, OneBall.y, 2);
                }
                
            }
            if (BlueTank2.Rocket2.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                
                if (OneBall.type == 1) {
                System.out.println("Hit Occurs" + OneBall.color1.toString());
                Balls.remove(OneBall);
                BlueTank2.score++;
                break;
                }
                
                
                else if (OneBall.type == 2){
                    Ball b = new Ball(OneBall.x, OneBall.y, 1);
                    Ball b1 = new Ball(OneBall.x, OneBall.y, 1);
                }
                else if(OneBall.type==3){
                    Ball b = new Ball(OneBall.x, OneBall.y, 2);
                    Ball b1 = new Ball(OneBall.x, OneBall.y, 2);
                }
                
            }
            if(BlueTank.pos.distance(OneBall.x,OneBall.y)<=50)
            {
            BlueTank.health--;
            }
            if(BlueTank2.pos.distance(OneBall.x,OneBall.y)<=50)
            {
            BlueTank2.health--;
            }
            if(BlueTank.health==0 && BlueTank2.health==0){}//shofy hate3mly eh lama el live tb2a 0
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: Balls)
        {
            OneBall.move(this.getHeight());
        }    
        
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}

