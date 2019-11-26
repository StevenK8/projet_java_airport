package Avions;

import CompagnieAerienne.Compagnie;
import Personnes.Proprietaire;

public class AvionPrivé extends Avion{
	private Proprietaire proprietaire;
	private int nbPersonnelsMin;
	
	public AvionPrivé(String m, int capa, double pdsMax, double volCarburant,int nbPilMin, Proprietaire p, int nbPersonnel) {
		modele = m;
		capacite = capa;
		poidsBagageMax = pdsMax;
		volumeCarburant = volCarburant;
		NbPiloteMin = nbPilMin;
		proprietaire = p;
		nbPersonnelsMin = nbPersonnel;
	}
	
	//second constructeur car le personnel navigant n'est pas obligatoire
	public AvionPrivé(String m, int capa, double pdsMax, double volCarburant,int nbPilMin, Proprietaire p) {
		this(m,capa,pdsMax,volCarburant,nbPilMin,p,0);
	}
}
