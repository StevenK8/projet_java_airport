package Avions;

import CompagnieAerienne.Compagnie;
import Main.Aeroport;
import Personnes.Passager;
import Personnes.Personnel;
import Personnes.Pilote;

public class AvionLigne extends Avion{
	private Compagnie compagnieProprietaire;
	private int nbPersonnelsMin;

	
	public AvionLigne(EnumModele modele, int capacite, double poidsBagageMax, double volumeCarburant,int NbPiloteMin ,Compagnie c, int nbPersonnel) {
        super(modele, capacite, poidsBagageMax, volumeCarburant, NbPiloteMin,nbPersonnel);
		compagnieProprietaire = c;
		nbPersonnelsMin = nbPersonnel;
	}
	
	
	/** 
	 * Remplit l'avion de ligne
	 * @param aeroport
	 */
	public void remplissageAvion(Aeroport aeroport) {
    	for (Passager p : aeroport.getListVoyageurs()) {
			super.addPersonne(p);
		}
		for(Personnel p : aeroport.getListPersonnels()) {
			this.addPersonnel(p);
		}
		for(Pilote p : aeroport.getListPilotes()) {
			this.addPilote(p);
		}
		//System.out.println(this);
    }
	
	
	/** 
	 * Ajoute un pilote à l'avion de ligne
	 * @param p
	 */
	public void addPilote(Pilote p) {
		//if (p.getCompagnie() == compagnieProprietaire) {
			super.addPersonne(p);
		//}
	}
	
	
	/** 
	 * Ajoute un personnel à l'avion de ligne
	 * @param p
	 */
	public void addPersonnel(Personnel p) {
		//if (p.getCompagnie() == compagnieProprietaire) {
			super.addPersonne(p);
		//}
	}
	
	
	/** 
	 * Vérifie si l'avion de ligne remplit les conditions pour décoller
	 * @return boolean
	 */
	public boolean peutDecoller() {
		if(super.aAssezDePersonnels()) {
			if(super.avionRempli()) {
				if(super.aAssezDePilotes()) {
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
		else {
			System.out.println("pas assez de personnels dans " + this.getModele());
			return false;
		}
	}
	
	
	/** 
	 * Renvoie les informations textuelles de l'avion de ligne
	 * @return String
	 */
	public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion de ligne : " + modele + "\n");
    	res.append(super.toString());
    	res.append("proprietaire : " + compagnieProprietaire + "\n");
    	return res.toString();
    }
	
	
	/** 
	 * Renvoie la compagnie propriétaire de l'avion de ligne
	 * @return Compagnie
	 */
	public Compagnie getCompagnie() {
		return compagnieProprietaire;
	}
	
	
	/** 
	 * Renvoie la priorité de l'avion de ligne (1)
	 * @return int
	 */
	public int getPriorite() {
		return 1;
	}
}
