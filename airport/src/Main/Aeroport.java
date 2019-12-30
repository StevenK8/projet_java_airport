package Main;

import java.awt.Frame;
import java.util.ArrayList;

import javax.management.ListenerNotFoundException;

import Avions.Avion;
import Avions.AvionDiplomatique;
import Avions.AvionLigne;
import Avions.AvionPrive;
import CompagnieAerienne.Compagnie;
import Personnes.DateNaissance;
import Personnes.Diplomate;
import Personnes.Passager;
import Personnes.Pays;
import Personnes.Personne;
import Personnes.Personnel;
import Personnes.Pilote;
import Pistes.PisteAtterissage;
import Pistes.PisteDecollage;
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
	
	public Aeroport() {
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
		
		DateNaissance date = new DateNaissance(1, 1, 1);
		
		//Proprietaires davion prive
		Personne proprio1 = new Personne("Jean", "azerty", date, Pays.AfriqueduSud);
		Personne proprio2 = new Personne("Daniel", "lala", date, Pays.France);
		Personne proprio3 = new Personne("toto", "kerv", date, Pays.Allemagne);
		Personne proprio4 = new Personne("tata", "lalzlel", date, Pays.Espagne);
		Personne proprio5 = new Personne("titi", "momomo", date, Pays.Australie);
		
		listProprietaires.add(proprio1);
		listProprietaires.add(proprio2);
		listProprietaires.add(proprio3);
		listProprietaires.add(proprio4);
		listProprietaires.add(proprio5);
		
		
		//Compagnie aerienne
		Compagnie airFrance = new Compagnie("AirFrance",Pays.France );
		Compagnie easyJet = new Compagnie("EasyJet", Pays.France);
		Compagnie airTunisia = new Compagnie("AirTunisia", Pays.Tunisie);
		Compagnie airAustralia = new Compagnie("airAustralia", Pays.Australie);
		
		listCompagnies.add(airFrance);
		listCompagnies.add(easyJet);
		listCompagnies.add(airTunisia);
		listCompagnies.add(airAustralia);
		
		//AvionPrive
		AvionPrive avionprive1 = new AvionPrive("airbus a380", 1, 12000.0, 100.0, 2, proprio1);
		AvionPrive avionprive2 = new AvionPrive("airbus a370", 2, 12000.0, 1000.0, 2, proprio2);
		AvionPrive avionprive3 = new AvionPrive("airbus a360", 3, 12000.0, 1000.0, 2, proprio3);
		AvionPrive avionprive4 = new AvionPrive("airbus a350", 4, 12000.0, 10000.0, 2, proprio4);
		AvionPrive avionprive5 = new AvionPrive("airbus a340", 5, 12000.0, 10000.0, 2, proprio5);
		
		listAvionsPrives.add(avionprive1);
		listAvionsPrives.add(avionprive2);
		listAvionsPrives.add(avionprive3);
		listAvionsPrives.add(avionprive4);
		listAvionsPrives.add(avionprive5);
		
		//AvionLigne
		AvionLigne avionLigne1 = new AvionLigne("airbus a320", 3, 12000.0, 10000.0, 2, airFrance, 2);
		AvionLigne avionLigne2 = new AvionLigne("airbus a330", 7, 12000.0, 10000.0, 1, easyJet, 1);
		AvionLigne avionLigne3 = new AvionLigne("airbus a340", 6, 12000.0, 1000.0, 2, airTunisia, 2);
		AvionLigne avionLigne4 = new AvionLigne("airbus a350", 5, 12000.0, 1000.0, 1, airAustralia, 1);
		AvionLigne avionLigne5 = new AvionLigne("airbus a360", 4, 12000.0, 100.0, 1, airFrance, 1);
		
		listAvionsLignes.add(avionLigne1);
		listAvionsLignes.add(avionLigne2);
		listAvionsLignes.add(avionLigne3);
		listAvionsLignes.add(avionLigne4);
		listAvionsLignes.add(avionLigne5);
		
		airFrance.addAvionDansFlotte(avionLigne1);
		airFrance.addAvionDansFlotte(avionLigne2);
		airFrance.addAvionDansFlotte(avionLigne3);
		airFrance.addAvionDansFlotte(avionLigne4);
		airFrance.addAvionDansFlotte(avionLigne5);
		
		
		//AvionDiplomatique
		AvionDiplomatique avionDiplo1 = new AvionDiplomatique("airbus a300", 3, 10000, 10000, 1,0,"France");
		AvionDiplomatique avionDiplo2 = new AvionDiplomatique("airbus a310", 3, 10000, 10000, 1,0, "USA");
		AvionDiplomatique avionDiplo3 = new AvionDiplomatique("airbus a320", 2, 10000, 1000, 1,0, "Angleterre");
		AvionDiplomatique avionDiplo4 = new AvionDiplomatique("airbus a330", 2, 10000, 1000, 1,0, "Espagne");
		AvionDiplomatique avionDiplo5 = new AvionDiplomatique("airbus a340", 2, 10000, 100, 1, 0,"Turquie");
		
		listAvionsDiplomatiques.add(avionDiplo1);
		listAvionsDiplomatiques.add(avionDiplo2);
		listAvionsDiplomatiques.add(avionDiplo3);
		listAvionsDiplomatiques.add(avionDiplo4);
		listAvionsDiplomatiques.add(avionDiplo5);
		
		//passagers
		Passager p1 = new Passager("passager","1", date, Pays.AfriqueduSud, 1);
		Passager p2 = new Passager("passager","2", date, Pays.Albanie, 2);
		Passager p3 = new Passager("passager","3", date,Pays.Algérie , 3);
		Passager p4 = new Passager("passager","4", date, Pays.Andorre, 4);
		Passager p5 = new Passager("passager","5", date, Pays.BosnieHerzégovine, 5);
		Passager p6 = new Passager("passager","6", date, Pays.Argentine, 6);
		Passager p7 = new Passager("passager","7", date, Pays.Soudan, 7);
		Passager p8 = new Passager("passager","8", date, Pays.Finlande, 8);
		Passager p9 = new Passager("passager","9", date, Pays.Autriche, 9);
		Passager p10 = new Passager("passager","10", date, Pays.France, 10);
		Passager p11 = new Passager("passager","11", date, Pays.Roumanie, 11);
		Passager p12 = new Passager("passager","12", date, Pays.Lesotho, 12);
		Passager p13 = new Passager("passager","13", date, Pays.Jamaïque, 13);
		Passager p14 = new Passager("passager","14", date, Pays.Fidji, 14);
		Passager p15 = new Passager("passager","15", date, Pays.Hongrie, 15);
		Passager p16 = new Passager("passager","16", date, Pays.Venezuela, 16);
		Passager p17 = new Passager("passager","17", date, Pays.Bahamas, 17);
		Passager p18 = new Passager("passager","18", date, Pays.Gabon, 18);
		Passager p19 = new Passager("passager","19", date, Pays.Mali, 19);
		Passager p20 = new Passager("passager","20", date, Pays.Chili, 20);
		
		listVoyageurs.add(p1);
		listVoyageurs.add(p2);
		listVoyageurs.add(p3);
		listVoyageurs.add(p4);
		listVoyageurs.add(p5);
		listVoyageurs.add(p6);
		listVoyageurs.add(p7);
		listVoyageurs.add(p8);
		listVoyageurs.add(p9);
		listVoyageurs.add(p10);
		listVoyageurs.add(p11);
		listVoyageurs.add(p12);
		listVoyageurs.add(p13);
		listVoyageurs.add(p14);
		listVoyageurs.add(p15);
		listVoyageurs.add(p16);
		listVoyageurs.add(p17);
		listVoyageurs.add(p18);
		listVoyageurs.add(p19);
		listVoyageurs.add(p20);
		
		//Pilotes
		Pilote pilote1 = new Pilote("pilote","1", date, Pays.France, 12,airFrance);
		Pilote pilote2 = new Pilote("pilote","2", date, Pays.France, 12,easyJet);
		Pilote pilote3 = new Pilote("pilote","3", date, Pays.France, 12,airTunisia);
		Pilote pilote4 = new Pilote("pilote","4", date, Pays.France, 12,airAustralia);
		Pilote pilote5 = new Pilote("pilote","5", date, Pays.France, 12,proprio1.getNomProprio());
		Pilote pilote6 = new Pilote("pilote","6", date, Pays.France, 12,proprio2.getNomProprio());
		Pilote pilote7 = new Pilote("pilote","7", date, Pays.France, 12,proprio3.getNomProprio());
		Pilote pilote8 = new Pilote("pilote","8", date, Pays.France, 12,proprio4.getNomProprio());
		Pilote pilote9 = new Pilote("pilote","9", date, Pays.France, 12,proprio5.getNomProprio());
		Pilote pilote10 = new Pilote("pilote","10", date, Pays.France, 12,airFrance);
		Pilote pilote11 = new Pilote("pilote","11", date, Pays.France, 12,easyJet);
		Pilote pilote12 = new Pilote("pilote","12", date, Pays.France, 12,airTunisia);
		Pilote pilote13 = new Pilote("pilote","13", date, Pays.France, 12,airAustralia);
		Pilote pilote14 = new Pilote("pilote","14", date, Pays.France, 12,Pays.France);
		Pilote pilote15 = new Pilote("pilote","15", date, Pays.France, 12,Pays.France);
		
		listPilotes.add(pilote1);
		listPilotes.add(pilote2);
		listPilotes.add(pilote3);
		listPilotes.add(pilote4);
		listPilotes.add(pilote5);
		listPilotes.add(pilote6);
		listPilotes.add(pilote7);
		listPilotes.add(pilote8);
		listPilotes.add(pilote9);
		listPilotes.add(pilote10);
		listPilotes.add(pilote11);
		listPilotes.add(pilote12);
		listPilotes.add(pilote13);
		listPilotes.add(pilote14);
		
		airFrance.addPilote(pilote1);
		airFrance.addPilote(pilote2);
		airFrance.addPilote(pilote3);
		airFrance.addPilote(pilote4);
		
		//Personnel
		Personnel personnel1 = new Personnel("personnel","1", date, Pays.France, 12, airFrance);
		Personnel personnel2 = new Personnel("personnel","2", date, Pays.France, 12, airFrance);
		Personnel personnel3 = new Personnel("personnel","3", date, Pays.France, 12, airFrance);
		Personnel personnel4 = new Personnel("personnel","4", date, Pays.France, 12, airFrance);
		Personnel personnel5 = new Personnel("personnel","5", date, Pays.France, 12, airFrance);
		Personnel personnel6 = new Personnel("personnel","6", date, Pays.France, 12, airFrance);
		Personnel personnel7 = new Personnel("personnel","7", date, Pays.France, 12, airFrance);
		Personnel personnel8 = new Personnel("personnel","8", date, Pays.France, 12, easyJet);
		Personnel personnel9 = new Personnel("personnel","9", date, Pays.France, 12, easyJet);
		Personnel personnel10 = new Personnel("personnel","10", date, Pays.France, 12, easyJet);
		Personnel personnel11 = new Personnel("personnel","11", date, Pays.France, 12, easyJet);
		Personnel personnel12 = new Personnel("personnel","12", date, Pays.France, 12, easyJet);
		Personnel personnel13 = new Personnel("personnel","13", date, Pays.France, 12, easyJet);
		Personnel personnel14 = new Personnel("personnel","14", date, Pays.France, 12, airTunisia);
		Personnel personnel15 = new Personnel("personnel","15", date, Pays.France, 12, airAustralia);
		Personnel personnel16 = new Personnel("personnel","16", date, Pays.France, 12, airAustralia);
		
		listPersonnels.add(personnel1);
		listPersonnels.add(personnel2);
		listPersonnels.add(personnel3);
		listPersonnels.add(personnel4);
		listPersonnels.add(personnel5);
		listPersonnels.add(personnel6);
		listPersonnels.add(personnel7);
		listPersonnels.add(personnel8);
		listPersonnels.add(personnel9);
		listPersonnels.add(personnel10);
		listPersonnels.add(personnel11);
		listPersonnels.add(personnel12);
		listPersonnels.add(personnel13);
		listPersonnels.add(personnel14);
		listPersonnels.add(personnel15);
		listPersonnels.add(personnel16);
		
		airFrance.addPersonnel(personnel1);
		airFrance.addPersonnel(personnel2);
		airFrance.addPersonnel(personnel3);
		airFrance.addPersonnel(personnel4);
		
		//Diplomates
		Diplomate d1 = new Diplomate("diplomate1", "nom", date, Pays.France, 666);
		Diplomate d2 = new Diplomate("diplomate2", "nom", date, Pays.France, 333);
		Diplomate d3 = new Diplomate("diplomate3", "nom", date, Pays.France, 999);
		
		//Piste
		PisteDecollage pisteDecollage1 = new PisteDecollage();
		PisteDecollage pisteDecollage2 = new PisteDecollage();
		PisteAtterissage pisteAtterissage1 = new PisteAtterissage();
		PisteAtterissage pisteAtterissage2 = new PisteAtterissage();
		
		listPisteAtterissages.add(pisteAtterissage1);
		listPisteAtterissages.add(pisteAtterissage2);
		

		listPisteDecollages.add(pisteDecollage1);
		listPisteDecollages.add(pisteDecollage2);
	}

	protected void preparationAvionLigne(AvionLigne avion, PisteDecollage piste) {
		if(this.getPassagersDansAeroport() >= avion.getCapacite() && this.getPilotesDansAeroport(avion.getCompagnie()) >= avion.getNbPiloteMin() &&
				this.getPersonnelsDansAeroport(avion.getCompagnie()) >= avion.getNbPersonnelsMin()) {
			avion.remplissageAvion(this);
			Vol vol = new Vol(avion, "Paris", "Marseille");
			piste.addToQueue(vol);
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
}
