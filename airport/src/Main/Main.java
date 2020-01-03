package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Avions.Avion;
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
		
		//*********************************//
		//Définition des parametres initiaux
		Scanner sc = new Scanner(System.in);Random r = new Random();
		System.out.println("BIENVENUE DANS VOTRE NOUVEL AEROPORT \n");
		
		int nbAvionDepart, nbPersonneDepart, nbPistesDecollage, nbPistesAterrissage;
		//creation des avions
		do {
			System.out.println("Combien d'avions avez-vous actuellement dans votre aeroport ? [1-100]\n");
			nbAvionDepart = sc.nextInt();
		}while(nbAvionDepart < 1 || nbAvionDepart > 101);
		aeroport.createAvions(nbAvionDepart);
		
		System.out.println("> Creation de  " + aeroport.listAvionsLignes.size() + " avions de ligne");
		System.out.println("> Creation de  " + aeroport.listAvionsPrives.size() + " avions prives");
		System.out.println("> Creation de  " + aeroport.listAvionsDiplomatiques.size() + " avions diplomatique");
		
		//Creation des personnes
		do {
			System.out.println("Combien de personnes sont actuellement dans votre aeroport ? [10-2000]\n");
			nbPersonneDepart = sc.nextInt();
		}while(nbPersonneDepart < 10 || nbPersonneDepart > 2001);
		aeroport.createPersonne(nbPersonneDepart);
		
		System.out.println("> Creation de " + aeroport.listVoyageurs.size() + " passagers");
		int nbPiloteDiplo = 0;int nbPiloteAvionLigne = 0;int nbPilotePrive = 0;
		for (Pilote p : aeroport.listPilotes) {
			if(p.getCompagnie() != null) {
				nbPiloteAvionLigne += 1;
			}
			else if(p.getEmployeur() != null) {
				nbPilotePrive += 1;
			}
			else if(p.getCompagnie() == null && p.getEmployeur() == null){
				nbPiloteDiplo += 1;
			}
		}
		
		System.out.println("> Creation de " + nbPiloteAvionLigne + " pilotes de ligne");
		System.out.println("> Creation de " + nbPilotePrive + " pilotes prives");
		System.out.println("> Creation de " + nbPiloteDiplo + " pilotes diplomatique");
		System.out.println("> Creation de " + aeroport.listPersonnels.size() + " personnels navigants");
		
		do {
			System.out.println("Combien de pistes de decollages avez-vous ? [1-5]\n");
			nbPistesDecollage = sc.nextInt();
		}while(nbPistesDecollage < 1 || nbPistesDecollage > 6);
		aeroport.createPisteDecollage(nbPistesDecollage);
		System.out.println("> Creation de " + nbPistesDecollage + " pistes de decollage");
		
		do {
			System.out.println("Combien de pistes d'aterrissage avez-vous ? [1-5]\n");
			nbPistesAterrissage = sc.nextInt();
		}while(nbPistesAterrissage < 1 || nbPistesAterrissage > 6);
		aeroport.createPisteAtterissage(nbPistesAterrissage);
		System.out.println("> Creation de " + nbPistesAterrissage + " pistes d'aterrissage");
		
		
		//********************************//
		//Lancement de la boucle du jeu
		while(true) {
			int nbAvionsFromAnotherAirport = r.nextInt(4-1)+1;
			aeroport.createAvions(nbAvionsFromAnotherAirport);
			System.out.println("nb passagers avant" + aeroport.listVoyageurs.size());
			ArrayList<Vol> listAvionsVoulantAtterir = aeroport.createAvionsEnVol(nbAvionsFromAnotherAirport);
			System.out.println("> " + nbAvionsFromAnotherAirport + " avions apparaissent dans votre radar !");
			for(Vol v : listAvionsVoulantAtterir) {
				aeroport.createPilotesEnVol(v.getAvion());
				aeroport.listPisteAtterissages.get(0).addToQueue(v);
			}
			for(Vol v : listAvionsVoulantAtterir) {
				aeroport.listPisteAtterissages.get(0).atteritPiste();
			}
			System.out.println("nb passagers apres "+aeroport.listVoyageurs.size());
		}
		
	}
}
