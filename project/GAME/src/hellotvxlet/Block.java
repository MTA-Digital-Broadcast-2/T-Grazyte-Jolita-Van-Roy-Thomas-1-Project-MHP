/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;
import java.util.Random;


/**
 * Oefening Blz 44: MijnComponent
 * @author student: Jolita Grazyte
 */
//Klasse van HComponent overerven
public class Block extends HComponent{
   
    int xPos, yPos, blockW, blockH;
    Color color;
    
    //Plaats en locatie instellen in de constructor
    public Block(int posX, int posY, int width, int height, int xPos, int yPos, int blockW, int blockH, Color initColor){
        this.xPos = xPos;
        this.yPos = yPos;
        this.blockW = blockW;
        this.blockH = blockH;
        
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

}
