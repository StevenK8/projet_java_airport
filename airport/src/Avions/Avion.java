package Avions;

import Personnes.Diplomate;
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
	public List<Passager> listPassagers;
	public List<Pilote> listPilotes;
	public List<Personnel> listPersonnels;
	public List<Personne> listOccupants; //nombre total de personnes dans l'avion (passagers + pilotes + personnels)
	
    public Avion(String modele, int capacite, double poidsBagageMax, double volumeCarburant, int NbPiloteMin){
        this.modele = modele;
        this.capacite = capacite;
        this.poidsBagageMax = poidsBagageMax;
        this.volumeCarburant = volumeCarburant;
		this.NbPiloteMin = NbPiloteMin;
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
		if(listOccupants.size() < capacite) {
			if(p instanceof Passager) {
				Passager passager = (Passager) p;
				if(!passager.estEnVol()) {
					listPassagers.add(passager);
					listOccupants.add(passager);
					passager.setEstEnVol(true);
				}
				else {
					System.out.println("Le passager que vous tentez d'ajouter est déjà en vol !");
				}
			}			
			if(p instanceof Personnel) {
				Personnel personnel = (Personnel) p;
				listPersonnels.add(personnel);
				listOccupants.add(p);
			}
			if(p instanceof Pilote) {
				Pilote pilote = (Pilote) p;
				listPilotes.add(pilote);
				listOccupants.add(pilote);
			}
		}
		else {
			System.out.println("Plus de places dans cet avion !");
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

	public boolean aAssezDePilotes(){
		if (listPilotes.size() >= NbPiloteMin){
			return true;
		}
		return false;
	}

	public boolean peutDecoller() {
		return this.capacite == getNbPassagers() && aAssezDePilotes();
	}

	public void removePassager(Passager passager) {
		listPassagers.remove(passager);
		listOccupants.remove(passager);
		passager.setEstEnVol(false);
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
}
