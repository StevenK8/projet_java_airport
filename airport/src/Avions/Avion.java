package Avions;

import Personnes.Diplomate;
import Personnes.Passager;
import Personnes.Personne;
import Personnes.Personnel;
import Personnes.Pilote;

import java.util.ArrayList;
import java.util.List;

import CompagnieAerienne.Compagnie;
import Main.Aeroport;

public abstract class Avion {
	protected EnumModele modele;
	protected int capacite;
	protected double poidsBagageMax;
	protected double volumeCarburant;
	protected int NbPiloteMin;
	protected int nbPersonnelMin;
	protected int priorite;
	public List<Passager> listPassagers;
	public List<Pilote> listPilotes;
	public List<Personnel> listPersonnels;
	public List<Passager> listOccupants; //nombre total de personnes dans l'avion (passagers + pilotes + personnels)
	private boolean estEnVol = false;
	
	
    public Avion(EnumModele modele, int capacite, double poidsBagageMax, double volumeCarburant, int NbPiloteMin, int nbPersonnelMin){
        this.modele = modele;
        this.capacite = capacite;
        this.poidsBagageMax = poidsBagageMax;
        this.volumeCarburant = volumeCarburant;
		this.NbPiloteMin = NbPiloteMin;
		this.nbPersonnelMin = nbPersonnelMin;
		listPassagers = new ArrayList<Passager>();
		listPilotes = new ArrayList<Pilote>();
		listPersonnels = new ArrayList<Personnel>();
		listOccupants = new ArrayList<Passager>();
	}	
	
    public abstract void remplissageAvion(Aeroport aeroport);
	
	public void addPersonne(Passager p) {
		if(!p.estEnVol()) {
			if(p instanceof Passager) {
				if(listPassagers.size() < capacite) {
					Passager passager = (Passager) p;
					listPassagers.add(passager);
					listOccupants.add(passager);
					passager.setEstEnVol(true);
				}			
			}
			if(p instanceof Personnel) {
				if (listPersonnels.size() < nbPersonnelMin) {
					Personnel personnel = (Personnel) p;
					listPersonnels.add(personnel);
					listOccupants.add(p);
					p.setEstEnVol(true);
				}
			}
			else if(p instanceof Pilote) {
				if(listPilotes.size() < NbPiloteMin) {
					Pilote pilote = (Pilote) p;
					listPilotes.add(pilote);
					listOccupants.add(pilote);
					p.setEstEnVol(true);
				}
			}
		}
	}

	public void clearAvion(Aeroport aeroport) {
		ArrayList<Pilote> pilotesRestantsDansAeroport = new ArrayList<>();
		for (Passager p : listOccupants) {
			if(p instanceof Pilote) {
				Pilote pilote = (Pilote) p;
				if(pilote.getCompagnie() != null) {
					listPilotes.remove(pilote); //le pilote descend de l'avion mais reste dans laeroport
					pilote.setIntervallePilote(1); //le pilote a un temps de pause de 1 intervalle
				}
				else {
					listPilotes.remove(pilote); //le pilote descend de l'avion
					aeroport.getListPilotes().remove(pilote); //le pilote quitte laeroport
				}
			}
			else if (p instanceof Personnel) {
				listPersonnels.remove(p);
				aeroport.getListPersonnels().remove(p);
			}
			else {
				listPassagers.remove(p);
				aeroport.getListVoyageurs().remove(p);
			}
		}
		listOccupants.clear();
	}

	public boolean aAssezDePilotes(){
		if (listPilotes.size() >= NbPiloteMin){
			return true;
		}
		return false;
	}
	
	public boolean aAssezDePersonnels(){
		if (listPersonnels.size() >= nbPersonnelMin){
			return true;
		}
		return false;
	}
	
	public boolean avionRempli(){
		if (listPassagers.size() == capacite){
			return true;
		}
		return false;
	}

	public abstract boolean peutDecoller();
	
	public boolean estEnVol() {
		return estEnVol;
	}
	public void setEstEnVol(boolean modif) {
		estEnVol = modif;
	}
	
	public void removePassager(Passager passager) {
		listPassagers.remove(passager);
		listOccupants.remove(passager);
		passager.setEstEnVol(false);
		System.out.println("passager : " + passager.toString() + " sort de " + this.getModele());
	}
	
	
    public List<Passager> getListOccupants(){
    	return listOccupants;
    }
    
	public List<Passager> getlistPassagers(){
		return listPassagers;
	}
	public List<Pilote> getListPilotes(){
    	return listPilotes;
    }
    
	public List<Personnel> getlistPersonnels(){
		return listPersonnels;
	}
	
	public int getNbPassagers(){
		return listPassagers.size();
	}
	public EnumModele getModele() {
		return modele;
	}
	public int getCapacite() {
		return capacite;
	}
	public double getPoidsBagageMax() {
		return poidsBagageMax;
	}
	public double getVolumeCarburant() {
		return volumeCarburant;
	}
	public int getNbPiloteMin() {
		return NbPiloteMin;
	}
	public int getNbPersonnelsMin() {
		return nbPersonnelMin;
	}
	
	public String getType() {
		if (this instanceof AvionLigne) {
			return "Avion de ligne";
		}
		else if (this instanceof AvionPrive) {
			return "Avion privee";
		}
		else if (this instanceof AvionDiplomatique) {
			return "Avion diplomatique";
		}
		else {
			return "";
		}
		
	}
	public abstract int getPriorite();
}
