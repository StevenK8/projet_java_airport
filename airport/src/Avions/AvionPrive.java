package Avions;

import Main.Aeroport;
import Personnes.Passager;
import Personnes.Personne;
import Personnes.Personnel;
import Personnes.Pilote;


public class AvionPrive extends Avion{
	private Personne proprietaire;
	
	public AvionPrive(String modele, int capacite, double poidsBagageMax, double volumeCarburant,int NbPiloteMin , Personne proprio) {
        super(modele, capacite, poidsBagageMax, volumeCarburant, NbPiloteMin,0);
		proprietaire = proprio;
	}
	
	public void remplissageAvion(Aeroport aeroport) {
    	for (Passager p : aeroport.getListVoyageurs()) {
			this.addPersonne(p);
		}
		for(Personnel p : aeroport.getListPersonnels()) {
			this.addPersonne(p);
		}
		for(Pilote p : aeroport.getListPilotes()) {
			this.addPersonne(p);
		}
		System.out.println(this);
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
