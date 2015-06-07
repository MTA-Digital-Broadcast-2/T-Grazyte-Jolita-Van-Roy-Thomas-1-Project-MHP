import java.lang.*;
/**
 * De klasse Werknemer is een Java applicatie
 * @author Jolita Grazyte
 *
*/

public class Werknemer {
    
    public String voornaam;
    public String achternaam;
    public int werknemerNummer;
    protected float salaris;
    
    public Werknemer(String voornaam, String achternaam, int wNummer, float salaris ){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.werknemerNummer = wNummer;
        this.salaris = salaris;
}
    public void salarisVerhogen ( int percent ){
    
        float verhogingfactor = ( float ) percent/100;
        salaris += salaris * verhogingfactor;
    
    }
    
    public float getSalaris(){
        return salaris;
    }

}