/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;


public class Ball {
     public int x,y;
     int r;
     private double speed;
     private int health;
	 int type;
	 Color color1;
	

    public Ball(int x,int y, int type  )
    {
        
        this.x=x;
        this.y=y;
         this.r =r;
		this.type = type;
		
		// default enemy
		if(type == 1) {
			color1 = Color.BLUE;
			
			
				speed = 2;
				r = 5;
				health = 1;
		}
		// stronger, faster
		if(type == 2) {
			
			color1 = Color.RED;
			
				speed = 3;
				r = 10;
				health = 3;
			
		}
		// slow, but hard to kill
		if(type == 3) {
			color1 = Color.GREEN;
			
				speed = 1.5;
				r = 25;
				health = 5;
			
			
		}
		
	
		
		
	}
	
    public  void move(int width)
    {
        y+=speed;
        if (y+50>width)
        {
            speed= -speed;
        }
        if (y<0)
        {
            speed= -speed;
        }
    }
    
}
