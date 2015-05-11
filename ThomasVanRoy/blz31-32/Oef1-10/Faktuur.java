public class Faktuur implements Betaalbaar
{
	public int faktuurNr;
	public int faktuurBedrag;

	public Faktuur(int faktuurNr, int faktuurBedrag)
	{
		this.faktuurNr = faktuurNr;
		this.faktuurBedrag = faktuurBedrag;
	}

	public void betaal()
	{
		System.out.println("Betaal het faktuur " + this.faktuurNr + " voor een bedrag van " + this.faktuurBedrag);
	}
} 