import java.lang.*;
/**
 * De klasse EersteProg is een Java applicatie
 * @author Jolita Grazyte
 * @version 1.5
*/

public class Oef3{
/**
 * Dit is een main-functie, hier start programma
 * @param args Dit is een array van strings waarmee parameters kunnen meegegeven worden vanaf de commandline
*/	
	public static void main(String args[]){
		
		drukaf();
		
	}
/**
* Dit is een methode met PI.
*/
    
    public static void drukaf(){
        double som = 0.0;
        
        double teller = 1.0;
                               
        double noemer = 1.0;
                               
        for (int i=0; i<10000;i++){
                                   
            som += teller/noemer;
                                   
            teller = -teller;
                                   
            noemer += 2.0;
                                   
                if (i % 1000==0) {
                    System.out.print("\u03C0"+"=");
                    System.out.println(4.0*som);
                }
            
        }

    }

}

