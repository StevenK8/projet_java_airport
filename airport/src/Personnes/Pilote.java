package Personnes;

import Avions.Avion;

public class Pilote extends Passager{

	//Travaille pour compagnie ou entreprise ou etat
	private int intervallePilote; //intervalle entre 2 vols

	public Pilote(String prenom, String nom, DateNaissance dateNaissance, String nationalite, int numPasseport) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport);
		intervallePilote = 2;
	}
}
