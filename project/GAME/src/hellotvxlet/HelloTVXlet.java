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
    private Racquet racquet;
    private Block[] blockjes;
    private Color[] colors;
    private Bal bal;
    int score = 0;
    private int balY;
    private int balX;
    private Random random;
    private Text levens;
    private HTextButton pauseKnop, startKnop;
    int xa, ya = 5;
    int aantalLevens = 3;
    
     private MijnTimer objMijnTimer = new MijnTimer(this);
     private Timer timer = new Timer();
     
     public int counter = 1;
    
     public int racquetX, racquetY;
    private  int step = 10;
    
    public HelloTVXlet() {
        
    }
    
    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
        scene       = HSceneFactory.getInstance().getDefaultHScene();
        startKnop   = new HTextButton( "START" );
        pauseKnop   = new HTextButton( "PAUSE" );
        random      = new Random();
        bckgr       = new MijnImage("bckgr.jpg", 0, 0); 
        name        = new Text(scene.getWidth()-150, 0, 200, 30, "Scores: 0");
        levens      = new Text(scene.getWidth()-250, 0, 200, 30, "Levens: " + aantalLevens);
        blockjes    = new Block[70];
        colors      = new Color[]{Color.red, Color.blue, Color.yellow, Color.pink, Color.cyan, Color.orange, Color.magenta, Color.white, Color.green, Color.gray };
        
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
        pauseKnop.setFocusTraversal( null, null, startKnop, null );
      
        
        scene.add(bckgr);
        scene.add(name);
        scene.add(levens);
        scene.add(startKnop);
        scene.add(pauseKnop);
        scene.popToFront(name);
        scene.popToFront(levens);
        scene.popToFront(startKnop);
        scene.popToFront(pauseKnop);
   
        startKnop.setActionCommand( "START" );
        pauseKnop.setActionCommand( "PAUSE" );
        startKnop.addHActionListener(this);
        pauseKnop.addHActionListener(this);
 
        startKnop.requestFocus();
        
        //controls
        bal     = new Bal(0, 0, scene.getWidth(), scene.getHeight());
        racquet = new Racquet( 270, 548, scene.getWidth(), scene.getHeight(), 0, 5, 150, 30, Color.orange);
        scene.add(racquet);
        scene.add(bal);
        scene.popToFront(racquet);
        scene.popToFront(bal); 
     
        this.startGame();
    }
    public void startGame(){
        
        for(int i = 0; i<= 64; i++){
              
              int randomNumber = random.nextInt(colors.length);
              Color randomColor = colors[randomNumber];
            
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
            
            if(blockjes[i] != null){
            scene.add(blockjes[i]); 
            scene.popToFront(blockjes[i]);
            }
            randomNumber = 0;
        }
        
    }
    
    public void startXlet() throws XletStateChangeException {
           
        scene.validate();
        scene.setVisible(true);
        
    }
    
    public void addElements(){
            EventManager manager = EventManager.getInstance();

        UserEventRepository repository = new UserEventRepository ("");
        
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
       }
    public void callback(){
        
      for(int i = 0; i < 64; ++i){
           if(blockjes[i] != null && this.collision( blockjes[i])){
                   /*if(bal.getY() + ya < blockjes[i].getYpos()-5){*/
               if(blockjes[i].isAlive){
                       blockjes[i].killBlock();
                       ya = -step;
                       score += 5;
                       scene.remove(blockjes[i]);
                       scene.remove(name);
                       name        = new Text(scene.getWidth()-150, 0, 200, 30, "Scores: " + score);
                       scene.add(name);
                       scene.popToFront(name);
               }
                   /*}*/
           }
      }
       
       // bounce left
        if(bal.getX()+ xa < 1){
            xa = step;
        }
       // bounce right
        else if (bal.getX()+ xa > scene.getWidth()-10)
            xa = -step;
        
       // bounce up
       if(bal.getY() + ya < 0)
           ya = step;
       
      if(collision(null)){
          ya = -step;
      }
       // must change to IF COLLISION
       //else if(bal.getY() + ya > scene.getHeight()-50)
      
       if (bal.getY() + ya > scene.getHeight())
       {
           aantalLevens--;
           scene.remove(levens);
           scene.add(levens);
           scene.popToFront(levens);
           if(aantalLevens == 0)
           {
               System.out.println("GAME OVER!");
               //stop game?
           }
           else{
               //replace ball at right positio
           }
       }
       
       // ball move
       balX = bal.getX() + xa;
       balY = bal.getY() + ya;
       
       bal.Verplaats(balX, balY);
       
    }
    
    public void moveRight(){
       if(racquetX < scene.getWidth()-150){
           racquetX = racquet.getX();
           racquetX += 20;
           racquet.Verplaats(racquetX, racquet.getY());
    }
      
    }
    public void moveLeft(){
       if(racquetX > 5){
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
            this.addElements();
            timer.scheduleAtFixedRate(objMijnTimer, 0, 30);
            //this.startGame();
            
            pauseKnop.setVisible(false);
            pauseKnop.requestFocus();
            
        }
        else if(action.equals("PAUSE")){
           
            startKnop.setVisible(true);
            pauseKnop.setVisible(false);
            startKnop.requestFocus();
         
        }
    }
    public boolean collision(Block block){
        boolean collision = false;
        if(block != null){
            Rectangle bl = new Rectangle(block.getXpos(), block.getYpos(), block.getWidth(), block.getheight());
            Rectangle b = new Rectangle(balX, balY, 30, 30);
            collision = bl.intersects(b);
        }
        else{
            Rectangle r = new Rectangle(racquet.getX(), 548, 150, 20);
            Rectangle b = new Rectangle(balX, balY, 30, 30);
            collision = b.intersects(r);
        }
        return collision; 
    }

}