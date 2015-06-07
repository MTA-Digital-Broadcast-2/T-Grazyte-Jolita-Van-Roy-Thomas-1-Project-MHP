import java.lang.*;
/**
 * De klasse Main is hofdprogramma van oefening 9.
 * @author Jolita Grazyte
 *
*/


    
public class Main{
    
    public static void main(String args[]){
        
        Werknemer echteWerker = new Werknemer( "koen", "kampioen", 002, 2500.0f );
        PartTimeWerknemer jan = new PartTimeWerknemer( "jan", "peeters", 005, 3000.0f, 10 );
        StudentWerknemer student = new StudentWerknemer( "serge", "guides", 006, 1000.0f, 5 );
        
        
        echteWerker.betaal();
        jan.betaal();
        student.betaal();
        
        
    }

}
