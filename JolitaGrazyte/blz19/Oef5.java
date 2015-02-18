import java.lang.*;
/**
 * De klasse EersteProg is een Java applicatie
 * @author Jolita Grazyte
 * @version 1.5
 */

public class Oef5{
    /**
     * Dit is een main-functie, hier start programma
     * @param args Dit is een array van strings waarmee parameters kunnen meegegeven worden vanaf de commandline
     */
    public static void main(String args[]){
        
        for (int i = 3; i < 99; i++)
        {
            if (isPriem(i)) System.out.println(i);
        }

        
        
    }
/**
*  Een methode over PriemGetal.
*/
    //checks whether an int is prime or not.
    public static boolean isPriem(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

}


