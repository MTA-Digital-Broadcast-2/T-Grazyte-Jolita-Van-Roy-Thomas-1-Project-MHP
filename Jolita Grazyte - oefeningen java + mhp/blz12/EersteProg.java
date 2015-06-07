import java.lang.*;
/**
 * De klasse EersteProg is een Java applicatie
 * @author Jolita Grazyte
 * @version 1.2
*/

public class EersteProg{
/**
 * Dit is een main-functie, hier start programma
 * @param args Diteen array van strings waarmee parameters kunnen meegegeven worden vanaf de commandline
*/	
	public static void main(String args[]){
		
		drukaf(100);
		
	}
/**
* Dit is een methode om 100 getallen af te drukken.
*/
	public static void drukaf(int m){
		int a;
		for(a=0; a < m; a++){
			System.out.println(a);
        }

}

}
