import java.lang.*;
/**
 * De klasse EersteProg is een Java applicatie
 * @author Jolita Grazyte
 * @version 1.5
*/

public class OefExtra{
/**
 * Dit is een main-functie, hier start programma
 * @param args Dit is een array van strings waarmee parameters kunnen meegegeven worden vanaf de commandline
*/	
	public static void main(String args[]){
		
		drukaf();
		
	}
/**
* Een methode om dagen van February af te drukken.
*/
	public static void drukaf(){
     
        
        char ster = '\u2605';
        for (int i = 0; i < 16; i++)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print(ster);
                ster << j;
            }
            
            System.out.print("\n");
 }
        }

}

