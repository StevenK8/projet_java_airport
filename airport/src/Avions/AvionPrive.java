package Avions;

import java.util.ArrayList;
import java.util.List;

import CompagnieAerienne.Compagnie;
import Personnes.Passager;
import Personnes.Personne;
import Personnes.Personnel;
import Personnes.Pilote;

public class AvionPrive extends Avion{
	private Personne proprietaire;
	private int nbPersonnelsMin;
	private List<Pilote> pilotes;
    private List<Personnel> personnel;
    private List<Passager> passagers;
	
	public AvionPrive(String modele, int capacite, double poidsBagageMax, double volumeCarburant,int NbPiloteMin, Personne p, int nbPersonnel) {
        super(modele, capacite, poidsBagageMax, volumeCarburant, NbPiloteMin);
		proprietaire = p;
		nbPersonnelsMin = nbPersonnel;
		pilotes = new ArrayList<>();
		passagers = new ArrayList<>();
		if(nbPersonnel > 0) {
			personnel = new ArrayList<>();
		}
	}
	
	//second constructeur car le personnel navigant n'est pas obligatoire
	public AvionPrive(String m, int capa, double pdsMax, double volCarburant,int nbPilMin, Personne p) {
		this(m,capa,pdsMax,volCarburant,nbPilMin,p,0); //nb personnel = 0
	}
	
	public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion privé : " + modele + "\n");
    	res.append("nombre de passagers : " + passagers.size() + " (max : " + capacite + ") \n");
    	res.append("proprietaire : " + proprietaire + "\n");
    	return res.toString();
    }
}
