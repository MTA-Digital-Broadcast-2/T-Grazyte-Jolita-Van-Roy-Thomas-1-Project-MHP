/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;


/**
 * Oefening Blz 44: MijnComponent
 * @author student: Jolita Grazyte
 */
//Klasse van HComponent overerven
public class Bal extends HComponent{

    //Plaats en locatie instellen in de constructor
    public Bal(int posX, int posY, int width, int height){
      
        this.setBounds(posX, posY, width, height);
    
    }
    
    public void Verplaats(int x, int y)
    {
        this.setBounds(x, y, this.getWidth(), this.getHeight());
    }
    
    public void paint(Graphics g){
        
        g.setColor(new DVBColor(0, 255, 255, 255));
        g.fillOval(20, 525, 30, 30);
        
    }

}
