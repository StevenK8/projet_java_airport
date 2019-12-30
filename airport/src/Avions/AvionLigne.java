package Avions;

import CompagnieAerienne.Compagnie;

public class AvionLigne extends Avion{
	private Compagnie compagnieProprietaire;
	private int nbPersonnelsMin;

	
	public AvionLigne(String modele, int capacite, double poidsBagageMax, double volumeCarburant,int NbPiloteMin ,Compagnie c, int nbPersonnel) {
        super(modele, capacite, poidsBagageMax, volumeCarburant, NbPiloteMin,nbPersonnel);
		compagnieProprietaire = c;
		nbPersonnelsMin = nbPersonnel;
	}
	
	public boolean peutDecoller() {
		if(listPersonnels.size() >= this.nbPersonnelMin) {
			if(super.peutDecoller()) {
				return true;
			}
			return false;
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

	public int getPriorite() {
		return 1;
	}
}
