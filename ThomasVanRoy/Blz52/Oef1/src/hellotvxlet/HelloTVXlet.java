package hellotvxlet;

import java.awt.event.KeyEvent;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.davic.resources.*;
import org.dvb.event.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {

    
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage bckgrIMG1 = new HBackgroundImage("pizza1.jpg");
    private HBackgroundImage bckgrIMG2 = new HBackgroundImage("pizza2.jpg");
    private HBackgroundImage bckgrIMG3 = new HBackgroundImage("pizza3.jpg");
    private HBackgroundImage bckgrIMG4 = new HBackgroundImage("pizza4.jpg");
    
    
    public int counter = 1;
    public void notifyRelease(ResourceProxy proxy){};
    public void release(ResourceProxy proxy){};
    public boolean requestRelease(ResourceProxy proxy, Object requestData){return false;}
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        System.out.println("destroyXlet");
        bckgrIMG1.flush();
        bckgrIMG2.flush();
        bckgrIMG3.flush();
        bckgrIMG4.flush();
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        screen = HScreen.getDefaultHScreen();
        
        bgDevice = screen.getDefaultHBackgroundDevice();
        
        if(bgDevice.reserveDevice(this))
        {
            System.out.println("BackgroundImage device has been reserverd");
        }
        else
        {
            System.out.println("Background image device cannot be reserved");
        }
        
        bgTemplate = new HBackgroundConfigTemplate();
        
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        
        try{
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch(java.lang.Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void pauseXlet() {
        System.out.println("PauseXlet");
    }

    public void startXlet() throws XletStateChangeException {
       System.out.println("Start XLET");
       bckgrIMG1.load(this);
       bckgrIMG2.load(this);
       bckgrIMG3.load(this);
       bckgrIMG4.load(this);
       
       EventManager manager = EventManager.getInstance();
        
        UserEventRepository repository = new UserEventRepository ("Voorbeeld");
        
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        try{
            bgConfiguration.displayImage(bckgrIMG1);
        }
        catch(Exception s)
        {
            System.out.println(s.toString());
        }
    }
    
    public void changeImage(int counter)
    {
        String image = "bckgrIMG" + counter;
  
        if(image.equals("bckgrIMG1"))
        {
            try{
            bgConfiguration.displayImage(bckgrIMG1);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("bckgrIMG2"))
        {
            try{
            bgConfiguration.displayImage(bckgrIMG2);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("bckgrIMG3"))
        {
            try{
            bgConfiguration.displayImage(bckgrIMG3);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("bckgrIMG4"))
        {
            try{
            bgConfiguration.displayImage(bckgrIMG4);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("Image kan niet geladen worden");
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            System.out.println("Pushed button");
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    System.out.println("VK_UP is PRESSED");
                    counter++;
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN PRESSED");
                    counter--;
                    break;
                case HRcEvent.VK_LEFT:
                    System.out.println("VK_LEFT PRESSED");
                    counter--;
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("VK_RIGHT PRESSED");
                    counter++;
                    break;
            }
            
            if(counter > 4)
            {
                counter = 1;
            }
            if(counter < 1)
            {
                counter = 4;
            }
            
            
            changeImage(counter);
            System.out.println(counter);
        }
    }
  
    
    
}