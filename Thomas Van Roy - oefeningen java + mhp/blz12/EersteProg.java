//bestandsnaam: EersteProg.java
import java.lang.*;

public class EersteProg
{
	//dees is mijn klasse
	public static void main(String args[])
	{
		/*
			main method
		*/
		drukaf(100);
	}

	public static void drukaf(int m)
	{
		/*
			drukaf method
		*/
		int a;
		for(a=0;a<m;a++)
		{
			System.out.println(a);
		}
	}
}