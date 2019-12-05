package Avions;

import Personnes.Diplomate;
import Personnes.Passager;

public class AvionDiplomatique extends Avion {

    private String etatProprietaire;

    public AvionDiplomatique(String modele, int personnesMax, double poidsMax, double carburantMax, int pilotesMin, String etat){
        super(modele, personnesMax, poidsMax, carburantMax, pilotesMin);
        etatProprietaire = etat;
    }
    
    public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion diplomatique : " + modele + "\n");
    	res.append("nombre de passagers : " + listPassagers.size() + " (max : " + capacite + ") \n");
    	res.append("proprietaire : " + etatProprietaire + "\n");
    	return res.toString();
    }
    
    public void addPassager(Passager p) {
    	if(p instanceof Diplomate) {
    		super.addPersonne(p);
    	}
    	else {
    		System.out.println("Vous tentez d'ajoutez un passager non diplomatique dans un avion diplomatique !");
    	}
    }
}
