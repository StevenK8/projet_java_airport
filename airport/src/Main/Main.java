package Main;

import Avions.AvionLigne;
import Avions.AvionPrive;
import Pistes.PisteAtterissage;
import Pistes.PisteDecollage;
import Vols.Vol;

public class Main {
	
	public static void main(String[] args) {	
		//Creation de laeroport
		Aeroport aeroport = new Aeroport();
		
		//Ouverture des pistes
		PisteDecollage pisteDecollage = aeroport.getListPisteDecollages().get(0);
		PisteAtterissage pisteAtterissage = aeroport.getListPisteAtterissages().get(0);
		
		//Creation dun avion de ligne
		AvionLigne avionLigne1 = aeroport.getListAvionsLignes().get(0);
		AvionPrive avionPrive1 = aeroport.getListAvionsPrives().get(0);
		
		aeroport.preparationAvionLigne(avionLigne1, pisteDecollage);
		aeroport.preparationAvionPrive(avionPrive1, pisteDecollage);
	
	}
}
