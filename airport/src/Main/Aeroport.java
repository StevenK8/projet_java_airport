package Main;

import java.util.ArrayList;
import java.util.Random;

import javax.management.ListenerNotFoundException;

import Avions.Avion;
import Avions.AvionDiplomatique;
import Avions.AvionLigne;
import Avions.AvionPrive;
import Avions.EnumModele;
import CompagnieAerienne.Compagnie;
import CompagnieAerienne.EnumCompagnie;
import Personnes.DateNaissance;
import Personnes.Diplomate;
import Personnes.EnumNom;
import Personnes.EnumPrenom;
import Personnes.Passager;
import Personnes.Pays;
import Personnes.Personne;
import Personnes.Personnel;
import Personnes.Pilote;
import Pistes.Piste;
import Pistes.PisteAtterissage;
import Pistes.PisteDecollage;
import Vols.Ville;
import Vols.Vol;

public class Aeroport {
	//class data
	
	protected ArrayList<Passager> listVoyageurs;
	protected ArrayList<Pilote> listPilotes;
	protected ArrayList<Personnel> listPersonnels;
	protected ArrayList<Diplomate> listDiplomates;
	protected ArrayList<Personne> listProprietaires;
	
	protected ArrayList<AvionLigne> listAvionsLignes;
	protected ArrayList<AvionDiplomatique> listAvionsDiplomatiques;
	protected ArrayList<AvionPrive> listAvionsPrives;
	
	protected ArrayList<Compagnie> listCompagnies;
	
	protected ArrayList<PisteDecollage> listPisteDecollages;
	protected ArrayList<PisteAtterissage> listPisteAtterissages;
	
	private Ville ville;
	
	
	Personne proprio1 = new Personne(EnumPrenom.values()[new Random().nextInt(EnumPrenom.values().length)],
			EnumNom.values()[new Random().nextInt(EnumNom.values().length)], new DateNaissance(), Pays.values()[new Random().nextInt(Pays.values().length)]);
	
	public Aeroport(Ville pVille) {
		ville = pVille;
		listVoyageurs = new ArrayList<Passager>();
		listPilotes = new ArrayList<Pilote>();
		listPersonnels = new ArrayList<Personnel>();
		listDiplomates = new ArrayList<Diplomate>();
		listProprietaires = new ArrayList<Personne>();
		listAvionsLignes = new ArrayList<AvionLigne>();
		listAvionsDiplomatiques = new ArrayList<AvionDiplomatique>();
		listAvionsPrives = new ArrayList<AvionPrive>();
		listCompagnies= new ArrayList<Compagnie>();
		listPisteDecollages = new ArrayList<PisteDecollage>(); 
		listPisteAtterissages = new ArrayList<PisteAtterissage>();
		
		listProprietaires.add(proprio1);
		
		//Piste
		PisteDecollage pisteDecollage1 = new PisteDecollage();
		PisteDecollage pisteDecollage2 = new PisteDecollage();
		PisteDecollage pisteDecollage3 = new PisteDecollage();
		PisteAtterissage pisteAtterissage1 = new PisteAtterissage(this);
		PisteAtterissage pisteAtterissage2 = new PisteAtterissage(this);
		
		listPisteAtterissages.add(pisteAtterissage1);
		listPisteAtterissages.add(pisteAtterissage2);
		

		listPisteDecollages.add(pisteDecollage1);
		listPisteDecollages.add(pisteDecollage2);
		listPisteDecollages.add(pisteDecollage3);
	}
	
