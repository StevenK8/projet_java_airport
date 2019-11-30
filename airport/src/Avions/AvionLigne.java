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

	//Vérifie si le personnel est suffisant
	public boolean aAssezDePersonnel(){
		int countPersonnel = 0;
		for (Personne p:this.getlistPassagers()){
			if(p instanceof Personnel){
				countPersonnel++;
			}
		}
		if (countPersonnel >= nbPersonnelsMin){
			return true;
		}
		return false;
	}

	public boolean peutDecoller() {
		return this.capacite == this.getlistPassagers().size() && aAssezDePersonnel() && aAssezDePilotes();
	}
	
	public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion de ligne : " + modele + "\n");
    	res.append("nombre de passagers : " + listPassagers.size() + " (max : " + capacite + ") \n");
    	res.append("proprietaire : " + compagnieProprietaire + "\n");
    	return res.toString();
    }
}
