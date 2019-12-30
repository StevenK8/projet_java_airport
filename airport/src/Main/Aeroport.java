package Main;

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
import Personnes.Personne;
import Personnes.Personnel;
import Personnes.Pilote;
import Pistes.PisteAtterissage;
import Pistes.PisteDecollage;

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
		Personne proprio1 = new Personne("Jean", "azerty", date, "france");
		Personne proprio2 = new Personne("Daniel", "lala", date, "espagne");
		Personne proprio3 = new Personne("toto", "kerv", date, "allemagne");
		Personne proprio4 = new Personne("tata", "lalzlel", date, "usa");
		Personne proprio5 = new Personne("titi", "momomo", date, "australie");
		
		listProprietaires.add(proprio1);
		listProprietaires.add(proprio2);
		listProprietaires.add(proprio3);
		listProprietaires.add(proprio4);
		listProprietaires.add(proprio5);
		
		
		//Compagnie aerienne
		Compagnie airFrance = new Compagnie("AirFrance", "France");
		Compagnie easyJet = new Compagnie("EasyJet", "France");
		Compagnie airTunisia = new Compagnie("AirTunisia", "Tunisie");
		Compagnie airAustralia = new Compagnie("airAustralia", "Australie");
		
		listCompagnies.add(airFrance);
		listCompagnies.add(easyJet);
		listCompagnies.add(airTunisia);
		listCompagnies.add(airAustralia);
		
		//AvionPrive
		AvionPrive avionprive1 = new AvionPrive("airbus a380", 1, 12000.0, 100.0, 2,3, proprio1);
		AvionPrive avionprive2 = new AvionPrive("airbus a370", 2, 12000.0, 1000.0, 2,3, proprio2);
		AvionPrive avionprive3 = new AvionPrive("airbus a360", 3, 12000.0, 1000.0, 2,2, proprio3);
		AvionPrive avionprive4 = new AvionPrive("airbus a350", 4, 12000.0, 10000.0, 2,3, proprio4);
		AvionPrive avionprive5 = new AvionPrive("airbus a340", 5, 12000.0, 10000.0, 2,2, proprio5);
		
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
		Passager p1 = new Passager("passager","1", date, "Maroc", 1);
		Passager p2 = new Passager("passager","2", date, "Tunisie", 2);
		Passager p3 = new Passager("passager","3", date, "Allemagne", 3);
		Passager p4 = new Passager("passager","4", date, "France", 4);
		Passager p5 = new Passager("passager","1", date, "Maroc", 5);
		Passager p6 = new Passager("passager","2", date, "Tunisie", 6);
		Passager p7 = new Passager("passager","3", date, "Allemagne", 7);
		Passager p8 = new Passager("passager","4", date, "France", 8);
		Passager p9 = new Passager("passager","1", date, "Maroc", 9);
		Passager p10 = new Passager("passager","2", date, "Tunisie", 10);
		Passager p11 = new Passager("passager","3", date, "Allemagne", 11);
		Passager p12 = new Passager("passager","4", date, "France", 12);
		Passager p13 = new Passager("passager","1", date, "Maroc", 13);
		Passager p14 = new Passager("passager","2", date, "Tunisie", 14);
		Passager p15 = new Passager("passager","3", date, "Allemagne", 15);
		Passager p16 = new Passager("passager","4", date, "France", 16);
		Passager p17 = new Passager("passager","1", date, "Maroc", 17);
		Passager p18 = new Passager("passager","2", date, "Tunisie", 18);
		Passager p19 = new Passager("passager","3", date, "Allemagne", 19);
		Passager p20 = new Passager("passager","4", date, "France", 20);
		
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
		Pilote pilote1 = new Pilote("pilote","1", date, "France", 12,airFrance);
		Pilote pilote2 = new Pilote("pilote","2", date, "France", 12,airFrance);
		Pilote pilote3 = new Pilote("pilote","1", date, "France", 12,airFrance);
		Pilote pilote4 = new Pilote("pilote","2", date, "France", 12,airFrance);
		Pilote pilote5 = new Pilote("pilote","1", date, "France", 12,airFrance);
		Pilote pilote6 = new Pilote("pilote","2", date, "France", 12,airFrance);
		Pilote pilote7 = new Pilote("pilote","1", date, "France", 12,airFrance);
		Pilote pilote8 = new Pilote("pilote","2", date, "France", 12,airFrance);
		Pilote pilote9 = new Pilote("pilote","1", date, "France", 12,airFrance);
		Pilote pilote10 = new Pilote("pilote","2", date, "France", 12,airFrance);
		Pilote pilote11 = new Pilote("pilote","1", date, "France", 12,airFrance);
		Pilote pilote12 = new Pilote("pilote","2", date, "France", 12,airFrance);
		Pilote pilote13 = new Pilote("pilote","1", date, "France", 12,airFrance);
		Pilote pilote14 = new Pilote("pilote","2", date, "France", 12,airFrance);
		
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
		
		//Personnel
		Personnel personnel1 = new Personnel("personnel","1", date, "France", 12);
		Personnel personnel2 = new Personnel("personnel","2", date, "France", 12);
		Personnel personnel3 = new Personnel("personnel","1", date, "France", 12);
		Personnel personnel4 = new Personnel("personnel","2", date, "France", 12);
		Personnel personnel5 = new Personnel("personnel","1", date, "France", 12);
		Personnel personnel6 = new Personnel("personnel","2", date, "France", 12);
		Personnel personnel7 = new Personnel("personnel","1", date, "France", 12);
		Personnel personnel8 = new Personnel("personnel","2", date, "France", 12);
		Personnel personnel9 = new Personnel("personnel","1", date, "France", 12);
		Personnel personnel10 = new Personnel("personnel","2", date, "France", 12);
		Personnel personnel11 = new Personnel("personnel","1", date, "France", 12);
		Personnel personnel12 = new Personnel("personnel","2", date, "France", 12);
		Personnel personnel13 = new Personnel("personnel","1", date, "France", 12);
		Personnel personnel14 = new Personnel("personnel","2", date, "France", 12);
		Personnel personnel15 = new Personnel("personnel","1", date, "France", 12);
		Personnel personnel16 = new Personnel("personnel","2", date, "France", 12);
		
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
		
		//Diplomates
		Diplomate d1 = new Diplomate("diplomate1", "nom", date, "Europe", 666);
		Diplomate d2 = new Diplomate("diplomate2", "nom", date, "Europe", 333);
		Diplomate d3 = new Diplomate("diplomate3", "nom", date, "Europe", 999);
		
		listDiplomates.add(d1);
		listDiplomates.add(d2);
		listDiplomates.add(d3);
		
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
