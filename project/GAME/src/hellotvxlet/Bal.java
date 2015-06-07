/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;


/**
 *
 * @author student: Jolita Grazyte
 */
//Klasse van HComponent overerven
public class Bal extends HComponent{
        static int DIAMETER = 30;
        int w, h, x, y;
    //Plaats en locatie instellen in de constructor
    public Bal(int posX, int posY, int width, int height){
      x = posX;
      y = posY;
      w = width;
      h = height;
      this.setBounds(posX, posY, width, height);
    
    }
    
    public void Verplaats(int x, int y)
    {
        this.setBounds(x, y, this.getWidth(), this.getHeight());
    }
    
    public void paint(Graphics g){
        
        g.setColor(new DVBColor(0, 255, 255, 255));
        g.fillOval(this.getXpos(), this.getYpos(), DIAMETER, DIAMETER);
    }
   
    public int getXpos()
    {
        return this.x;
    }
    
    public int getYpos(){
        return this.y;
    }
    
    public int getwidth()
    {
        return this.w;
    }
    
    public int getheight(){
        return this.h;
    }

}