	//ajout des pilotes dans les avions qui viennent aterrir (uniquement les pilotes car les passagers et personnels seront supprimes de toute facon)
	public void createPilotesEnVol(Avion avion) {
		for(int i = 0; i < avion.getNbPiloteMin();i++) {
			EnumPrenom prenom = EnumPrenom.values()[new Random().nextInt(EnumPrenom.values().length)];
			EnumNom nom = EnumNom.values()[new Random().nextInt(EnumNom.values().length)];
			Pays nationalite = Pays.values()[new Random().nextInt(Pays.values().length)];
			EnumCompagnie c = EnumCompagnie.values()[new Random().nextInt(EnumCompagnie.values().length)];
			Compagnie compagnie = new Compagnie(c,c.getPaysFromCompagnie());
			Pilote p;
			if(avion.getType().equals("Avion de ligne")) {
				p = new Pilote(prenom, nom, new DateNaissance(), nationalite,compagnie);
			}
			else if(avion.getType().equals("Avion diplomatique")) {
				p = new Pilote(prenom, nom, new DateNaissance(), nationalite);
			}
			else {
				p = new Pilote(prenom, nom, new DateNaissance(), nationalite,proprio1.getNomProprio());
			}
			avion.addPersonne(p);
			listPilotes.add(p);
			p.setEstEnVol(true);
		}
	}
	
	
	public void createPisteDecollage(int nbPiste) {
		for(int i = 0; i < nbPiste;i++) {
			listPisteDecollages.add(new PisteDecollage());
		}
	}
	
	public void createPisteAtterissage(int nbPiste) {
		for(int i = 0; i < nbPiste;i++) {
			listPisteAtterissages.add(new PisteAtterissage(this));
		}
	}
	
	public Vol createVol(Avion avion, boolean isFromAnotherAirport) {
		return new Vol(avion, this, isFromAnotherAirport);
	}

	public void createCompagnie(int nombreCompagnie) {
		for(int i = 0 ; i < nombreCompagnie; i++) {
			Compagnie c = new Compagnie(
					EnumCompagnie.values()[new Random().nextInt(EnumCompagnie.values().length)],
					Pays.values()[new Random().nextInt(Pays.values().length)]);
			listCompagnies.add(c);
		}
	}
	
	public void createPersonne(int nombrePersonne) {
		Random r = new Random();
		for(int i = 0 ; i < nombrePersonne; i++) {
			EnumPrenom prenom = EnumPrenom.values()[new Random().nextInt(EnumPrenom.values().length)];
			EnumNom nom = EnumNom.values()[new Random().nextInt(EnumNom.values().length)];
			Pays nationalite = Pays.values()[new Random().nextInt(Pays.values().length)];
			EnumCompagnie c = EnumCompagnie.values()[new Random().nextInt(EnumCompagnie.values().length)];
			Compagnie compagnie = new Compagnie(c,c.getPaysFromCompagnie());
			
			int typeDePersonne = r.nextInt(25-1) + 1; // D�finit le type de personne que l'on cr�� au hasard(passager, pilote, personnel ou diplomate)
			
			if(typeDePersonne <= 15) {
				//Passager normal
				boolean prendAvionPrive = false;
				if(typeDePersonne <= 3) {
					//1 chance sur 5 que ce passager prenne un avion prive
					prendAvionPrive = true;
				}
				Passager p = new Passager(prenom,nom,new DateNaissance(),nationalite,prendAvionPrive);
				listVoyageurs.add(p);
			}
			
			if(typeDePersonne == 17 || typeDePersonne == 16) {
				//Pilote
				Pilote p;
				int typeDePilote = r.nextInt(11-1)+1;
				if(typeDePilote <= 6) {
					//pilote de compagnie (avion de ligne)
					p = new Pilote(prenom, nom, new DateNaissance(),nationalite, compagnie);
					compagnie.addPilote(p);
				}
				else if ( typeDePilote > 7 && typeDePilote <= 9) {
					//Pilote d'avion prive
					p = new Pilote(prenom, nom, new DateNaissance(),nationalite, proprio1.getNomProprio());
				}
				else {
					p = new Pilote(prenom, nom, new DateNaissance(), nationalite);
				}
				listPilotes.add(p);
			}
			if(typeDePersonne > 17 && typeDePersonne < 25) {
				//Personnel
				Personnel p = new Personnel(prenom, nom, new DateNaissance(), nationalite, compagnie);
				listPersonnels.add(p);
				compagnie.addPersonnel(p);
			}
			if(typeDePersonne == 25) {
				//Diplomate
				Diplomate d = new Diplomate(prenom, nom, new DateNaissance(), nationalite);
				listDiplomates.add(d);
			}
		}
	}
	
