import java.lang.*;
/**
 * De klasse Main is hofdprogramma van oefening 4.
 * @author Jolita Grazyte
 *
*/


    
public class Main{
    
    public static void main(String args[]){
        
       
        PartTimeWerknemer jan = new PartTimeWerknemer("jan", "peeters", 005, (float) 3000.00, 10 );
        PartTimeWerknemer anna = new PartTimeWerknemer("anna", "gommes", 005, (float) 3500.00, 20 );
        
        jan.salarisVerhogen ( 10 );
        anna.salarisVerhogen ( 4 );
        
        System.out.println ( jan.getSalaris() );
        System.out.println ( anna.getSalaris() );
    }

}
