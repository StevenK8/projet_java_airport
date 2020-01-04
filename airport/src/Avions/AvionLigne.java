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
	
	public void addPilote(Pilote p) {
		//if (p.getCompagnie() == compagnieProprietaire) {
			super.addPersonne(p);
		//}
	}
	
	public void addPersonnel(Personnel p) {
		//if (p.getCompagnie() == compagnieProprietaire) {
			super.addPersonne(p);
		//}
	}
	
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
	
	public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion de ligne : " + modele + "\n");
    	res.append("nombre de passagers : " + listPassagers.size() + " (max : " + capacite + ") \n");
    	res.append("nombre de personnels navigants : " + listPersonnels.size() + " (min : " + nbPersonnelsMin + ") \n");
    	res.append("nombre de pilotes : " + listPilotes.size() + " (min : " + NbPiloteMin + ") \n");
    	res.append("proprietaire : " + compagnieProprietaire + "\n");
    	return res.toString();
    }
	
	public Compagnie getCompagnie() {
		return compagnieProprietaire;
	}
	
	public int getPriorite() {
		return 1;
	}
}
