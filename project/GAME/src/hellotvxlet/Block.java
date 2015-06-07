/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;


/**
 * 
 * @author student: Jolita Grazyte
 */
//Klasse van HComponent overerven
public class Block extends HComponent{
   
    int xPos, yPos, blockW, blockH;
    boolean isAlive;
    Color color;
    
    //Plaats en locatie instellen in de constructor
    public Block(int posX, int posY, int width, int height, int xPos, int yPos, int blockW, int blockH, Color initColor){
        this.xPos = xPos;
        this.yPos = yPos;
        this.blockW = blockW;
        this.blockH = blockH;
        this.isAlive = true;
        
        this.color = initColor;
        this.setBounds(posX, posY, width, height);
    
    }
    public void Verplaats(int x, int y)
    {
        this.setBounds(x, y, this.getWidth(), this.getHeight());
    }
    public void paint(Graphics g){
        
        //g.setColor(new DVBColor(255, 255, 255, 255));
        g.setColor(this.color);
        g.fillRect(xPos, yPos, blockW, blockH);
        
    }
    
    public int getXpos()
    {
        return this.xPos;
    }
    
    public int getYpos(){
        return this.yPos;
    }
    
    public int getwidth()
    {
        return this.blockW;
    }
    
    public int getheight(){
        return this.blockH;
    }
    
    public boolean isBlockVisible(){
        return this.isAlive;
    }
    
    public void killBlock(){
        this.isAlive = false;
    }
   
}
