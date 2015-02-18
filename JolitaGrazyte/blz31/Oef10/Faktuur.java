import java.lang.*;
/**
 * De klasseFaktuur is een Java klasse die implementeert het methode betaal uit de interface klasse Betaalbaar.
 * @author Jolita Grazyte
 *
*/

public class Faktuur implements Betaalbaar {
    
    private int faktuurNr;
    private float faktuurBedrag;
    
    public Faktuur(int fakNr, float fakBedrag){
        this.faktuurNr = fakNr;
        this.faktuurBedrag = fakBedrag;
        
}
    
    public void betaal(){
        System.out.println( "Betaal het faktuur nr: "+faktuurNr+" voor een bedrag van "+faktuurBedrag+".");
    }
    
   }