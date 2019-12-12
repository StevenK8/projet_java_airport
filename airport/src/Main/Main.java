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
import Pistes.Piste;
import Vols.Vol;

public class Main {
	
	public static void main(String[] args) {
		long temps = System.currentTimeMillis();
		int intervalleEnSecondes = 2;
		
		DateNaissance date = new DateNaissance(1, 1, 1);
		Personne proprio = new Personne("prenom", "nom", date, "france");
		Compagnie airFrance = new Compagnie("AirFrance", "France");
		
		AvionPrive avionprive1 = new AvionPrive("airbus a380", 12, 12000.0, 10000.0, 2, proprio);
		
		AvionLigne avionLigne1 = new AvionLigne("airbus a320", 8, 12000.0, 10000.0, 2, airFrance, 2);
		AvionLigne avionLigne2 = new AvionLigne("airbus a380", 3, 12000.0, 10000.0, 1, airFrance, 1);
		
		AvionDiplomatique avionDiplo = new AvionDiplomatique("AvionDiplomatique", 100, 1234, 12345, 1, "France");
		
		//avionLigne1
		Passager p1 = new Passager("passager","1", date, "Maroc", 12);
		Passager p2 = new Passager("passager","2", date, "Tunisie", 12);
		Passager p3 = new Passager("passager","3", date, "Allemagne", 12);
		Passager p4 = new Passager("passager","4", date, "France", 12);
		Pilote p5 = new Pilote("pilote","1", date, "France", 12);//2 pilotes min
		Pilote p6 = new Pilote("pilote","2", date, "France", 12);
		Personnel p7 = new Personnel("personnel","1", date, "France", 12);//2 personnels min
		Personnel p8 = new Personnel("personnel","2", date, "France", 12);
		
		//AvionLigne2
		Personnel personnel = new Personnel("personnel","3", date, "France", 12);
		Passager passager = new Passager("passager","1", date, "Maroc", 12);
		Pilote pilote = new Pilote("pilote","1", date, "France", 12);
		
		Diplomate d = new Diplomate("diplomate1", "nom", date, "Europe", 13);
		
		avionLigne1.addPersonne(p1);
		avionLigne1.addPersonne(p2);
		avionLigne1.addPersonne(p3);
		avionLigne1.addPersonne(p4);
		avionLigne1.addPersonne(p5);
		avionLigne1.addPersonne(p6);
		avionLigne1.addPersonne(p7);
		avionLigne1.addPersonne(p8);
		
		avionLigne2.addPersonne(passager);
		avionLigne2.addPersonne(personnel);
		avionLigne2.addPersonne(pilote);
		
		
		Vol vol1 = new Vol(avionLigne1, "Brasilia", "Paris");
		Vol vol2 = new Vol(avionLigne2, "Toulouse", "Paris");
		
		Piste pisteDecollage = new Piste(true);
		Piste pisteAtterissage = new Piste(false);
		pisteDecollage.addToQueue(vol1);
		pisteDecollage.addToQueue(vol2);
		
		//faire décoller avec 2 secondes d'intervalle
		while(pisteDecollage.getQueue().size() > 0) {
			if(temps + 1000 * intervalleEnSecondes < System.currentTimeMillis()) {
				pisteDecollage.acceptFlight();
				temps = System.currentTimeMillis();
			}
		}
	}
}
