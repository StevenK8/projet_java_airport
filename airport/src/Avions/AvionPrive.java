package Avions;

import Personnes.Personne;


public class AvionPrive extends Avion{
	private Personne proprietaire;
	
	public AvionPrive(String modele, int capacite, double poidsBagageMax, double volumeCarburant,int NbPiloteMin, Personne proprio) {
        super(modele, capacite, poidsBagageMax, volumeCarburant, NbPiloteMin);
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
		// TODO Auto-generated method stub
		return 2;
	}
}
