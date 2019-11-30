package Main;

import Avions.Avion;
import Avions.AvionDiplomatique;
import Avions.AvionLigne;
import Avions.AvionPrive;
import CompagnieAerienne.Compagnie;
import Personnes.DateNaissance;
import Personnes.Passager;
import Personnes.Personne;
import Personnes.Personnel;
import Personnes.Pilote;;

public class Main {

	public static void main(String[] args) {
		
		DateNaissance date = new DateNaissance(1, 1, 1);
		Personne proprio = new Personne("prenom", "nom", date, "france");
		Compagnie airFrance = new Compagnie("AirFrance", "France");
		
		AvionPrive avionprive1 = new AvionPrive("airbus a380", 12, 12000.0, 10000.0, 2, proprio);
		
		AvionLigne avionLigne1 = new AvionLigne("airbus a320", 8, 12000.0, 10000.0, 2, airFrance, 2);
		
		Passager p1 = new Passager("passager","1", date, "Maroc", 12);
		Passager p2 = new Passager("passager","2", date, "Tunisie", 12);
		Passager p3 = new Passager("passager","3", date, "Allemagne", 12);
		Passager p4 = new Passager("passager","4", date, "France", 12);
		Passager p5 = new Pilote("pilote","1", date, "France", 12,6);//2 pilotes min
		Passager p6 = new Pilote("pilote","2", date, "France", 12,5);
		Passager p7 = new Personnel("personnel","1", date, "France", 12);//2 personnels min
		Passager p8 = new Personnel("personnel","2", date, "France", 12);
		
		avionLigne1.addPersonne(p1);//8 passagers max
		avionLigne1.addPersonne(p2);
		avionLigne1.addPersonne(p3);
		avionLigne1.addPersonne(p4);
		avionLigne1.addPersonne(p5);
		avionLigne1.addPersonne(p6);
		avionLigne1.addPersonne(p7);
		avionLigne1.addPersonne(p8);
		
		//test capacite == nb passager
		System.out.println("avion peut decoller ? " + avionLigne1.peutDecoller());
		
		//test passager en vol ou non
		System.out.println(p2.estEnVol());
		avionLigne1.removePersonne(p2);
		System.out.println(p2.estEnVol());
		
		//test fonction clear avion
		System.out.println(p1.estEnVol());
		avionLigne1.clearAvion();
		System.out.println(p1.estEnVol());
		
	}

}
