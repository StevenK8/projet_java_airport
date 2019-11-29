package Main;

import Avions.Avion;
import Avions.AvionDiplomatique;
import Avions.AvionLigne;
import Avions.AvionPrive;
import CompagnieAerienne.Compagnie;
import Personnes.DateNaissance;
import Personnes.Passager;
import Personnes.Personne;;

public class Main {

	public static void main(String[] args) {
		
		DateNaissance date = new DateNaissance(1, 1, 1);
		Personne proprio = new Personne("prenom", "nom", date, "france");
		Compagnie airFrance = new Compagnie("AirFrance", "France");
		
		AvionPrive avionprive1 = new AvionPrive("airbus a380", 12, 12000.0, 10000.0, 2, proprio, 1);
		
		AvionLigne avionLigne1 = new AvionLigne("airbus a320", 4, 12000.0, 10000.0, 2, airFrance, 2);
		
		Passager p1 = new Passager("passager","1", date, "maroc", 12);
		Passager p2 = new Passager("passager","2", date, "tunisie", 12);
		Passager p3 = new Passager("passager","3", date, "allemagne", 12);
		Passager p4 = new Passager("passager","4", date, "france", 12);
		
		avionLigne1.addPassager(p1);
		avionLigne1.addPassager(p2);
		avionLigne1.addPassager(p3);
		avionLigne1.addPassager(p4);
		
		//test capacite == nb passager
		System.out.println("avion peut decoller ? " + avionLigne1.peutDecoller());
		
		//test passager en vol ou non
		System.out.println(p2.estEnVol());
		avionLigne1.removePassager(p2);
		System.out.println(p2.estEnVol());
		
		//test fonction clear avion
		System.out.println(p1.estEnVol());
		avionLigne1.clearAvion();
		System.out.println(p1.estEnVol());
		
	}

}
