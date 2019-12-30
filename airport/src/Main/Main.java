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
import Personnes.Pilote;
import Pistes.PisteAtterissage;
import Vols.Vol;

public class Main {
	
	public static void main(String[] args) {				
		String france = "France";

		DateNaissance date = new DateNaissance(1, 1, 1);
		Personne proprio = new Personne("prenom", "nom", date, france);
		Compagnie airFrance = new Compagnie("AirFrance", france);
		
		AvionPrive avionprive1 = new AvionPrive("airbus a380", 12, 12000.0, 100.0, 2, proprio);
		
		AvionLigne avionLigne1 = new AvionLigne("airbus a320", 8, 12000.0, 10000.0, 2, airFrance, 2);
		Avion avionLigne2 = new AvionLigne("airbus a380", 3, 12000.0, 10000.0, 1, airFrance, 1);
		
		AvionDiplomatique avionDiplo = new AvionDiplomatique("AvionDiplomatique", 1, 1234, 12345, 1, france);
		
		
		//avionLigne1
		Passager p1 = new Passager("passager","1", date, "Maroc", 12);
		Passager p2 = new Passager("passager","2", date, "Tunisie", 12);
		//Passager p3 = new Passager("passager","3", date, "Allemagne", 12);
		Passager p4 = new Passager("passager","4", date, france, 12);
		Pilote p5 = new Pilote("pilote","1", date, france, 12, airFrance);//2 pilotes min
		Pilote p6 = new Pilote("pilote","2", date, france, 12, france);
		Personnel p7 = new Personnel("personnel","1", date, france, 12);//2 personnels min
		Personnel p8 = new Personnel("personnel","2", date, france, 12);
		
		//AvionLigne2
		Personnel personnel = new Personnel("personnel","3", date, france, 12);
		Passager passager = new Passager("passager","1", date, "Maroc", 12);
		Pilote pilote = new Pilote("pilote","1", date, france, 12, airFrance);
		
		//Diplomate d = new Diplomate("diplomate1", "nom", date, "Europe", 13);
		
		avionLigne1.addPersonne(p1);
		avionLigne1.addPersonne(p2);
		//avionLigne1.addPersonne(p3);
		avionLigne1.addPersonne(p4);
		avionLigne1.addPersonne(p5);
		avionLigne1.addPersonne(p6);
		avionLigne1.addPersonne(p7);
		avionLigne1.addPersonne(p8);
		
		avionLigne2.addPersonne(passager);
		avionLigne2.addPersonne(personnel);
		avionLigne2.addPersonne(pilote);
		
		avionDiplo.addPersonne(p5);
		
		Vol vol2 = new Vol(avionprive1, "Toulouse", "Paris");
		Vol vol1 = new Vol(avionLigne1, "Brasilia", "Paris");
		Vol vol3 = new Vol(avionDiplo, "Paris", "Toulouse");
		
		// PisteDecollage pisteDecollage = new PisteDecollage();
		PisteAtterissage pisteAtterissage = new PisteAtterissage();
		pisteAtterissage.addToQueue(vol1);
		pisteAtterissage.addToQueue(vol2);
		pisteAtterissage.addToQueue(vol3);
		
		pisteAtterissage.afficheQueue();
		
		pisteAtterissage.AtteritPiste();
		pisteAtterissage.afficheQueue();
		
		pisteAtterissage.AtteritPiste();
		pisteAtterissage.afficheQueue();

		System.out.println(avionLigne1.getlistPassagers());// Les pilotes de compagnies aériennes demeurent dans l’aéroport.
	}
}
