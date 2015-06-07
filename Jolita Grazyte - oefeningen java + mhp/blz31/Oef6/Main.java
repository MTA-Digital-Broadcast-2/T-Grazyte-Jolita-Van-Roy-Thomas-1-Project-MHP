import java.lang.*;
/**
 * De klasse Main is hofdprogramma van oefening 6.
 * @author Jolita Grazyte
 *
*/


    
public class Main{
    
    public static void main(String args[]){
        
        Werknemer koen = new Werknemer("koen", "kampioen", 002, 2500.00f);
        PartTimeWerknemer jan = new PartTimeWerknemer("jan", "peeters", 005, (float) 3000.00, 10 );
        
        koen.setRSZ ( 25 );
        jan.setRSZ ( 30 );
        
        
        
        System.out.println ( jan.getRSZ() );
        System.out.println ( koen.getRSZ() );
    }

}
