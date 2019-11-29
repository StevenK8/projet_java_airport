package Main;

import Avions.Avion;
import Avions.AvionDiplomatique;

public class Main {

	public static void main(String[] args) {
		//exemple classe abstraite Avion --> implementation d'un avion diplomatique
		Avion avion = new AvionDiplomatique("Boeing 747", 660, 81600.0, 183380.0, 4,"France");
		System.out.println(avion.toString());
	}

}