	public void createAvions(int nombreAvions) {
		Random r = new Random();
		for(int i = 0 ; i < nombreAvions; i++) {
			int typeAvion = r.nextInt(20-1) + 1; 
			
			EnumModele modele = EnumModele.values()[new Random().nextInt(EnumModele.values().length)];
			int capacite = r.nextInt(300-10) + 10; 
			int poidsBagageMax = r.nextInt(3000-2000) + 2000;
			int volumeCarburant = r.nextInt(5000-2000) + 2000; 
			int nbPiloteMin = r.nextInt(3-1) + 1; 
			EnumCompagnie c = EnumCompagnie.values()[new Random().nextInt(EnumCompagnie.values().length)];
			Pays etat = Pays.values()[new Random().nextInt(Pays.values().length)];
			Compagnie compagnie = new Compagnie(c,c.getPaysFromCompagnie());
			int nbPersonnel = r.nextInt(15-5) + 5; 
			
			if(typeAvion <= 15) {
				AvionLigne avion = new AvionLigne(modele, capacite, poidsBagageMax, volumeCarburant, nbPiloteMin, compagnie, nbPersonnel);
				listAvionsLignes.add(avion);
				compagnie.addAvionDansFlotte(avion);
				avion.setEstEnVol(true);
			}
			else if (typeAvion > 15 && typeAvion < 18) {
				AvionPrive avion = new AvionPrive(modele, capacite, poidsBagageMax, volumeCarburant, nbPiloteMin, proprio1);
				listAvionsPrives.add(avion);
				avion.setEstEnVol(true);
			}
			else {
				AvionDiplomatique avion = new AvionDiplomatique(modele, capacite, poidsBagageMax, volumeCarburant, nbPiloteMin, nbPersonnel, etat);
				listAvionsDiplomatiques.add(avion);
				avion.setEstEnVol(true);
			}
		}
	}
	
	public ArrayList<Vol> createAvionsEnVol(int nombreAvions) {
		Random r = new Random();
		ArrayList<Vol> listAvionsEnVol = new ArrayList<>();
		for(int i = 0 ; i < nombreAvions; i++) {
			int typeAvion = r.nextInt(20-1) + 1; 
			
			EnumModele modele = EnumModele.values()[new Random().nextInt(EnumModele.values().length)];
			int capacite = r.nextInt(300-10) + 10; 
			int poidsBagageMax = r.nextInt(3000-2000) + 2000;
			int volumeCarburant = r.nextInt(5000-2000) + 2000; 
			int nbPiloteMin = r.nextInt(3-1) + 1; 
			EnumCompagnie c = EnumCompagnie.values()[new Random().nextInt(EnumCompagnie.values().length)];
			Pays etat = Pays.values()[new Random().nextInt(Pays.values().length)];
			Compagnie compagnie = new Compagnie(c,c.getPaysFromCompagnie());
			int nbPersonnel = r.nextInt(15-5) + 5; 
			
			if(typeAvion <= 15) {
				AvionLigne avion = new AvionLigne(modele, capacite, poidsBagageMax, volumeCarburant, nbPiloteMin, compagnie, nbPersonnel);
				avion.setEstEnVol(true);
				compagnie.addAvionDansFlotte(avion);
				listAvionsEnVol.add(createVol(avion, true));
			}
			else if (typeAvion > 15 && typeAvion < 18) {
				AvionPrive avion = new AvionPrive(modele, capacite, poidsBagageMax, volumeCarburant, nbPiloteMin, proprio1);
				avion.setEstEnVol(true);
				listAvionsEnVol.add(createVol(avion, true));
			}
			else {
				AvionDiplomatique avion = new AvionDiplomatique(modele, capacite, poidsBagageMax, volumeCarburant, nbPiloteMin, nbPersonnel, etat);
				avion.setEstEnVol(true);
				listAvionsEnVol.add(createVol(avion, true));
			}
		}
		return listAvionsEnVol;
	}
	
