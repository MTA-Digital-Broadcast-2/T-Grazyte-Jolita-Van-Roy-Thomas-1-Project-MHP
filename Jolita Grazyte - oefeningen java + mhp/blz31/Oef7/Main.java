import java.lang.*;
/**
 * De klasse Main is hofdprogramma van oefening 7.
 * @author Jolita Grazyte
 *
*/


    
public class Main{
    
    public static void main(String args[]){
        
        Werknemer koen = new Werknemer( "koen", "kampioen", 002, 2500.00f );
        PartTimeWerknemer jan = new PartTimeWerknemer( "jan", "peeters", 005, (float) 3000.00, 10 );
        StudentWerknemer serge = new StudentWerknemer( "serge", "guides", 006, ( float ) 1000.00, 5 );
        
        koen.setRSZ ( 25.0f );
        jan.setRSZ ( 30.0f );
        
        
        
        System.out.println ( jan.getRSZ() );
        System.out.println ( koen.getRSZ() );
        System.out.println  ( serge.getRSZ() );
    }

}
