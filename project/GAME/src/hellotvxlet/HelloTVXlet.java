package hellotvxlet;

import java.awt.Color;
import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.dvb.event.*;
import java.util.Timer;
import org.dvb.ui.DVBColor;
import java.lang.Object;
import java.util.Random;

public class HelloTVXlet implements Xlet, UserEventListener, HActionListener {
     
    private MijnImage mIMG, mIMG1, mIMG2, mIMG3;
    private MijnImage bckgr;    
    private HScene scene;
    private Text name;
    private Block block;
    private String direction = "up";
    
    private Block[] blockjes;
    private Color[] Colors;
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
        
        blockjes = new Block[16];
        Colors = new Color[10];
        
        Colors[0] = Color.red;
        Colors[1] = Color.blue;
        Colors[2] = Color.yellow;
        Colors[3] = Color.pink;
        Colors[4] = Color.cyan;
        Colors[5] = Color.gray;
        Colors[6] = Color.orange;
        Colors[7] = Color.magenta;
        Colors[8] = Color.white;
        Colors[9] = Color.green;
        
        Random random = new Random();
        for(int i = 0; i< 16; i++){
            int randomNumber = random.nextInt(Colors.length);
            
            Color randomColor = Colors[randomNumber];
            
            if(i < 4)
            {
                blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 0+72*i, 40, 70, 20, randomColor);
            }
            else
            {
                if(i < 8)
                {
                    blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 0+72*(i-4), 62, 70, 20, randomColor);
                }
                else
                {
                    if(i < 12)
                    {
                        blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 0+72*(i-8), 84, 70, 20, randomColor);
                    }
                    else
                    {
                        blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 0+72*(i-12), 108, 70, 20, randomColor);
                    }
                }
            }       
            randomNumber = 0;
        }

        block = new Block(0, 550, scene.getWidth(), scene.getHeight(), 0, 5, 100, 20, Color.red);
        bal = new Bal(0, 0, scene.getWidth(), scene.getHeight());
        
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
        
        for(int i = 0;i<blockjes.length;i++)
        {
            if(blockjes[i].isAlive = true)
            {
                scene.add(blockjes[i]); 
            }
        }
        
        
        
        scene.add(name);
        
        scene.add(startKnop);
        scene.add(pauseKnop);
        
        //scene.add(mIMG);      
        //scene.add(mIMG1);
        //scene.add(mIMG2);
        //scene.add(mIMG3);
        
        for(int i = 0;i<blockjes.length;i++)
        {
            if(blockjes[i].isAlive = true)
            {
                scene.popToFront(blockjes[i]); 
            }
        }
        
        scene.popToFront(block);
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
       for(int i = 0; i < blockjes.length; i++)
       {
           if(bal.getXpos() >= blockjes[i].getXpos() && bal.getXpos() <= (blockjes[i].getXpos() + blockjes[i].getwidth()))
           {
               if(bal.getYpos() <= blockjes[i].getYpos() + blockjes[i].getheight())
               {
                   if(direction == "up")
                   {
                       direction = "down";
                   }
                   else
                   {
                       direction = "up";
                   }
                   blockjes[i].killBlock();
                   scene.remove(blockjes[i]);
               }
               
           }
       }
       
       if(direction == "up")
       {
            balY -= 15;
       }
       else
       {
           balY += 15;
       }
       
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