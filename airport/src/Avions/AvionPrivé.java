package Avions;

import CompagnieAerienne.Compagnie;
import Personnes.Personne;

public class AvionPrivé extends Avion{
	private Personne proprietaire;
	private int nbPersonnelsMin;
	
	public AvionPrivé(String modele, int capacite, double poidsBagageMax, double volumeCarburant,int NbPiloteMin, Personne p, int nbPersonnel) {
        super(modele, capacite, poidsBagageMax, volumeCarburant, NbPiloteMin);
		proprietaire = p;
		nbPersonnelsMin = nbPersonnel;
	}
	
	//second constructeur car le personnel navigant n'est pas obligatoire
	public AvionPrivé(String m, int capa, double pdsMax, double volCarburant,int nbPilMin, Personne p) {
		this(m,capa,pdsMax,volCarburant,nbPilMin,p,0);
	}
}
