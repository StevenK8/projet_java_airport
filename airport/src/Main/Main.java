package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Avions.Avion;
import Avions.AvionDiplomatique;
import Avions.AvionLigne;
import Avions.AvionPrive;
import Personnes.Passager;
import Personnes.Personnel;
import Personnes.Pilote;
import Pistes.PisteAtterissage;
import Pistes.PisteDecollage;
import Vols.Ville;
import Vols.Vol;

public class Main {
	
	
	/** 
	 * @param args
	 */
	public static void main(String[] args) {	
		//Creation de laeroport
		Aeroport aeroport = new Aeroport(Ville.Paris);
		
		//*********************************//
		//Definition des parametres initiaux
		Scanner sc = new Scanner(System.in);Random r = new Random();
		System.out.println("BIENVENUE DANS VOTRE NOUVEL AEROPORT \n");
		
		int nbPistesDecollage, nbPistesAterrissage;
		
		do {
			System.out.println("Combien de pistes de decollages avez-vous ? [1-5]\n");
			nbPistesDecollage = sc.nextInt();
		}while(nbPistesDecollage < 1 || nbPistesDecollage >5);
		aeroport.createPisteDecollage(nbPistesDecollage);
		System.out.println("> Creation de " + nbPistesDecollage + " pistes de decollage");
		
		do {
			System.out.println("Combien de pistes d'aterrissage avez-vous ? [1-5]\n");
			nbPistesAterrissage = sc.nextInt();
		}while(nbPistesAterrissage < 1 || nbPistesAterrissage > 5);
		aeroport.createPisteAtterissage(nbPistesAterrissage);
		System.out.println("> Creation de " + nbPistesAterrissage + " pistes d'aterrissage");
		
		//********************************//
		//Lancement de la boucle du jeu
		while(true) {
			int nbAvionsFromAnotherAirport = r.nextInt(4 - 1) + 1;
			aeroport.createAvions(nbAvionsFromAnotherAirport);
			ArrayList<Vol> listAvionsVoulantAtterir = aeroport.createAvionsEnVol(nbAvionsFromAnotherAirport);
			System.out.println("> " + nbAvionsFromAnotherAirport + " avions apparaissent dans votre radar !");
			for (Vol v : listAvionsVoulantAtterir) {
				aeroport.populateAvionEnVol(v.getAvion());
				PisteAtterissage piste = aeroport.getPisteAterrissageMoinsEncombre();
				piste.addToQueue(v);
			}
			
			
			int resume; int etatPiste;
			do {
				System.out.println("Voir etat des pistes ? (1)    Continuer jeu ? (2)");
				resume = sc.nextInt();
				
				if(resume == 1) {
					do {
						System.out.println("Voir pistes atterrissage ? (1)    Voir pistes decollage ? (2)    Retour (3)");
						etatPiste = sc.nextInt();
						if(etatPiste == 1) {
							for(int i = 0; i < aeroport.listPisteAtterissages.size(); i++) {
								System.out.println("Piste " + i + " : " + aeroport.listPisteAtterissages.get(i).afficheQueue() +"\n");
							}
						}
						if(etatPiste == 2) {
							for(int i = 0; i < aeroport.listPisteDecollages.size(); i++) {
								System.out.println("Piste " + i + " : " + aeroport.listPisteDecollages.get(i).afficheQueue() +"\n");
							}
						}
					}while(etatPiste != 3);
				}
			}while(resume != 2);
			
			for(PisteAtterissage piste : aeroport.listPisteAtterissages) {
				piste.atteritPiste();
			}

			for (PisteDecollage piste : aeroport.listPisteDecollages) {
				piste.decollePiste();
			}
			for(AvionLigne avion : aeroport.listAvionsLignes) {
				if(!avion.estEnVol()) {
					if(aeroport.preparationAvionLigne(avion)) {
						//preparationAvionLigne renvoie un booleen ET remplit lavion si cest possible
						Vol vol = aeroport.createVol(avion, false); //false car ce nest pas un avion provenant dun autre aeroport
						PisteDecollage piste = aeroport.getPisteDecollageMoinsEncombre();
						piste.addToQueue(vol);
					}
				}
			}
			for(AvionPrive avion : aeroport.listAvionsPrives) {
				if(!avion.estEnVol()) {
					if(aeroport.preparationAvionPrive(avion)) {
						//preparationAvionLigne renvoie un booleen ET remplit lavion si cest possible
						Vol vol = aeroport.createVol(avion, false); //false car ce nest pas un avion provenant dun autre aeroport
						PisteDecollage piste = aeroport.getPisteDecollageMoinsEncombre();
						piste.addToQueue(vol);
					}
				}
			}
			for(AvionDiplomatique avion : aeroport.listAvionsDiplomatiques) {
				if(!avion.estEnVol()) {
					if(aeroport.preparationAvionDiplomatique(avion)) {
						//preparationAvionLigne renvoie un booleen ET remplit lavion si cest possible
						Vol vol = aeroport.createVol(avion, false); //false car ce nest pas un avion provenant dun autre aeroport
						PisteDecollage piste = aeroport.getPisteDecollageMoinsEncombre();
						piste.addToQueue(vol);
					}
				}
			}
			int nbPersonnes = r.nextInt(500 - 50) + 50;
			aeroport.createPersonne(nbPersonnes);

			aeroport.diminueIntervallesDecollage();
			aeroport.diminueIntervallePilotes();
			aeroport.diminueCarburantAvionsEnVol();
			
			do {
				System.out.println("Actions Speciales (1)    Voir etat aeroport ? (2)    Voir avions en vol (3)    Prochain intervalle (4)    Quitter (5)");
				resume = sc.nextInt();
				
				if(resume == 1) {
					int choixActions;
					do {
						System.out.println("Ouverture Piste Atterrissage ? (1)   Fermeture Piste Atterrissage (2)   Ouverture Piste Decollage ? (3)   Fermeture Piste Decollage (4)   Annulation vol (5)   Retour (6)");
						choixActions = sc.nextInt();
						int choiceInt = -1;
						String strList = "[\n";
						if(choixActions == 1) { //Ouverture piste atterissage
							int i = 0;
							for (PisteAtterissage p : aeroport.getListPisteAtterissages()){
								if(!p.isOpened()){
									i++;
									strList += i + ". "+p.afficheQueue()+"\n";
								}	
							}
							strList += "]";
							if(i!=0){
								System.out.println("Veuillez choisir la piste d'atterissage a ouvrir [1-"+i+"] :\n");
								System.out.println(strList);
								System.out.print("> ");

								while(choiceInt<0 || choiceInt>=i)
									choiceInt = sc.nextInt()-1;
								aeroport.openPiste(aeroport.getListPisteAtterissages(true).get(choiceInt));
							}else{
								System.out.println("Il n'y a pas de piste d'atterissage a ouvrir.");
							}
						}
						else if (choixActions == 2) { // Fermeture piste atterissage
							int i = 0;
							for (PisteAtterissage p : aeroport.getListPisteAtterissages()){
								if(p.isOpened()){
									i++;	
									strList += i + ". "+p.afficheQueue()+"\n";
								}	
							}
							strList += "]";
							if(i!=0){
								System.out.println("Veuillez choisir la piste d'atterissage a fermer [1-"+i+"] :\n");
								System.out.println(strList);
								System.out.print("> ");
							
								while(choiceInt<0 || choiceInt>=i)
									choiceInt = sc.nextInt()-1;
								aeroport.closePiste(aeroport.getListPisteAtterissages(false).get(choiceInt));
							}else{
								System.out.println("Il n'y a pas de piste de d'atterissage a fermer.");
							}
						}
						
						else if(choixActions == 3) { // Ouverture piste decollage
							int i = 0;
							for (PisteDecollage p : aeroport.getListPisteDecollages()){
								if(!p.isOpened()){	
									i++;
									strList += i + ". "+p.afficheQueue()+"\n";
								}	
							}
							strList += "]";
							if(i!=0){
								System.out.println("Veuillez choisir la piste de decollage a ouvrir [1-"+i+"] :\n");
								System.out.println(strList);
								System.out.print("> ");

								while(choiceInt<0 || choiceInt>=i)
									choiceInt = sc.nextInt()-1;
								aeroport.openPiste(aeroport.getListPisteDecollages(true).get(choiceInt));
							}else{
								System.out.println("Il n'y a pas de piste de decollage à ouvrir.");
							}
						}
						
						else if(choixActions == 4) { // Fermeture piste decollage
							int i = 0;
							for (PisteDecollage p : aeroport.getListPisteDecollages()){
								if(p.isOpened()){
									i++;	
									strList += i + ". "+p.afficheQueue()+"\n";
								}	
							}
							strList += "]";
							if(i!=0){
								System.out.println("Veuillez choisir la piste de decollage a fermer [1-"+i+"] :\n");
								System.out.println(strList);
								System.out.print("> ");

								while(choiceInt<0 || choiceInt>=i)
									choiceInt = sc.nextInt()-1;
								aeroport.closePiste(aeroport.getListPisteDecollages(false).get(choiceInt));
							}else{
								System.out.println("Il n'y a pas de piste de decollage a fermer.");
							}
						}else if(choixActions == 5) {
							int i = 0;
							for (Vol v : listAvionsVoulantAtterir){
								i++;	
								strList += i + ". "+v.toString()+"\n";
							}
							strList += "]";
							if(i!=0){
								int volAnnule;
								System.out.println("Veuillez choisir le vol a annuler [1-"+listAvionsVoulantAtterir.size()+"] :\n");
								System.out.println(strList);
								System.out.print("> ");

								while(choiceInt<0 || choiceInt>=listAvionsVoulantAtterir.size())
									choiceInt = sc.nextInt()-1;
								volAnnule = choiceInt;
								choiceInt = 0;
								System.out.println("Voulez vous choisir manuellement une période d'immobilisation? Manuelle (1)   Aléatoire (2)");
								while(choiceInt<1 || choiceInt>2)
									choiceInt = sc.nextInt();
								if(choiceInt == 1){
									choiceInt = 0;
									System.out.println("Veuillez entrer la periode d'immobilisation desiree [1-5]");
									while(choiceInt<1 || choiceInt>5)
										choiceInt = sc.nextInt();
									aeroport.annuleVol(listAvionsVoulantAtterir.remove(volAnnule),choiceInt);
								}else if (choiceInt == 2){
									aeroport.annuleVol(listAvionsVoulantAtterir.remove(volAnnule));
								}	
							}else{
								System.out.println("Il n'y a pas de vol à annuler.");
							}
						}
						
					}while(choixActions != 6);
				}
				
				if(resume == 2) {
					int avionEnAttente = 0 ;
					
					for(Avion a : aeroport.listAvions) {
						if(!a.estEnVol()) {
							avionEnAttente += 1;
						}
					}
					
					System.out.println("PISTES ATTERRISSAGES");
					for(PisteAtterissage piste : aeroport.listPisteAtterissages) {
						if(piste.isOpened()) {
							System.out.println(piste.afficheQueue() + " [piste ouverte]");
						}
						else {
							System.out.println(piste.afficheQueue() + " [piste fermee]");
						}
					}
					System.out.println("PISTES DECOLLAGES");
					for(PisteDecollage piste : aeroport.listPisteDecollages) {
						if(piste.isOpened()) {
							System.out.println(piste.afficheQueue() + " [piste ouverte]");
						}
						else {
							System.out.println(piste.afficheQueue() + " [piste fermee]");
						}
					}
					
					System.out.println("Nombre de passagers en attente : " + aeroport.getPassagersDansAeroport());
					System.out.println("Nombre de pilotes en attente : " + aeroport.getPilotesDansAeroport());
					System.out.println("Nombre de personnels en attente : " + aeroport.getPersonnelsDansAeroport());
					System.out.println("Nombre d'avions en attente : " + avionEnAttente + "\n");
					
					int voirDetail;
					do {
						System.out.println("Voir details passagers (1)   Voir details avions (2)    Voir details pilotes (3)    Voir details personnels (4)    Retour (5)");
						voirDetail = sc.nextInt();
						
						if(voirDetail == 1) {
							for(Passager p : aeroport.listVoyageurs) {
								if(!p.estEnVol()) {
									System.out.println(p.toString());
								}
							}
						}
						else if (voirDetail == 2) {
							for(Avion a : aeroport.listAvions) {
								if(!a.estEnVol()) {
									System.out.println(a.toString());
								}
							}
						}
						else if( voirDetail == 3) {
							for(Pilote p : aeroport.listPilotes) {
								if(!p.estEnVol()) {
									System.out.println(p.toString());
								}
							}
						}
						else if(voirDetail == 4) {
							for(Personnel p : aeroport.listPersonnels) {
								if(!p.EstEnVol()) {
									System.out.println(p);
								}
							}
						}
					}while(voirDetail != 5);
					
				}
				else if (resume == 3) {
					int avionEnVol = 0;
					for(Avion a : aeroport.listAvions) {
						if(a.estEnVol()) {
							avionEnVol += 1;
							System.out.println(avionEnVol + "- " + a.toString());
						}
					}
				}else if (resume == 5){
					System.out.println("Au revoir!");
					sc.close();
					System.exit(0);
				}
			}while( resume != 4);
		}
		//sc.close();
	}

	
	/** 
	 * @param sc
	 * @return String
	 */
	public static String getChoice(Scanner sc) {
		System.out.print("\n> ");
		String choice = sc.nextLine();
		choice = choice.toLowerCase(); // Mise en minuscules
		choice = choice.replaceAll("[^A-Za-z- ]+", ""); // On ne garde que les lettres et '-'

		return choice;
	}
	
	
}
