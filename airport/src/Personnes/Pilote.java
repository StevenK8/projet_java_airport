package Personnes;

import CompagnieAerienne.Compagnie;

public class Pilote extends Passager{

	//Travaille pour une compagnie, un etat ou a titre privé
	private String employeur;
	private Compagnie compagnie;
	private int intervallePilote; //intervalle entre 2 vols

	public Pilote(String prenom, String nom, DateNaissance dateNaissance, String nationalite, int numPasseport, Compagnie pCompagnie) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport);
		intervallePilote = 2;
		compagnie = pCompagnie;
	}

	public Pilote(String prenom, String nom, DateNaissance dateNaissance, String nationalite, int numPasseport, String pEmployeur) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport);
		intervallePilote = 2;
		employeur = pEmployeur;
	}

	public String getEmployeur(){
		return employeur;
	}
	public Compagnie getCompagnie(){
		return compagnie;
	}
}
