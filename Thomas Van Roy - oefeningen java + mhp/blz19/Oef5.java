//bestandsnaam: Oef5.java
import java.lang.*;

public class Oef5
{
	//dees is mijn klasse
	public static void main(String args[])
	{
		boolean priem = false;

		for(int i = 3; i<100; i++)
		{
			for(int a = 2; a < i; a++)
			{
				if(i%a == 0)
				{
					priem = true;
				}
			}
			
			if(priem == false)
			{
				System.out.println(i);
			}
			else
			{
				priem = false;
			}
		}
	}
}