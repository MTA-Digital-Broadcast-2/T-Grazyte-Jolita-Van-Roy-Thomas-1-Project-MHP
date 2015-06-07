//bestandsnaam: Oef3.java
import java.lang.*;

public class Oef3
{
	//dees is mijn klasse
	public static void main(String args[])
	{
		double pi = 0;
		double grens = 10000;
		double teller = 0;
		boolean plus = true;
		for(int i = 1; teller<grens; i = i+2 )
		{
			if(plus)
			{
				pi += (1/i);
				teller++;
				plus = false; 
			}
			else
			{
				pi -= (1/i);
				teller++;
				plus = true;
			}
		}
		pi = 4*pi;
		System.out.println(pi);
	}
}