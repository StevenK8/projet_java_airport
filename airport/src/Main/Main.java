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
import Vols.Vol;

public class Main {
	
	public static void main(String[] args) {				
		
		Aeroport aeroport = new Aeroport();


		DateNaissance date = new DateNaissance(1, 1, 1);
		
		AvionLigne avionLigne1 = aeroport.getListAvionsLignes().get(0);
		
		for (Passager p : aeroport.getListVoyageurs()) {
			avionLigne1.addPersonne(p);
		}
	}
}
