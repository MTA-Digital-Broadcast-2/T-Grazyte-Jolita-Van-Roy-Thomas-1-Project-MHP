import java.lang.*;
/**
 * De klasse EersteProg is een Java applicatie
 * @author Jolita Grazyte
 * @version 1.9
*/

public class Oef2{
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
        int dag = 1;
        while( dag < 29){
            for (int i = 1; i < 8; i++)
            {
                switch (i)
                {
                    case 1:
                            System.out.println(dag +" Februari is " + " zondag");
                        break;
                    case 2: System.out.println(dag +" Februari is " + " maandag");
                        break;
                    case 3: System.out.println(dag +" Februari is " + " dinsdag");
                        break;
                    case 4: System.out.println(dag +" Februari is " + " woensdag");
                        break;
                    case 5: System.out.println(dag +" Februari is " + " donderdag");
                        break;
                    case 6: System.out.println(dag +" Februari is " + " vrijdag");
                        break;
                    case 7: System.out.println(dag +" Februari is " + " zaterdag");
                        break;
                }
                dag ++;
               System.out.println();
            }	
        }
    }

}

