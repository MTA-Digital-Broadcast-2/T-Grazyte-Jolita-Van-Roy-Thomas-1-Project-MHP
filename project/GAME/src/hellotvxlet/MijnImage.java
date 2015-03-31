/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;

public class MijnImage extends HComponent {
    
    private Image bmap;
    private MediaTracker mtrack;
    int xPos, yPos;
    
    
    public MijnImage(String bitmapnaam, int x, int y)
    {
        bmap = this.getToolkit().getImage(bitmapnaam);
        mtrack = new MediaTracker(this);
        mtrack.addImage(bmap, 3);
        
        this.xPos = 0; 
        this.yPos = 0;
        
        try
        {
            mtrack.waitForAll();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
        this.setBounds( x, y, bmap.getWidth(null), bmap.getHeight(null) );
    } 
    
    
    public void paint(Graphics g){
        
        g.drawImage( bmap, xPos, yPos, null );
    }

}
