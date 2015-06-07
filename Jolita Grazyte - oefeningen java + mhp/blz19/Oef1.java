import java.lang.*;
/**
 * De klasse EersteProg is een Java applicatie
 * @author Jolita Grazyte
 * @version 1.5
*/

public class Oef1{
/**
 * Dit is een main-functie, hier start programma
 * @param args Dit is een array van strings waarmee parameters kunnen meegegeven worden vanaf de commandline
*/	
	public static void main(String args[]){
		
		drukaf();
		
	}
/**
* Dit is een methode om 9 tafels af te drukken.
*/
	public static void drukaf(){
        int a;
        for(int x=1; x<10; x++){
            for(int y=1; y<10; y++ )
            System.out.println(x+"x"+y+"="+(x*y));
            
        }
    }

}

