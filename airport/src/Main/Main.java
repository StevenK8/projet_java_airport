package Main;

import Avions.AvionDiplomatique;
import Avions.AvionLigne;
import Avions.AvionPrive;
import Personnes.Pilote;
import Pistes.PisteAtterissage;
import Pistes.PisteDecollage;
import Vols.Ville;
import Vols.Vol;

public class Main {
	
	public static void main(String[] args) {	
		//Creation de laeroport
		Aeroport aeroport = new Aeroport(Ville.Paris);
		
		//Ouverture des pistes
		PisteDecollage pisteDecollage = aeroport.getListPisteDecollages().get(0);
		PisteDecollage pisteDecollage2 = aeroport.getListPisteDecollages().get(1);
		PisteDecollage pisteDecollage3 = aeroport.getListPisteDecollages().get(2);
		PisteAtterissage pisteAtterissage = aeroport.getListPisteAtterissages().get(0);
		
		
		aeroport.createAvions(20);
		aeroport.createPersonne(2000);
		
		System.out.println("nb avion de lignes : " + aeroport.listAvionsLignes.size());
		System.out.println("nb passagers crees : " + aeroport.listVoyageurs.size());
		int res = 0;
		for (Pilote p : aeroport.listPilotes) {
			if(p.getCompagnie() != null) {
				res += 1;
			}
		}
		System.out.println("nb pilotes avions de ligne crees : " + res);
		System.out.println("nb pilotes crees : " + aeroport.listPilotes.size());
		
	}
}
