//bestandsnaam: Oef6.java
import java.lang.*;

public class Oef6
{
	//dees is mijn klasse
	public static void main(String args[])
	{
		int a[]={12,34,56,78,123,234,99,88};
		int hoogste = 0;

		for(int i = 0; i < a.length; i++)
		{
			if(a[i] > hoogste)
			{
				hoogste = a[i];
			}
		}

		System.out.println(hoogste);
	}
}