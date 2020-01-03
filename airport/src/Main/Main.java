package Main;

import Avions.AvionDiplomatique;
import Avions.AvionLigne;
import Avions.AvionPrive;
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
		
		//Creation dun avion de ligne
		AvionLigne avionLigne1 = aeroport.getListAvionsLignes().get(0);
		AvionPrive avionPrive1 = aeroport.getListAvionsPrives().get(0);
		AvionDiplomatique avionDiplomatique1 = aeroport.getListAvionsDiplomatiques().get(0);
		
		
		
		
		//La preparation remplit les avions avant le decollage
		aeroport.preparationAvionPrive(avionPrive1);
		aeroport.preparationAvionDiplomatique(avionDiplomatique1);
		aeroport.preparationAvionLigne(avionLigne1);
		
		Vol vol = new Vol(avionLigne1,aeroport);
		Vol vol2 = new Vol(avionPrive1,aeroport);
		Vol vol3 = new Vol(avionDiplomatique1, aeroport);
		
		pisteDecollage.addToQueue(vol);
		pisteDecollage2.addToQueue(vol2);
		pisteDecollage3.addToQueue(vol3);
		aeroport.closePiste(pisteDecollage);

		System.out.println(pisteDecollage2.getFileAttente());
		System.out.println(pisteDecollage3.getFileAttente());
		
		/*while(pisteDecollage.getFileAttente().size() != 0) {
			while(!pisteDecollage.decollePiste()){
				pisteDecollage.diminueIntervalleDecollage();
			}
		}*/
		
		/*pisteAtterissage.addToQueue(vol);
		pisteAtterissage.atteritPiste();*/
		
		
		/*pisteAtterissage.addToQueue(vol2);
		//pisteAtterissage.addToQueue(vol3);
		aeroport.closePiste(pisteAtterissage);
		pisteAtterissage.atteritPiste();*/
		
		
		//pisteAtterissage.atteritPiste();
		
	}
}
