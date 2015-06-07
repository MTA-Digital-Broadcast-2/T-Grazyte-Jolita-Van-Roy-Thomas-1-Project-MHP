package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {
    
    private XletContext actueleXletContext;
    private HScene scene;
    private MijnComponent mc = new MijnComponent(200, 50, 300, 300);

  
    private boolean debug = true;
    private HStaticText tekstJuist, tekstFout;
    private HTextButton knop1, knop2, knop3, knop4, hulpKnop;
  
    public HelloTVXlet() {
       
    }

    public void initXlet(XletContext context) {
        if (debug) System.out.println( "Xlet initialiseren" );
        this.actueleXletContext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
 
        sceneTemplate.setPreference ( HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension ( 1.0f, 1.0f ), HSceneTemplate.REQUIRED );
        sceneTemplate.setPreference ( HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint (0.0f, 0.0f), HSceneTemplate.REQUIRED );
        
        
        scene = HSceneFactory.getInstance().getBestScene( sceneTemplate );
        
        tekstJuist = new HStaticText("Juist!");
        tekstFout = new HStaticText("Fout!");
        knop1 = new HTextButton( "antwoord 1" );
        knop2 = new HTextButton( "antwoord 2" );
        knop3 = new HTextButton( "antwoord 3" );
        knop4 = new HTextButton( "antwoord 4" );
        hulpKnop = new HTextButton( "Hulplijn aanvragen" );
        
        
        tekstJuist.setLocation(250, -20);
        tekstJuist.setSize(300, 250 );
        tekstJuist.setBackground( new DVBColor(0, 0, 179, 179) );
        tekstJuist.setBackgroundMode(HVisible.BACKGROUND_FILL );
        tekstJuist.setVisible(false);
        
        tekstFout.setLocation(250, -20);
        tekstFout.setSize(300, 250 );
        tekstFout.setBackground( new DVBColor(0, 0, 0, 179) );
        tekstFout.setBackgroundMode(HVisible.BACKGROUND_FILL );
        tekstFout.setVisible(false);
        
        
   
        knop1.setLocation(50, 50);
        knop1.setSize(150, 50);
        knop1.setBackground(new DVBColor( 0, 0, 0, 179 ));
        knop1.setBackgroundMode( HVisible.BACKGROUND_FILL );
        knop1.setFocusTraversal( null, knop2, null, null );
        
        knop2.setLocation(50, 150);
        knop2.setSize(150, 50);
        knop2.setBackground(new DVBColor( 0, 0, 0, 179 ));
        knop2.setBackgroundMode( HVisible.BACKGROUND_FILL );
        knop2.setFocusTraversal( knop1, knop3, null, null );
        
        knop3.setLocation(50, 250);
        knop3.setSize(150, 50);
        knop3.setBackground(new DVBColor( 0, 0, 0, 179 ));
        knop3.setBackgroundMode( HVisible.BACKGROUND_FILL );
        knop3.setFocusTraversal( knop2, knop4, null, null );
        
        knop4.setLocation(50, 350);
        knop4.setSize(150, 50);
        knop4.setBackground(new DVBColor( 0, 0, 0, 179 ));
        knop4.setBackgroundMode( HVisible.BACKGROUND_FILL );
        knop4.setFocusTraversal( knop3, hulpKnop, null, null );
        
        hulpKnop.setLocation(50, 450);
        hulpKnop.setSize(200, 50);
        hulpKnop.setBackground(new DVBColor( 0, 0, 0, 179 ));
        hulpKnop.setBackgroundMode( HVisible.BACKGROUND_FILL );
        hulpKnop.setFocusTraversal( knop3, null, null, null );
        
 
        scene.add( tekstJuist );
        scene.add( tekstFout );
        scene.add( knop1 );
        scene.add( knop2 );
        scene.add( knop3 );
        scene.add( knop4 );
        scene.add(hulpKnop);
        
        scene.add(mc);
        
        knop1.requestFocus();
        

          knop2.setActionCommand( "knop2-actioned" );
          
        hulpKnop.setActionCommand("hulp");
        
        knop1.addHActionListener(this);
        knop2.addHActionListener(this); 
        knop3.addHActionListener(this);
        knop4.addHActionListener(this);
        hulpKnop.addHActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e){
        System.out.print(e.getActionCommand());
        
        String action = e.getActionCommand();
        if(action.equals("knop2-actioned")){
            
            tekstJuist.setVisible(true);
            tekstFout.setVisible(false);
        }
        else if(action.equals("hulp")){
            knop1.setVisible(false);
        }
        else
        {
            tekstJuist.setVisible(false);
            tekstFout.setVisible(true);    
        }
    }
    public void startXlet() {
        if(debug) System.out.println( "XLET STARTEN" );
        scene.validate();
        scene.setVisible( true );
    }

    public void pauseXlet() {
     
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

}
