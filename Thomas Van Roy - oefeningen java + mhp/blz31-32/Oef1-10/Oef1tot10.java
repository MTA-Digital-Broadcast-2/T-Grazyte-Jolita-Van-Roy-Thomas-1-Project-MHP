public class Oef1tot10
{
public static void main(String [] args)
	{
	//oef 1
	Werknemer thomas = new Werknemer("thomas", "van roy", 1, 15000.0f);
	Werknemer evelien = new Werknemer("evelien", "verlinden", 2, 1000.0f);
	Werknemer mathieu = new Werknemer("mathieu", "meganck", 3, 22000.0f);
	Werknemer ruben = new Werknemer("ruben", "haels", 4, 35000.0f);


	//oef 2
	thomas.salarisVerhogen(10);
	evelien.salarisVerhogen(10);

	System.out.println(thomas.voornaam + " verdient " + thomas.getSalaris());
	System.out.println(evelien.voornaam + " verdient " + evelien.getSalaris());


	//oef 3
	
	PartTimeWerknemer persoon1 = new PartTimeWerknemer("dollie", "parton", 3, 12.0f,20);
	PartTimeWerknemer persoon2 = new PartTimeWerknemer("parton", "dollie", 4, 14.0f,20);

	persoon1.salarisVerhogen(10);
	persoon2.salarisVerhogen(10);

	System.out.println(persoon1.voornaam + " verdient " + persoon1.getSalaris());
	System.out.println(persoon2.voornaam + " verdient " + persoon2.getSalaris());


	//oef 6
	thomas.setRSZ(2.0f);
	persoon1.setRSZ(2.0f);
	System.out.println(persoon1.voornaam + " betaalt " + persoon1.getRSZ() +" RSZ");
	System.out.println(thomas.voornaam + " betaalt " + thomas.getRSZ() +" RSZ");

	//oef 7
	StudentWerknemer jefke = new StudentWerknemer("jefke", "rupol", 7, 9.0f,20);
	System.out.println(jefke.voornaam + " betaalt " + jefke.getRSZ() +" RSZ");
	
	//oef 9
	thomas.betaal();
	persoon1.betaal();
	jefke.betaal();

	//oef10
	Faktuur faktuur = new Faktuur(5,6000);
	faktuur.betaal();
	}

}