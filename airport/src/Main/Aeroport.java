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
	
	protected ArrayList<Avion> listAvions;
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
		listAvions = new ArrayList<Avion>();
		listAvionsLignes = new ArrayList<AvionLigne>();
		listAvionsDiplomatiques = new ArrayList<AvionDiplomatique>();
		listAvionsPrives = new ArrayList<AvionPrive>();
		listCompagnies= new ArrayList<Compagnie>();
		listPisteDecollages = new ArrayList<PisteDecollage>(); 
		listPisteAtterissages = new ArrayList<PisteAtterissage>();
	}
	
	//ajout des pilotes dans les avions qui viennent aterrir (uniquement les pilotes car les passagers et personnels seront supprimes de toute facon)
	public void createPilotesEnVol(Avion avion) {
		for(int i = 0; i < avion.getNbPiloteMin();i++) {
			EnumPrenom prenom = EnumPrenom.values()[new Random().nextInt(EnumPrenom.values().length)];
			EnumNom nom = EnumNom.values()[new Random().nextInt(EnumNom.values().length)];
			Pays nationalite = Pays.values()[new Random().nextInt(Pays.values().length)];
			Pilote p;
			if(avion.getType().equals("Avion de ligne")) {
				AvionLigne avionLigne = (AvionLigne) avion; //pour recuperer la compagnie de lavion de ligne et affecter la meme aux pilotes
				p = new Pilote(prenom, nom, new DateNaissance(), nationalite,avionLigne.getCompagnie());
			}
			else if(avion.getType().equals("Avion diplomatique")) {
				AvionDiplomatique avionDiplomatique = (AvionDiplomatique) avion;
				p = new Pilote(prenom, nom, new DateNaissance(), avionDiplomatique.getEtatProprietaire());
			}
			else {
				AvionPrive avionPrive = (AvionPrive) avion;//pour recuperer lemployeur de lavion de ligne et affecter le meme aux pilotes
				p = new Pilote(prenom, nom, new DateNaissance(), nationalite,avionPrive.getIdProprio());
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
		int nbPassagers = 0, nbPilotes = 0, nbPersonnels = 0, nbDiplomates = 0;
		for(int i = 0 ; i < nombrePersonne; i++) {
			EnumPrenom prenom = EnumPrenom.values()[new Random().nextInt(EnumPrenom.values().length)];
			EnumNom nom = EnumNom.values()[new Random().nextInt(EnumNom.values().length)];
			Pays nationalite = Pays.values()[new Random().nextInt(Pays.values().length)];
			EnumCompagnie c = EnumCompagnie.values()[new Random().nextInt(EnumCompagnie.values().length)];
			Compagnie compagnie = new Compagnie(c,c.getPaysFromCompagnie());
			
			int typeDePersonne = r.nextInt(25-1) + 1; // Definit le type de personne que l'on cree au hasard(passager, pilote, personnel ou diplomate)
			
			if(typeDePersonne <= 15) {
				//Passager normal
				boolean prendAvionPrive = false;
				if(typeDePersonne <= 3) {
					//1 chance sur 5 que ce passager prenne un avion prive
					prendAvionPrive = true;
				}
				Passager p = new Passager(prenom,nom,new DateNaissance(),nationalite,prendAvionPrive);
				p.setEstEnVol(false);
				listVoyageurs.add(p);
				nbPassagers +=1;
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
				p.setEstEnVol(false);
				listPilotes.add(p);
				nbPilotes += 1;
			}
			if(typeDePersonne > 17 && typeDePersonne < 25) {
				//Personnel
				Personnel p = new Personnel(prenom, nom, new DateNaissance(), nationalite, compagnie);
				p.setEstEnVol(false);
				listPersonnels.add(p);
				compagnie.addPersonnel(p);
				nbPersonnels += 1;
			}
			if(typeDePersonne == 25) {
				//Diplomate
				Diplomate d = new Diplomate(prenom, nom, new DateNaissance(), nationalite);
				d.setEstEnVol(false);
				listDiplomates.add(d);
				nbDiplomates += 1;
			}
		}
		System.out.println("> " + nombrePersonne + " personnes entrent dans votre aeroport");
		System.out.println("\t " + nbPassagers + " passagers " + nbPilotes + " pilotes " + nbPersonnels + " personnels " + nbDiplomates + " diplomates\n");
	}
	
	public void createAvions(int nombreAvions) {
		Random r = new Random();
		for(int i = 0 ; i < nombreAvions; i++) {
			int typeAvion = r.nextInt(20-1) + 1; 
			
			EnumModele modele = EnumModele.values()[new Random().nextInt(EnumModele.values().length)];
			int capacite = r.nextInt(100-10) + 10; 
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
				listAvions.add(avion);
				compagnie.addAvionDansFlotte(avion);
				avion.setEstEnVol(true);
			}
			else if (typeAvion > 15 && typeAvion < 18) {
				AvionPrive avion = new AvionPrive(modele, capacite, poidsBagageMax, volumeCarburant, nbPiloteMin, proprio1);
				listAvionsPrives.add(avion);
				listAvions.add(avion);
				avion.setEstEnVol(true);
			}
			else {
				AvionDiplomatique avion = new AvionDiplomatique(modele, capacite, poidsBagageMax, volumeCarburant, nbPiloteMin, nbPersonnel, etat);
				listAvionsDiplomatiques.add(avion);
				listAvions.add(avion);
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
				listAvions.add(avion);
				listAvionsLignes.add(avion);
			}
			else if (typeAvion > 15 && typeAvion < 18) {
				AvionPrive avion = new AvionPrive(modele, capacite, poidsBagageMax, volumeCarburant, nbPiloteMin, proprio1);
				avion.setEstEnVol(true);
				listAvionsEnVol.add(createVol(avion, true));
				listAvions.add(avion);
				listAvionsPrives.add(avion);
			}
			else {
				AvionDiplomatique avion = new AvionDiplomatique(modele, capacite, poidsBagageMax, volumeCarburant, nbPiloteMin, nbPersonnel, etat);
				avion.setEstEnVol(true);
				listAvionsEnVol.add(createVol(avion, true));
				listAvions.add(avion);
				listAvionsDiplomatiques.add(avion);
			}
		}
		return listAvionsEnVol;
	}

	public boolean openPiste(PisteDecollage piste){
		if(listPisteDecollages.contains(piste)){
			for (Piste p : listPisteDecollages){
				if(p.isOpened() && !p.equals(piste)){ // Une autre piste est ouverte
					piste.openPiste();
					System.out.println("> Ouverture piste de decollage");
					remplirPiste(piste);
					return true;
				}
			}
		}
		System.out.println("> La piste de decollage ne peut etre ouverte!");
		return false;
	}
	
	private void remplirPiste(PisteDecollage piste) {
		int size = 0;
		int nbPistesOuvertes = 0;
		for (Piste p : listPisteDecollages){
			if(p.isOpened()){
				nbPistesOuvertes++;
				size += p.getFileAttente().size();
			}
		}

		if(nbPistesOuvertes!=0)
			size = (size/nbPistesOuvertes)-1;
		else
			System.out.println("ERREUR : Aucune piste de décollage n'est ouverte!");

		while (size>0){
			for (Piste p : listPisteDecollages){
				if(p.isOpened()){
					if(size < 0)
						break;
					if(p.getFileAttente().size() != 0){
						piste.addToQueue(p.removeVol());
						size--;
					}
				}
			}
		}
	}

	public boolean closePiste(PisteDecollage piste) {
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
	

	public boolean openPiste(PisteAtterissage piste){
		if(listPisteAtterissages.contains(piste)){
			for (Piste p : listPisteAtterissages){
				if(p.isOpened() && !p.equals(piste)){ // Une autre piste est ouverte
					piste.openPiste();
					System.out.println("> Ouverture piste d'atterissage");
					remplirPiste(piste);
					return true;
				}
			}
		}
		System.out.println("> La piste d'atterissage ne peut être ouverte!");
		return false;
	}
	
	private void remplirPiste(PisteAtterissage piste) {
		int size = 0;
		int nbPistesOuvertes = 0;
		for (Piste p : listPisteAtterissages){
			if(p.isOpened()){
				nbPistesOuvertes++;
				size += p.getFileAttente().size();
			}
		}

		if(nbPistesOuvertes!=0)
			size = (size/nbPistesOuvertes)-1;
		else
			System.out.println("ERREUR : Aucune piste d'atterissage n'est ouverte!");

		while (size>0){
			for (Piste p : listPisteAtterissages){
				if(p.isOpened()){
					if(size < 0)
						break;
					if(p.getFileAttente().size() != 0){
						piste.addToQueue(p.removeVol());
						size--;
					}
				}
			}
		}
	}
	 
	 
	public void diminueIntervallePilotes() {
		for(Pilote p : listPilotes) {
			if(p.estEnPause()) {
				p.diminueIntervallePilote();
			}
		}
	}
	
	public void diminueIntervallesDecollage() {
		for(PisteDecollage piste : listPisteDecollages) {
			if(piste.isOpened()) {
				piste.diminueIntervalleDecollage();
			}
		}
	}
	
	public void diminueCarburantAvionsEnVol() {
		for(AvionLigne avion : listAvionsLignes) {
			if(avion.estEnVol()) {
				avion.diminueCarburant(avion.getVolumeCarburant() * 0.7);
			}
		}
		for(AvionPrive avion : listAvionsPrives) {
			if(avion.estEnVol()) {
				avion.diminueCarburant(avion.getVolumeCarburant() * 0.8);
			}
		}
		for(AvionLigne avion : listAvionsLignes) {
			if(avion.estEnVol()) {
				avion.diminueCarburant(avion.getVolumeCarburant() * 0.9);
			}
		}
	}
	
	
	protected boolean preparationAvionLigne(AvionLigne avion) {
		if(this.getPassagersDansAeroport() >= avion.getCapacite()) {
			if(this.getPilotesDansAeroport(/*avion.getCompagnie()*/) >= avion.getNbPiloteMin()) {
				if(this.getPersonnelsDansAeroport(/*avion.getCompagnie()*/) >= avion.getNbPersonnelsMin()) {
					avion.remplissageAvion(this);
					return true;
				}
				else {
					//System.out.println(avion + "ne pourra pas decoller car il manque du personnel\n");
					return false;
				}
			}
			else {
				//System.out.println(avion + "ne pourra pas decoller car il manque des pilotes\n");
				return false;
			}
		}
		else {
			//System.out.println(avion + "ne pourra pas decoller car la capacite maximum n'est pas atteinte\n");
			return false;
		}
	}
	
	protected boolean preparationAvionPrive(AvionPrive avion) {
		if( this.getPilotesDansAeroport(avion.getIdProprio()) >= avion.getNbPiloteMin()) {
			if(this.getPersonnelsDansAeroport() >= avion.getNbPersonnelsMin()) {
				avion.remplissageAvion(this);
				return true;
			}
			else {
				//System.out.println(avion + "ne pourra pas decoller car il manque du personnel");
				return false;
			}
		}
		else {
			//System.out.println(avion + "ne pourra pas decoller car il manque des pilotes");
			return false;
		}
	}
	
	protected boolean preparationAvionDiplomatique(AvionDiplomatique avion) {
		if(this.getPilotesDansAeroport(avion.getEtatProprietaire()) >= avion.getNbPiloteMin()) {
			if(this.getPersonnelsDansAeroport(avion.getEtatProprietaire()) >= avion.getNbPersonnelsMin()) {
				avion.remplissageAvion(this);
				return true;
			}
			else {
				//System.out.println(avion + "ne pourra pas decoller car il manque du personnel");
				return false;
			}
		}
		else {
			//System.out.println(avion + "ne pourra pas decoller car il manque des pilotes");
			return false;
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