	public boolean closePiste(PisteDecollage piste){
		if(listPisteDecollages.contains(piste)){
			for (Piste p : listPisteDecollages){
				if(p.isOpened() && !p.equals(piste)){ // Une autre piste est ouverte
					System.out.println("> Fermeture piste de décollage");
					piste.closePiste();
					mergePiste(piste);
					return true;
				}
			}
		}
		System.out.println("> La piste de décollage ne peut être fermée!");
		return false; // Aucune piste n'est ouverte -> impossible de fermer la dernière / la piste à fermer n'est pas dans l'aéroport
	}

	private void mergePiste(PisteDecollage piste) {
		while (piste.getFileAttente().size() > 0){ // Tant que la piste contient des vols dans sa file d'attente
			for (PisteDecollage p : listPisteDecollages){
				if(p.isOpened()){ // Pour chaque piste ouverte
					if(piste.getFileAttente().size() > 0)
						p.addToQueue(piste.removeVol());
					else
						break;
				}
			}
		}
	}

	public boolean closePiste(PisteAtterissage piste){
		if(listPisteAtterissages.contains(piste)){
			for (Piste p : listPisteAtterissages){
				if(p.isOpened()){
					System.out.println("> Fermeture piste atterissage");
					piste.closePiste();
					mergePiste(piste);
					return true;
				}
			}
		}
		System.out.println("> La piste d'atterissage ne peut être fermée!");
		return false; // Aucune piste n'est ouverte -> impossible de fermer la dernière / la piste à fermer n'est pas dans l'aéroport
	}

	private void mergePiste(PisteAtterissage piste) {
		while (piste.getFileAttente().size() > 0){ // Tant que la piste contient des vols dans sa file d'attente
			for (PisteAtterissage p : listPisteAtterissages){
				if(p.isOpened()){ // Pour chaque piste ouverte
					if(piste.getFileAttente().size() > 0)
						p.addToQueue(piste.removeVol());
					else 
						break;
				}
			}
		}
	}
	
	/***************************[TODO]
	public boolean openPiste(PisteDecollage piste) {
		return false;
		
	}
	
	public boolean openPiste(PisteAtterissage piste) {
		return false;
		
	}
	/*********************************/
	 
	 
	public void diminueIntervallePilotes() {
		for(Pilote p : listPilotes) {
			if(p.estEnPause()) {
				p.setIntervallePilote(p.getIntervallePilote() - 1);
			}
		}
	}
	
	
	protected void preparationAvionLigne(AvionLigne avion) {
		if(this.getPassagersDansAeroport() >= avion.getCapacite()) {
			if( this.getPilotesDansAeroport(avion.getCompagnie()) >= avion.getNbPiloteMin()) {
				if(this.getPersonnelsDansAeroport(avion.getCompagnie()) >= avion.getNbPersonnelsMin()) {
					avion.remplissageAvion(this);
				}
				else {
					System.out.println(avion + "ne pourra pas decoller car il manque du personnel");
				}
			}
			else {
				System.out.println(avion + "ne pourra pas decoller car il manque des pilotes");
			}
		}
		else {
			System.out.println(avion + "ne pourra pas decoller car la capacit� maximum n'est pas atteinte");
		}
	}
	
	protected void preparationAvionPrive(AvionPrive avion) {
		if( this.getPilotesDansAeroport(avion.getIdProprio()) >= avion.getNbPiloteMin()) {
			if(this.getPersonnelsDansAeroport() >= avion.getNbPersonnelsMin()) {
				avion.remplissageAvion(this);
			}
			else {
				System.out.println(avion + "ne pourra pas decoller car il manque du personnel");
			}
		}
		else {
			System.out.println(avion + "ne pourra pas decoller car il manque des pilotes");
		}
	}
	
