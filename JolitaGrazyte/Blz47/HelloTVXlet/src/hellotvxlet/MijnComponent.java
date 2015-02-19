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
public class MijnComponent extends HComponent{
   
    
    //Plaats en locatie instellen in de constructor
    public MijnComponent(int posX, int posY, int width, int height){
        
        this.setBounds(posX, posY, width, height);
    
    }
    
    public void paint(Graphics g){
        g.setColor(new DVBColor(0, 0, 0, 100));
        g.fillRoundRect(25, 95,  200, 100, 40, 40);
        
        g.setColor(new DVBColor(0, 0, 179, 150));
        g.fillRoundRect(20, 100, 200, 100, 40, 40);
        
        
       
        //g.fillRect(0, 0, 200, 200);
        //g.setColor(Color.white);
        g.setColor(new DVBColor(255, 255, 0, 175));
        g.drawString("Mijn Component", 45, 160);
    
    }

}
