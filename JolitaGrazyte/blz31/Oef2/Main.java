import java.lang.*;
/**
 * De klasse Main is een hoofdprogramma van oefening 2.
 * @author Jolita Grazyte
 *
*/


    
public class Main{
    
    public static void main(String args[]){
        
        Werknemer tomas = new Werknemer("tomas", "ragas", 001, 1200.00f);
        Werknemer koen = new Werknemer("koen", "kampioen", 002, 2500.00f);
        Werknemer donna = new Werknemer("donna", "summer", 003, 2600.00f );
        Werknemer jonas = new Werknemer("jonas", "van kempen", 004, 1000.00f );
        
        tomas.salarisVerhogen ( 10 );
        koen.salarisVerhogen ( 10 );
        
        System.out.println ( tomas.getSalaris() );
        System.out.println ( koen.getSalaris() );
    }

}
