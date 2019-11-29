package Avions;

import java.util.ArrayList;
import java.util.List;

import Personnes.Diplomate;
import Personnes.Personnel;
import Personnes.Pilote;

public class AvionDiplomatique extends Avion {

    private String etatProprietaire;
    private List<Diplomate> listDiplomates;
    private List<Pilote> listPilotes;
    private List<Personnel> listPersonnel;

    public AvionDiplomatique(String modele, int personnesMax, double poidsMax, double carburantMax, int pilotesMin, String etat){
        super(modele, personnesMax, poidsMax, carburantMax, pilotesMin);
        etatProprietaire = etat;
        listDiplomates = new ArrayList<Diplomate>();
        listPilotes = new ArrayList<Pilote>();
        listPersonnel = new ArrayList<Personnel>();
    }
    
    public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion diplomatique : " + modele + "\n");
    	res.append("nombre de passagers : " + listDiplomates.size() + " (max : " + capacite + ") \n");
    	res.append("proprietaire : " + etatProprietaire + "\n");
    	return res.toString();
    }
}
