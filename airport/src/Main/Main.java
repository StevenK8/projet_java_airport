package Main;

import Avions.Avion;
import Avions.AvionDiplomatique;
import Avions.AvionLigne;
import Avions.AvionPrive;
import CompagnieAerienne.Compagnie;
import Personnes.DateNaissance;
import Personnes.Diplomate;
import Personnes.Passager;
import Personnes.Personne;
import Personnes.Personnel;
import Personnes.Pilote;

public class Main {

	public static void main(String[] args) {
		
		DateNaissance date = new DateNaissance(1, 1, 1);
		Personne proprio = new Personne("prenom", "nom", date, "france");
		Compagnie airFrance = new Compagnie("AirFrance", "France");
		
		AvionPrive avionprive1 = new AvionPrive("airbus a380", 12, 12000.0, 10000.0, 2, proprio);
		
		AvionLigne avionLigne1 = new AvionLigne("airbus a320", 8, 12000.0, 10000.0, 2, airFrance, 2);
		AvionDiplomatique avionDiplo = new AvionDiplomatique("AvionDiplomatique", 100, 1234, 12345, 1, "France");
		
		Passager p1 = new Passager("passager","1", date, "Maroc", 12);
		Passager p2 = new Passager("passager","2", date, "Tunisie", 12);
		Passager p3 = new Passager("passager","3", date, "Allemagne", 12);
		Passager p4 = new Passager("passager","4", date, "France", 12);
		Pilote p5 = new Pilote("pilote","1", date, "France", 12);//2 pilotes min
		Pilote p6 = new Pilote("pilote","2", date, "France", 12);
		Personnel p7 = new Personnel("personnel","1", date, "France", 12);//2 personnels min
		Personnel p8 = new Personnel("personnel","2", date, "France", 12);
		Diplomate d = new Diplomate("diplomate1", "nom", date, "Europe", 13);
		
		avionLigne1.addPersonne(p1);
		avionLigne1.addPersonne(p2);
		avionLigne1.addPersonne(p3);
		avionLigne1.addPersonne(p4);
		avionLigne1.addPersonne(p5);
		avionLigne1.addPersonne(p6);
		avionLigne1.addPersonne(p7);
		avionLigne1.addPersonne(p8);
		
		
		
		
	}

}
