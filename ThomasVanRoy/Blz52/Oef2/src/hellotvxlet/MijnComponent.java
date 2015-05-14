package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;


//Klasse van HComponent overerven
public class MijnComponent extends HComponent{
   
    public String text = "Uw keuze: ";
    
    public MijnComponent(int X, int Y, int H, int W, String text)
    {
        System.out.println("MijnComponent");
        this.setBounds(X,Y,H,W);
        this.text = text;
    } 
    

    public void paint(Graphics g)
    {
        System.out.println("paint");
        g.setColor(new DVBColor(255,255,255,255));
        g.drawString( text, 10, 20);
    }


}



