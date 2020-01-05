package Avions;

import Personnes.Diplomate;
import Personnes.Passager;
import Personnes.Personne;
import Personnes.Personnel;
import Personnes.Pilote;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	private int periodeImmobilisation;
	
	
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
		periodeImmobilisation = 0;
	}	
	
    
	
	
	/** 
	 * @param toString(
	 */
	public abstract void remplissageAvion(Aeroport aeroport);
	
    
	/** 
	 * @return String
	 */
	public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("nombre de passagers : " + listPassagers.size() + " (max : " + capacite + ") \n");
    	res.append("nombre de personnels navigants : " + listPersonnels.size() + " (min : " + nbPersonnelMin + ") \n");
    	res.append("nombre de pilotes : " + listPilotes.size() + " (min : " + NbPiloteMin + ") \n");
    	return res.toString();
	}
	
	public void immobilise(){
		Random r = new Random();
		periodeImmobilisation = r.nextInt(5) + 1;
	}

	
	/** 
	 * @param periodeImmobilisation
	 */
	public void immobilise(int periodeImmobilisation){
		this.periodeImmobilisation = periodeImmobilisation;
	}

	public void diminuePeriodeImmobilisation(){
		if(periodeImmobilisation>0)
			periodeImmobilisation--;
	}

	
	/** 
	 * @return int
	 */
	public int getPeriodeImmobilisation(){
		return periodeImmobilisation;
	}
    
	
	/** 
	 * @param p
	 */
	public void addPersonne(Passager p) {
		if(!p.estEnVol()) {
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
			else if(p instanceof Passager) {
				if(listPassagers.size() < capacite) {
					Passager passager = (Passager) p;
					listPassagers.add(passager);
					listOccupants.add(passager);
					passager.setEstEnVol(true);
				}			
			}
		}
	}

	
	/** 
	 * @param aeroport
	 */
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

	
	/** 
	 * @param aeroport
	 */
	public void cancelVolAvion(Aeroport aeroport) {
		for (Passager p : listOccupants) {
			if(p instanceof Pilote) {
				Pilote pilote = (Pilote) p;
				listPilotes.remove(pilote);
				aeroport.getListPilotes().remove(pilote);
				aeroport.getListPilotes().add(pilote); // On le replace en première position
			}
			else if (p instanceof Personnel) {
				Personnel personnel = (Personnel) p;
				listPersonnels.remove(p);
				aeroport.getListPersonnels().remove(personnel);
				aeroport.getListPersonnels().add(personnel);
			}
			else {
				listPassagers.remove(p);
				aeroport.getListVoyageurs().remove(p);
				aeroport.getListVoyageurs().add(p);
			}
		}
		listOccupants.clear();
	}

	
	/** 
	 * @return boolean
	 */
	public boolean aAssezDePilotes(){
		if (listPilotes.size() >= NbPiloteMin){
			return true;
		}
		return false;
	}
	
	
	/** 
	 * @return boolean
	 */
	public boolean aAssezDePersonnels(){
		if (listPersonnels.size() >= nbPersonnelMin){
			return true;
		}
		return false;
	}
	
	
	/** 
	 * @return boolean
	 */
	public boolean avionRempli(){
		if (listPassagers.size() == capacite){
			return true;
		}
		return false;
	}
	
	
	/** 
	 * @param nCarburant
	 */
	public void diminueCarburant(double nCarburant) {
		this.volumeCarburant = nCarburant;
	}

	
	
	
	/** 
	 * @param estEnVol(
	 * @return boolean
	 */
	/** 
	 * @param estEnVol(
	 * @return boolean
	 */
	/** 
	 * @param estEnVol(
	 * @return boolean
	 */
	public abstract boolean peutDecoller();
	
	
	/** 
	 * @return boolean
	 */
	public boolean estEnVol() {
		return estEnVol;
	}
	
	/** 
	 * @param modif
	 */
	public void setEstEnVol(boolean modif) {
		estEnVol = modif;
	}
	
	
	/** 
	 * @param passager
	 */
	public void removePassager(Passager passager) {
		listPassagers.remove(passager);
		listOccupants.remove(passager);
		passager.setEstEnVol(false);
		System.out.println("passager : " + passager.toString() + " sort de " + this.getModele());
	}
	
	
    
	/** 
	 * @return List<Passager>
	 */
	public List<Passager> getListOccupants(){
    	return listOccupants;
    }
    
	
	/** 
	 * @return List<Passager>
	 */
	public List<Passager> getlistPassagers(){
		return listPassagers;
	}
	
	/** 
	 * @return List<Pilote>
	 */
	public List<Pilote> getListPilotes(){
    	return listPilotes;
    }
    
	
	/** 
	 * @return List<Personnel>
	 */
	public List<Personnel> getlistPersonnels(){
		return listPersonnels;
	}
	
	
	/** 
	 * @return int
	 */
	public int getNbPassagers(){
		return listPassagers.size();
	}
	
	/** 
	 * @return EnumModele
	 */
	public EnumModele getModele() {
		return modele;
	}
	
	/** 
	 * @return int
	 */
	public int getCapacite() {
		return capacite;
	}
	
	/** 
	 * @return double
	 */
	public double getPoidsBagageMax() {
		return poidsBagageMax;
	}
	
	/** 
	 * @return double
	 */
	public double getVolumeCarburant() {
		return volumeCarburant;
	}
	
	/** 
	 * @return int
	 */
	public int getNbPiloteMin() {
		return NbPiloteMin;
	}
	
	/** 
	 * @return int
	 */
	public int getNbPersonnelsMin() {
		return nbPersonnelMin;
	}
	
	
	/** 
	 * @return String
	 */
	public String getType() {
		if (this instanceof AvionLigne) {
			return "Avion de ligne";
		}
		else if (this instanceof AvionPrive) {
			return "Avion prive";
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
