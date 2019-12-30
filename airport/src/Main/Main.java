package Main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.ListView;

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
import Pistes.PisteDecollage;
import Vols.Vol;

public class Main {
	
	public static void main(String[] args) {				
		//Cration de laeroport
		Aeroport aeroport = new Aeroport();
		
		//Ouverture des pistes
		PisteDecollage pisteDecollage = aeroport.getListPisteDecollages().get(0);
		PisteAtterissage pisteAtterissage = aeroport.getListPisteAtterissages().get(0);
		
		//Creation dun avion de ligne
		AvionLigne avionLigne1 = aeroport.getListAvionsLignes().get(0);
		
		//Creation dun vol
		Vol vol = new Vol(avionLigne1, "Paris", "Marseille");
		
		//Remplissage dun avion de ligne (avec les bons nb de passagers,pilotes et personnels)
		avionLigne1.remplissageAvion(aeroport);
		
		pisteAtterissage.addToQueue(vol);
	}
}
