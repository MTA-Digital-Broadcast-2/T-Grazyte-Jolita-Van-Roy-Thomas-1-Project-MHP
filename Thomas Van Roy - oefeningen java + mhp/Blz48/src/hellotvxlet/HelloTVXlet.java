package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.event.*;
import java.util.Timer;
import org.dvb.event.*;

public class HelloTVXlet implements Xlet, UserEventListener {
    
    MijnImage mImage;
    int X;
    int Y;
    private int sterrenY;
    private MijnImage sterren;
    private MijnImage sterren2;
    private MijnImage scene;
            
    public HelloTVXlet() {
        
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        
        mImage = new MijnImage("spaceship.png",300,300);
        sterren = new MijnImage("sterren.png", 0, 0);
        sterren2 = new MijnImage("sterren.png", 0, -569);
        
        scene.add(mImage);
        scene.add(sterren);
        scene.add(sterren2);
        scene.popToFront(mImage);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }
    
    public void callback()
    {
        sterrenY++;
        sterren.Verplaats(0, sterrenY);
        sterren2.Verplaats(0, sterrenY-569);
        if(sterrenY > 569) sterrenY -= 569;
    }

    public void startXlet() throws XletStateChangeException {
        MijnTimer objMijnTimer = new MijnTimer(this);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(objMijnTimer, 0, 50);
        
        scene.validate();
        scene.setVisible(true);
    }
    
    public void userEventReceived(UserEvent e)
    {
        
    }

    public void actionPerformed(ActionEvent arg0) {
       
    }
}