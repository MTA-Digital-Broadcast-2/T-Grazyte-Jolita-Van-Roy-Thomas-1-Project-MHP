package hellotvxlet;

/**
 * Oefening Blz 47
 * @author student: Jolita Grazyte
 */


import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.dvb.event.*;

public class HelloTVXlet implements Xlet, UserEventListener {
  
    
    MijnImage mImage;
    int X;
    int Y;
            
    public HelloTVXlet() {
        
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        
        mImage = new MijnImage("spaceship.png",0,0);
        
        scene.add(mImage);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        System.out.println("XLET gestart");
        EventManager manager = EventManager.getInstance();
        
        UserEventRepository repository = new UserEventRepository ("Voorbeeld");
        
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
    }
    
    public void userEventReceived(org.dvb.event.UserEvent e)
    {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            System.out.println("Pushed button");
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    System.out.println("VK_UP is PRESSED");
                    Y -= 10;
                    mImage.Verplaats(X,Y);
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN PRESSED");
                    Y += 10;
                    mImage.Verplaats(X,Y);
                    break;
                case HRcEvent.VK_LEFT:
                    X -= 10;
                    mImage.Verplaats(X,Y);
                    break;
                case HRcEvent.VK_RIGHT:
                    X += 10;
                    mImage.Verplaats(X,Y);
                    break;
            }
        }
    }

    public void actionPerformed(ActionEvent arg0) {
       
    }
}