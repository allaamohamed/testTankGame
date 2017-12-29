/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Point;
public class Tank {

    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    public Bullet Rocket2=new Bullet();
    public int speed;
    public int score=0;
    public int health=3;
    public Tank ( String ImagePath)
    {
        speed=5;
        this.ImagePath=ImagePath;
        Rocket.imgPath="‪E:\\New folder\\rocket.gif";
        Rocket2.imgPath="‪E:\\New folder\\rocket.gif";
    }

    void mover() {
        this.pos.x+=speed;
    }
      void movel() {
        this.pos.x-=speed;
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x+60;
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
}


