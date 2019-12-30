package Avions;

import Main.Aeroport;
import Personnes.Diplomate;
import Personnes.Passager;
import Personnes.Personnel;
import Personnes.Pilote;

public class AvionDiplomatique extends Avion {

    private String etatProprietaire;

    public AvionDiplomatique(String modele, int personnesMax, double poidsMax, double carburantMax, int pilotesMin,int personnelMin, String etat){
        super(modele, personnesMax, poidsMax, carburantMax, pilotesMin, personnelMin);
        etatProprietaire = etat;
    }
    
    public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion diplomatique : " + modele + "\n");
    	res.append("nombre de passagers : " + listPassagers.size() + " (max : " + capacite + ") \n");
    	res.append("proprietaire : " + etatProprietaire + "\n");
    	return res.toString();
    }
    
    public void remplissageAvion(Aeroport aeroport) {
    	for (Passager p : aeroport.getListVoyageurs()) {
			this.addPassager(p);
		}
		for(Personnel p : aeroport.getListPersonnels()) {
			this.addPersonne(p);
		}
		for(Pilote p : aeroport.getListPilotes()) {
			this.addPersonne(p);
		}
		System.out.println(this);
    }
    
    public void addPassager(Passager p) {
    	if(p instanceof Diplomate) {
    		super.addPersonne(p);
    	}
    	else {
    		System.out.println("Vous tentez d'ajoutez un passager non diplomatique dans un avion diplomatique !");
    	}
    }

	@Override
	public int getPriorite() {
		return 0;
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
