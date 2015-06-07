package hellotvxlet;

import java.awt.*;
import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.dvb.event.*;
import java.util.*;
import org.dvb.ui.DVBColor;


public class HelloTVXlet implements Xlet, UserEventListener, HActionListener {
     
    private MijnImage bckgr;    
    private HScene scene;
    private Text name;
    private Block racquet;
    private Block[] blockjes;
    private Color[] Colors;
    private Bal bal;
    private int balY;
    private int balX;
    private Random random;
    private HStaticText level;
    private HTextButton pauseKnop, startKnop;
    int xa, ya = 5;
    
     private MijnTimer objMijnTimer = new MijnTimer(this);
     private Timer timer = new Timer();
     
     public int counter = 1;
    
     public int racquetX, racquetY;
    
    public HelloTVXlet() {
        
    }
    
    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
        scene       = HSceneFactory.getInstance().getDefaultHScene();
        startKnop   = new HTextButton( "START" );
        pauseKnop   = new HTextButton( "PAUSE" );
        random      = new Random();
        bckgr       = new MijnImage("bckgr.jpg", 0, 0); 
        name        = new Text(scene.getWidth()-150, 0, 200, 30, "Scores: 0");
        blockjes    = new Block[70];
        Colors      = new Color[10];
        
        //initiliaze colors
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

        
        startKnop.setLocation(230, 300);
        startKnop.setSize(250, 50 );
        startKnop.setBackground( new DVBColor(0, 0, 179, 179) );
        startKnop.setBackgroundMode(HVisible.BACKGROUND_FILL );
        startKnop.setVisible(true);
        startKnop.setFocusTraversal( null, null, null, pauseKnop );
        
        pauseKnop.setLocation(350, 300);
        pauseKnop.setSize(100, 50 );
        pauseKnop.setBackground( new DVBColor(0, 0, 0, 179) );
        pauseKnop.setBackgroundMode(HVisible.BACKGROUND_FILL );
        pauseKnop.setVisible(false);
        //pauseKnop.setFocusTraversal( null, null, startKnop, null );
        
        scene.add(bckgr);
        scene.add(name);
        scene.add(startKnop);
        scene.add(pauseKnop);
        scene.popToFront(name);
        scene.popToFront(startKnop);
        scene.popToFront(pauseKnop);
   
        startKnop.setActionCommand( "START" );
        pauseKnop.setActionCommand( "PAUSE" );
        startKnop.addHActionListener(this);
        pauseKnop.addHActionListener(this);
 
        startKnop.requestFocus();
        
        //controls
        bal       = new Bal(0, 0, scene.getWidth(), scene.getHeight());
        racquet   = new Block(0, 548, scene.getWidth(), scene.getHeight(), 0, 5, 150, 20, Color.red);
        
        
        scene.add(racquet);
        scene.add(bal);
        scene.popToFront(racquet);
        scene.popToFront(bal); 
     
    }
    public void startGame(){
        
        for(int i = 0; i<= 64; i++){
              
              int randomNumber = random.nextInt(Colors.length);
              Color randomColor = Colors[randomNumber];
            
            if(i < 8){
                blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 70+72*i, 40, 70, 20, randomColor);
            }
            else if(i < 17){
                blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 35+72*(i-8), 62, 70, 20, randomColor);
            }
            else if(i < 27){
              blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 0+72*(i-17), 84, 70, 20, randomColor);
            }
            else if(i < 37){
               blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 0+72*(i-27), 106, 70, 20, randomColor);
            }
            else if(i < 47){
              blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 0+72*(i-37), 128, 70, 20, randomColor);
            }
              else if(i < 56){
              blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 35+72*(i-47), 150, 70, 20, randomColor);
            }
              else if(i < 64){
              blockjes[i] = new Block(0, 0, scene.getWidth(), scene.getHeight(), 70+72*(i-56), 172, 70, 20, randomColor);
            }
            
            scene.add(blockjes[i]); 
            scene.popToFront(blockjes[i]);
            randomNumber = 0;
        }
    };
    
    public void startXlet() throws XletStateChangeException {
           
        scene.validate();
        scene.setVisible(true);
        
        EventManager manager = EventManager.getInstance();

        UserEventRepository repository = new UserEventRepository ("");
        
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
        
    }
    
    public void callback(){       
       // bounce left
        if(bal.getX()+ xa < 1){
            xa = 5;
        }
       // bounce right
        else if (bal.getX()+ xa > scene.getWidth()-30)
            xa = -5;
       
       // bounce up
       if(bal.getY() + ya < 0)
           ya = 5;
       
       // must change to IF COLLISION
       //else if(bal.getY() + ya > scene.getHeight()-50)
      if(rCollision())
           ya = -5;
       else if (bal.getY() + ya > scene.getHeight())
           System.out.println("GAME OVER!");
       // ball under the scene
      // else if(bal.getY() + ya > scene.getHeight())
      // System.out.println("GAME OVER");
       
       balX = bal.getX() + xa;
       balY = bal.getY() + ya;
       
       bal.Verplaats(balX, balY);
       
       for(int i = 0; i <= blockjes.length; i++)
       {   
               if(bal.getX() >= blockjes[i].getX() && bal.getX() <= (blockjes[i].getX() + blockjes[i].getWidth()))
               {
                   if(bal.getY() <= blockjes[i].getY() + blockjes[i].getHeight())
                   {
                       if(bal.getY() + bal.getHeight() >= blockjes[i].getY()){
                           ya = 5;
                       }else
                       {
                           ya = -5;
                       }
                       
                       blockjes[i].killBlock();
                       scene.remove(blockjes[i]);
                   }
               }
       }
    }
    
    public void moveRight(){
       if(racquetX < scene.getWidth()-105){
           racquetX = racquet.getX();
           racquetX += 20;
           racquet.Verplaats(racquetX, racquet.getY());
    }
      
    }
    public void moveLeft(){
       if(racquetX > 2){
            racquetX = racquet.getX();
            racquetX-=20;
            racquet.Verplaats(racquetX, racquet.getY());       
        }   
    }

            
    public void pauseXlet() {
        
    }
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
    }
    
    public void userEventReceived(UserEvent e) {
        
        if(e.getCode() == HRcEvent.VK_LEFT) moveLeft();
        if(e.getCode() == HRcEvent.VK_RIGHT) moveRight();
       
    }

    public void actionPerformed(ActionEvent e){
        
        System.out.println(e.getActionCommand());
        
        String action = e.getActionCommand();
        if(action.equals("START")){
            
            startKnop.setVisible(false);
            timer.scheduleAtFixedRate(objMijnTimer, 0, 40);
            this.startGame();
            pauseKnop.setVisible(true);
            pauseKnop.requestFocus();
            
        }
        else if(action.equals("PAUSE")){
           
            startKnop.setVisible(true);
            pauseKnop.setVisible(false);
            startKnop.requestFocus();
         
        }
    }
    public boolean rCollision(){
        
        Rectangle r = new Rectangle(racquet.getX(), 548, 150, 20);  
        Rectangle b = new Rectangle(balX, balY, 30, 30);
        boolean collision = b.intersects(r);
        System.out.println("Racquet: "+racquet.getX()+" - "+racquet.getY()+" - "+racquet.getwidth()+" - "+racquet.getheight());
        System.out.println("BALL: "+balX+" - "+balY+" - "+bal.getwidth()+" - "+bal.getheight());
        System.out.println(r.getBounds());
        return collision; 
    }
}