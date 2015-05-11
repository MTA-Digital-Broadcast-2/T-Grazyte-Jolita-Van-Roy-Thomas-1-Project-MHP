//bestandsnaam: Oef2.java
import java.lang.*;

public class Oef2
{
	//dees is mijn klasse
	public static void main(String args[])
	{
		String dagen[] = {"zondag","maandag","dinsdag","woensdag","donderdag","vrijdag","zaterdag"};
		int teller = 0;
		int dag = 1;
		while(dag<29)
		{
			System.out.println(dagen[teller] + " " + dag + " februari");
			if(teller == 6)
			{
				teller = 0;
			};
			dag++;
		};
			
			
	}
}