package Avions;

import Personnes.Personne;


public class AvionPrive extends Avion{
	private Personne proprietaire;
	
	public AvionPrive(String modele, int capacite, double poidsBagageMax, double volumeCarburant,int NbPiloteMin,int personnelMin , Personne proprio) {
        super(modele, capacite, poidsBagageMax, volumeCarburant, NbPiloteMin,personnelMin);
		proprietaire = proprio;
	}
	
	public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion prive : " + modele + "\n");
    	res.append("nombre de passagers : " + listPassagers.size() + " (max : " + capacite + ") \n");
    	res.append("proprietaire : " + proprietaire + "\n");
    	return res.toString();
    }

	@Override
	public int getPriorite() {
		return 2;
	}

	@Override
	public boolean peutDecoller() {
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
}
