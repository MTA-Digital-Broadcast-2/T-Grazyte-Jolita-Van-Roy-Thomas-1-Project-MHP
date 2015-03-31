package hellotvxlet;

import java.awt.Color;
import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.dvb.event.*;
import java.util.Timer;
import org.dvb.ui.DVBColor;

public class HelloTVXlet implements Xlet, UserEventListener, HActionListener {
     
    private MijnImage mIMG, mIMG1, mIMG2, mIMG3;
    private MijnImage bckgr;    
    private HScene scene;
    private Text name;
    private Block block, block1, block2;
    
    private Block[] blockjes;
    private Bal bal;
    private int balY;
    private HStaticText level;
    private HTextButton knop1, knop2, knop3, knop4, hulpKnop, pauseKnop, startKnop;
    
     private MijnTimer objMijnTimer = new MijnTimer(this);
     private Timer timer = new Timer();
     
     public int counter = 1;
     
     public int blockX, blockY;
    
    public HelloTVXlet() {
        
    }
    
    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
        scene = HSceneFactory.getInstance().getDefaultHScene();
        startKnop = new HTextButton( "START" );
        pauseKnop = new HTextButton( "PAUSE" );
        
        bckgr = new MijnImage("bckgr.jpg", 0, 0); 
        name = new Text(scene.getWidth()-150, 0, 200, 30, "Scores: 0");
        
        blockjes = new Block[12];
        blockjes[0] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 0, 10, 70, 20, Color.red);
        blockjes[1] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 72, 10, 70, 20, Color.blue);
        blockjes[2] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 144, 10, 70, 20, Color.green);
        blockjes[3] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 216, 10, 70, 20, Color.white);
        
        for(int i = 1; i<= blockjes.length; i++){
            
           //blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 0, 10, 70, 20, Color.red);
            System.out.println("for lus nr:"+i);
        }

        block = new Block(0, 550, scene.getWidth(), scene.getHeight(), 0, 5, 100, 20, Color.red);
        bal = new Bal(0, 0, scene.getWidth(), scene.getHeight());
        
        block1 = new Block(0, 0, scene.getWidth(), scene.getHeight(), 290, 10, 70, 20, Color.yellow);
        block2 = new Block(0, 0, scene.getWidth(), scene.getHeight(), 362, 10, 70, 20, Color.black);
        
        
        //mIMG1 = new MijnImage("spaceship.png",300,200);
        //mIMG2 = new MijnImage("spaceship.png",200,300);
        //mIMG3 = new MijnImage("spaceship.png",300,300);
        
        startKnop.setLocation(250, 300);
        startKnop.setSize(100, 50 );
        startKnop.setBackground( new DVBColor(0, 0, 179, 179) );
        startKnop.setBackgroundMode(HVisible.BACKGROUND_FILL );
        startKnop.setVisible(true);
        //startKnop.setFocusTraversal( null, null, null, pauseKnop );
        
        pauseKnop.setLocation(350, 300);
        pauseKnop.setSize(100, 50 );
        pauseKnop.setBackground( new DVBColor(0, 0, 0, 179) );
        pauseKnop.setBackgroundMode(HVisible.BACKGROUND_FILL );
        pauseKnop.setVisible(true);
        //pauseKnop.setFocusTraversal( null, null, startKnop, null );
        
        
        scene.add(bckgr);
        scene.add(block);
        scene.add(bal);
        scene.add(block1);
        scene.add(block2);
        
        scene.add(blockjes[0]);
        scene.add(blockjes[1]);
        scene.add(blockjes[2]);
        scene.add(blockjes[3]);
        scene.add(name);
        
        scene.add(startKnop);
        scene.add(pauseKnop);
        
        //scene.add(mIMG);      
        //scene.add(mIMG1);
        //scene.add(mIMG2);
        //scene.add(mIMG3);
        
        scene.popToFront(blockjes[0]);
        scene.popToFront(blockjes[1]);
        scene.popToFront(blockjes[2]);
        scene.popToFront(blockjes[3]);
        scene.popToFront(block);
        scene.popToFront(block1);
        scene.popToFront(block2);
        scene.popToFront(bal);
        scene.popToFront(name);
        
        
        scene.popToFront(startKnop);
        scene.popToFront(pauseKnop);
        //scene.popToFront(mIMG);
    
        //scene.popToFront(mIMG1);
        //scene.popToFront(mIMG2);
        //scene.popToFront(mIMG3);
        
        startKnop.setActionCommand( "START" );
        pauseKnop.setActionCommand( "PAUSE" );
        
        startKnop.addHActionListener(this);
        pauseKnop.addHActionListener(this);
        
        startKnop.requestFocus();
          
    }
    
    
    public void startXlet() throws XletStateChangeException {
           
        scene.validate();
        scene.setVisible(true);
        
        EventManager manager = EventManager.getInstance();
        
        UserEventRepository repository = new UserEventRepository ("Voorbeeld");
        
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
        
    }
    
    public void callback(){
       
       balY -= 20;
       if(balY == 0) balY++;
       bal.Verplaats(0, balY);
       
    }
    
    public void moveRight(){
        //blockX = block.getX();
       if(blockX < scene.getWidth()-105){
            blockX = block.getX();
            blockX += 10;
            block.Verplaats(blockX, block.getY());
            System.out.println(blockX);
    }
      
    }
    public void moveLeft(){
        //blockX = block.getX();
       if(blockX > 2){
            blockX = block.getX();
            System.out.println(blockX);
            blockX-=10;
            block.Verplaats(blockX, block.getY());       
        }   
    }
            
    public void pauseXlet() {
        
    }
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
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
                    moveLeft();
                    
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("VK_RIGHT PRESSED");
                    counter++;
                    moveRight();
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
           
            //System.out.println(counter);
        }
    }

    public void actionPerformed(ActionEvent e){
        System.out.print(e.getActionCommand());
        
        String action = e.getActionCommand();
        if(action.equals("START")){
            
            timer.scheduleAtFixedRate(objMijnTimer, 0, 30);
            startKnop.setVisible(false);
            pauseKnop.setVisible(true);
            pauseKnop.requestFocus();
          
        }
        else if(action.equals("PAUSE")){
           
            startKnop.setVisible(true);
            pauseKnop.setVisible(false);
            startKnop.requestFocus();
            
        }
    }
}