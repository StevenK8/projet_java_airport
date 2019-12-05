package Avions;

import CompagnieAerienne.Compagnie;
import Personnes.Personne;
import Personnes.Personnel;

public class AvionLigne extends Avion{
	private Compagnie compagnieProprietaire;
	private int nbPersonnelsMin;

	
	public AvionLigne(String modele, int capacite, double poidsBagageMax, double volumeCarburant,int NbPiloteMin, Compagnie c, int nbPersonnel) {
        super(modele, capacite, poidsBagageMax, volumeCarburant, NbPiloteMin);
		compagnieProprietaire = c;
		nbPersonnelsMin = nbPersonnel;
	}
	
	public boolean peutDecoller() {
		return (listPersonnels.size() >= nbPersonnelsMin && super.peutDecoller());
	}
	
	public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion de ligne : " + modele + "\n");
    	res.append("nombre de passagers : " + listPassagers.size() + " (max : " + capacite + ") \n");
    	res.append("proprietaire : " + compagnieProprietaire + "\n");
    	return res.toString();
    }
}
