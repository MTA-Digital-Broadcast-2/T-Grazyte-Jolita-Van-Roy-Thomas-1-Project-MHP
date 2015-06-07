//bestandsnaam: Oef7.java
import java.lang.*;

public class Oef7
{
	//dees is mijn klasse
	public static void main(String args[])
	{
		int a[]={12,34,56,78,123,234,99,88};
		int b[] = new int[8];
		int positieTePlaatsen = 0;

		int savePosition = 0;
		int hoogste = 0;

		for(int g = 0; g < a.length; g++)
		{
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] > hoogste)
				{
					hoogste = a[i];
					savePosition = i;
				}
			}
			b[positieTePlaatsen] = hoogste;
			a[savePosition] = 0;
			hoogste = 0;
			savePosition = 0;
			positieTePlaatsen++;
		}

		for(int i = 0; i < b.length;i++)
		{
			System.out.println(b[i]);
		}
	}
}