	protected void preparationAvionDiplomatique(AvionDiplomatique avion) {
		if(this.getPilotesDansAeroport(avion.getEtatProprietaire()) >= avion.getNbPiloteMin()) {
			if(this.getPersonnelsDansAeroport(avion.getEtatProprietaire()) >= avion.getNbPersonnelsMin()) {
				avion.remplissageAvion(this);
			}
			else {
				System.out.println(avion + "ne pourra pas decoller car il manque du personnel");
			}
		}
		else {
			System.out.println(avion + "ne pourra pas decoller car il manque des pilotes");
		}
	}
	
	public int getPassagersDansAeroport() {
		int res = 0;
		for(Passager p : listVoyageurs) {
			if (!p.estEnVol()) {
				res += 1;
			}
		}
		return res;
	}
	
	public int getPilotesDansAeroport() {
		int res = 0;
		for(Pilote p : listPilotes) {
			if (!p.estEnVol()) {
				res += 1;
			}
		}
		if(res == 0) {
			System.out.println("Plus de pilotes disponibles");
		}
		return res;
	}
	
	public int getPersonnelsDansAeroport() {
		int res = 0;
		for(Personnel p : listPersonnels) {
			if (!p.estEnVol()) {
				res += 1;
			}
		}
		return res;
	}
	
	//Pour les avions de ligne
	public int getPilotesDansAeroport(Compagnie c) {
		int res = 0;
		for(Pilote p : listPilotes) {
			if (!p.estEnVol() && p.getCompagnie() == c) {
				res += 1;
			}
		}
		return res;
	}
	
	public int getPersonnelsDansAeroport(Compagnie c) {
		int res = 0;
		for(Personnel p : listPersonnels) {
			if (!p.estEnVol() && p.getCompagnie() == c) {
				res += 1;
			}
		}
		return res;
	}
	
	//Pour avion prive
	public int getPilotesDansAeroport(String idProprio) {
		int res = 0;
		for(Pilote p : listPilotes) {
			if (!p.estEnVol() && p.getEmployeur() != null) {
				if(p.getEmployeur().equals(idProprio)) {
					//idProprio doit etre egale au nom+prenom du proprietaire de l'avion
					res += 1;
				}
			}
		}
		return res;
	}
	
	//Pour les avions Diplomatiques
	public int getPilotesDansAeroport(Pays pays) {
		int res = 0;
		for(Pilote p : listPilotes) {
			if (!p.estEnVol() && p.getNationalite() != null) {
				if(p.getNationalite().equals(pays)) {
					res += 1;
				}
			}
		}
		return res;
	}
	
	public int getPersonnelsDansAeroport(Pays pays) {
		int res = 0;
		for(Personnel p : listPersonnels) {
			if (!p.estEnVol()) {
				if(p.getNationalite().equals(pays)) {
					res += 1;
				}
			}
		}
		return res;
	}

	//Getters basiques
	public ArrayList<Passager> getListVoyageurs() {
		return listVoyageurs;
	}



	public ArrayList<Pilote> getListPilotes() {
		return listPilotes;
	}



	public ArrayList<Personnel> getListPersonnels() {
		return listPersonnels;
	}



	public ArrayList<Diplomate> getListDiplomates() {
		return listDiplomates;
	}



	public ArrayList<Personne> getListProprietaires() {
		return listProprietaires;
	}



	public ArrayList<AvionLigne> getListAvionsLignes() {
		return listAvionsLignes;
	}



	public ArrayList<AvionDiplomatique> getListAvionsDiplomatiques() {
		return listAvionsDiplomatiques;
	}



	public ArrayList<AvionPrive> getListAvionsPrives() {
		return listAvionsPrives;
	}



	public ArrayList<Compagnie> getListCompagnies() {
		return listCompagnies;
	}



	public ArrayList<PisteDecollage> getListPisteDecollages() {
		return listPisteDecollages;
	}

	public ArrayList<PisteAtterissage> getListPisteAtterissages() {
		return listPisteAtterissages;
	}
	
	public Ville getVille() {
		return ville;
	}
}
