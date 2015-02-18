import java.lang.*;
/**
 * De klasse EersteProg is een Java applicatie
 * @author Jolita Grazyte
 * @version 1.5
*/

public class Oef6{
/**
 * Dit is een main-functie, hier start programma
 * @param args Dit is een array van strings waarmee parameters kunnen meegegeven worden vanaf de commandline
*/	
	public static void main(String args[]){
		
		drukaf();
		
	}
/**
* Bewaar het getal 4302 in een integer. Bereken het negatief van dit getal zonder de min operator te gebruiken.
*/

    
    public static void drukaf(){
        
        int nrArr[] = {12, 34, 56, 78, 123, 234, 99, 88};
        int grootsteGetal = nrArr[0];
        for(int i = 0; i < nrArr.length; i++){
            if (grootsteGetal < nrArr[i])
                grootsteGetal = nrArr[i];
            }
        System.out.println(grootsteGetal);
    }

}

