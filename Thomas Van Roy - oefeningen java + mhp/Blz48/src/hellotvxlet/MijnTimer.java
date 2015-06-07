package hellotvxlet;

import java.util.TimerTask;

public class MijnTimer extends TimerTask{
    HelloTVXlet xlet;
    
    public MijnTimer(HelloTVXlet xlet)
    {
        this.xlet = xlet;
    }
    
    public void run()
    {
        System.out.println("Tick");
        xlet.callback();
    }
}