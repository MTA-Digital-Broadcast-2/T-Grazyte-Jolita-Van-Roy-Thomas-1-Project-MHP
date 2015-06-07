import java.lang.*;
/**
 * De klasse Werknemer is een Java applicatie
 * @author Jolita Grazyte
 *
*/

public class Werknemer implements Betaalbaar {
    
    public String voornaam;
    public String achternaam;
    public int werknemerNummer;
    protected float salaris;
    private float RSZpercentage;
    
    public Werknemer(String voornaam, String achternaam, int wNummer, float salaris ){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.werknemerNummer = wNummer;
        this.salaris = salaris;
        this.RSZpercentage = 33.0f;
}
    
    public void betaal(){
        System.out.println( "Betaal het salaris van "+salaris+" aan de werknemer "+voornaam+" "+achternaam+".");
    }
    
    public void salarisVerhogen ( int percent ){
    
        float verhogingfactor = ( float ) percent/100;
        salaris += salaris * verhogingfactor;
    
    }
    
    public float getSalaris(){
        
        return salaris;
        
    }
    
    public void setRSZ ( float initRSZpercent ){
        
        this.RSZpercentage = initRSZpercent;
        
    }
    
    public float getRSZ (){
        
        return RSZpercentage;
    }

}