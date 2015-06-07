/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;

/**
 *
 * @author student Jolita Grazyte
 */
public class MijnTimer extends TimerTask{
    HelloTVXlet xlet;
    
    public MijnTimer(HelloTVXlet xlet)
    {
        this.xlet = xlet;
    }
    
    public void run()
    {
        //System.out.println("Tick");
        xlet.callback();
    }
}