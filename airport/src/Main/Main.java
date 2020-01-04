package Main;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public static void main(String[] args) {	
		//Creation de laeroport
		Aeroport aeroport = new Aeroport(Ville.Paris);
		
		//*********************************//
		//Definition des parametres initiaux
		Scanner sc = new Scanner(System.in);Random r = new Random();
		System.out.println("BIENVENUE DANS VOTRE NOUVEL AEROPORT \n");
		
		int nbAvionDepart, nbPersonneDepart, nbPistesDecollage, nbPistesAterrissage;
		//creation des avions
		/*do {
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
		System.out.println("> Creation de " + aeroport.listPersonnels.size() + " personnels navigants");*/
		
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
		
		String choice = "help";
		int choiceInt;
		boolean aChoisi;
		int i=1;
		String strList;
		System.out.println("\n---[AIDE]---\nhelp: \tAfficher l'aide\nq : \tQuitter le programme\nclose : \tFermer une piste [-d / -a]\nopen : \tOuvrir une piste [-d / -a]\nAppuyez sur entrée pour passer cet intervalle.\n");
		choice = getChoice(sc);
		//********************************//
		//Lancement de la boucle du jeu
		while(choice!="q") {
			aChoisi = false;
			choiceInt = -1;
			while(!aChoisi){
				i = 0;
				strList = "";
				choice = getChoice(sc);
				switch (choice){
					case "help":
						System.out.println("\n---[AIDE]---\nhelp: \tAfficher cette aide\nq : \tQuitter le programme\nclose : \tFermer une piste [-d / -a]\nopen : \tOuvrir une piste [-d / -a]\nAppuyez sur entrée pour passer cet intervalle.\n");
						break;

					case "open":
						System.out.println("open -d : \tOuvrir un piste de décollage\nopen -a : \tOuvrir une piste d'atterissage\n");
						break;
					case "open -d":
						strList += "[\n";
						for (PisteDecollage p : aeroport.getListPisteDecollages()){
							if(!p.isOpened()){	
								i++;
								strList += i + ". "+p.afficheQueue()+"\n";
							}	
						}
						strList += "]";
						if(i!=0){
							System.out.println("Veuillez choisir la piste de décollage à ouvrir [1-"+aeroport.getListPisteDecollages().size()+"] :\n");
							System.out.println(strList);
							System.out.print("> ");

							while(choiceInt<0 || choiceInt>=aeroport.getListPisteDecollages().size())
								choiceInt = sc.nextInt()-1;
							if(aeroport.openPiste(aeroport.getListPisteDecollages().get(choiceInt)))
								aChoisi = true;
						}else{
							System.out.println("Il n'y a pas de piste de décollage à ouvrir.");
						}
						break;
					case "open -a":
						strList += "[\n";
						for (PisteAtterissage p : aeroport.getListPisteAtterissages()){
							if(!p.isOpened()){
								i++;
								strList += i + ". "+p.afficheQueue()+"\n";
							}	
						}
						strList += "]";
						if(i!=0){
							System.out.println("Veuillez choisir la piste d'atterissage à ouvrir [1-"+aeroport.getListPisteAtterissages().size()+"] :\n");
							System.out.println(strList);
							System.out.print("> ");

							while(choiceInt<0 || choiceInt>=aeroport.getListPisteAtterissages().size())
								choiceInt = sc.nextInt()-1;
							if(aeroport.openPiste(aeroport.getListPisteAtterissages().get(choiceInt)))
								aChoisi = true;
						}else{
							System.out.println("Il n'y a pas de piste d'atterissage à ouvrir.");
						}
						break;

					case "close":
						System.out.println("close -d : \tFermer un piste de décollage\nclose -a : \tFermer une piste d'atterissage\n");
						break;
					case "close -d":
						strList += "[\n";
						for (PisteDecollage p : aeroport.getListPisteDecollages()){
							if(p.isOpened()){
								i++;	
								strList += i + ". "+p.afficheQueue()+"\n";
							}	
						}
						strList += "]";
						if(i!=0){
							System.out.println("Veuillez choisir la piste de décollage à fermer [1-"+aeroport.getListPisteDecollages().size()+"] :\n");
							System.out.println(strList);
							System.out.print("> ");

							while(choiceInt<0 || choiceInt>=aeroport.getListPisteDecollages().size())
								choiceInt = sc.nextInt()-1;
							if(aeroport.closePiste(aeroport.getListPisteDecollages().get(choiceInt)))
								aChoisi = true;
						}else{
							System.out.println("Il n'y a pas de piste de décollage à fermer.");
						}
						break;
					case "close -a":
						strList += "[\n";
						for (PisteAtterissage p : aeroport.getListPisteAtterissages()){
							if(p.isOpened()){
								i++;	
								strList += i + ". "+p.afficheQueue()+"\n";
							}	
						}
						strList += "]";
						if(i!=0){
							System.out.println("Veuillez choisir la piste d'atterissage à fermer [1-"+aeroport.getListPisteAtterissages().size()+"] :\n");
							System.out.println(strList);
							System.out.print("> ");
						
							while(choiceInt<0 || choiceInt>=aeroport.getListPisteAtterissages().size())
								choiceInt = sc.nextInt()-1;
							if(aeroport.closePiste(aeroport.getListPisteAtterissages().get(choiceInt)))
								aChoisi = true;
						}else{
							System.out.println("Il n'y a pas de piste de d'atterissage à fermer.");
						}
						break;
					
					case " ":
						aChoisi = true;
						break;
					case "":
						aChoisi = true;
						break;
					
					case "q":
						System.out.println("Au revoir!\n");
						System.exit(0);
						break;

					default:
						System.out.println("'"+choice+"'" + " n'est pas un terme ou une commande reconnue.\nEntrez 'help' pour la liste de commandes.\n");
						break;
				}
			}

			int nbAvionsFromAnotherAirport = r.nextInt(4 - 1) + 1;
			aeroport.createAvions(nbAvionsFromAnotherAirport);
			ArrayList<Vol> listAvionsVoulantAtterir = aeroport.createAvionsEnVol(nbAvionsFromAnotherAirport);
			System.out.println("> " + nbAvionsFromAnotherAirport + " avions apparaissent dans votre radar !");
			for (Vol v : listAvionsVoulantAtterir) {
				aeroport.createPilotesEnVol(v.getAvion());
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
							for(i = 0; i < aeroport.listPisteAtterissages.size(); i++) {
								System.out.println("Piste " + i + " : " + aeroport.listPisteAtterissages.get(i).afficheQueue() +"\n");
							}
						}
						if(etatPiste == 2) {
							for(i = 0; i < aeroport.listPisteDecollages.size(); i++) {
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
				System.out.println("Voir etat aeroport ? (1)    Voir avions en vol (2)    Prochain intervalle (3)");
				resume = sc.nextInt();
				
				if(resume == 1) {
					int avionEnAttente = 0 ;
					
					for(Avion a : aeroport.listAvions) {
						if(!a.estEnVol()) {
							avionEnAttente += 1;
						}
					}
					
					System.out.println("Nombre de passagers en attente : " + aeroport.getPassagersDansAeroport());
					System.out.println("Nombre de pilotes en attente : " + aeroport.getPilotesDansAeroport());
					System.out.println("Nombre de personnels en attente : " + aeroport.getPersonnelsDansAeroport());
					System.out.println("Nombre d'avions en attente : " + avionEnAttente + "\n");
					
					int voirDetail;
					do {
						System.out.println("Voir d�tails passagers (1)    Voir d�tails avions (2)    Voir d�tails pilotes (3)    Voir d�tails personnels (4)    Retour (5)");
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
				else if (resume == 2) {
					int avionEnVol = 0;
					for(Avion a : aeroport.listAvions) {
						if(a.estEnVol()) {
							avionEnVol += 1;
							System.out.println(avionEnVol + "- " + a.toString());
						}
					}
				}
			}while( resume != 3);
		}
		sc.close();
	}

	public static String getChoice(Scanner sc) {
		System.out.print("\n> ");
		String choice = sc.nextLine();
		choice = choice.toLowerCase(); // Mise en minuscules
		choice = choice.replaceAll("[^A-Za-z- ]+", ""); // On ne garde que les lettres et '-'

		return choice;
	}
	
	
}
