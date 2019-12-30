package Avions;

import Personnes.Passager;
import Personnes.Personne;
import Personnes.Personnel;
import Personnes.Pilote;

import java.util.ArrayList;
import java.util.List;

public abstract class Avion {
	protected String modele;
	protected int capacite;
	protected double poidsBagageMax;
	protected double volumeCarburant;
	protected int NbPiloteMin;
	protected int nbPersonnelMin;
	protected int priorite;
	public List<Passager> listPassagers;
	public List<Pilote> listPilotes;
	public List<Personnel> listPersonnels;
	public List<Personne> listOccupants; //nombre total de personnes dans l'avion (passagers + pilotes + personnels)
	private boolean estEnVol = false;
	
	
    public Avion(String modele, int capacite, double poidsBagageMax, double volumeCarburant, int NbPiloteMin, int nbPersonnelMin){
        this.modele = modele;
        this.capacite = capacite;
        this.poidsBagageMax = poidsBagageMax;
        this.volumeCarburant = volumeCarburant;
		this.NbPiloteMin = NbPiloteMin;
		this.nbPersonnelMin = nbPersonnelMin;
		listPassagers = new ArrayList<Passager>();
		listPilotes = new ArrayList<Pilote>();
		listPersonnels = new ArrayList<Personnel>();
		listOccupants = new ArrayList<Personne>();
	}	
		
    public List<Personne> getListOccupants(){
    	return listOccupants;
    }
    
	public List<Passager> getlistPassagers(){
		return listPassagers;
	}
	
	public void addPersonne(Personne p) {
		if(p instanceof Passager) {
			if(listPassagers.size() < capacite) {
			Passager passager = (Passager) p;
				if(!passager.estEnVol()) {
					listPassagers.add(passager);
					listOccupants.add(passager);
					passager.setEstEnVol(true);
				}
				else {
					System.out.println("Le passager que vous tentez d'ajouter est deja en vol !");
				}
			}			
		}
		if(p instanceof Personnel) {
			if (listPersonnels.size() < nbPersonnelMin) {
				Personnel personnel = (Personnel) p;
				listPersonnels.add(personnel);
				listOccupants.add(p);
			}
		}
		else if(p instanceof Pilote) {
			if(listPilotes.size() < NbPiloteMin) {
				Pilote pilote = (Pilote) p;
				listPilotes.add(pilote);
				listOccupants.add(pilote);
			}
		}
	}
	
	public void clearAvion() {
		listOccupants.forEach(occupant ->{
			if(occupant instanceof Passager) {
				Passager p = (Passager) occupant;
				p.setEstEnVol(false);
			}
		});
		listPassagers.clear();
		listOccupants.clear();
		listPersonnels.clear();
		listPilotes.clear();
	}

	public void clearPassagers() {
		listOccupants.forEach(occupant ->{
			if(occupant instanceof Passager) {
				Passager p = (Passager) occupant;
				p.setEstEnVol(false);
			}
		});
		listPassagers.clear();
		listOccupants.clear();
		listPersonnels.clear();
		for (Pilote pilote : listPilotes){
			if(pilote.getCompagnie()!=null){ // Les pilotes de compagnies aériennes demeurent dans l’aéroport.
				listPassagers.add(pilote);
			}
		}
	}

	public boolean aAssezDePilotes(){
		if (listPilotes.size() >= NbPiloteMin){
			return true;
		}
		return false;
	}

	public  boolean peutDecoller() {
		if(listPassagers.size() == getNbPassagers()) {
			if(aAssezDePilotes()) {
				return true;
			}
			else {
				System.out.println("Pas assez de pilotes dans " + this.getModele());
				return false;
			}
		}
		else {
			System.out.println("Pas assez de passagers dans " + this.getModele());
			return false;
		}
	}
	
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
	
	public int getNbPassagers(){
		return listPassagers.size();
	}
	public String getModele() {
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
	public abstract int getPriorite();
}
