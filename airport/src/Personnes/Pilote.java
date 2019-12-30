package Personnes;

import CompagnieAerienne.Compagnie;

public class Pilote extends Passager{

	//Travaille pour une compagnie, un etat ou a titre privee
	private String employeur;  //proprietaire donc avion privee
	private Compagnie compagnie; //avion de ligne
	private Pays pays; //avion diplo
	private int intervallePilote; //intervalle entre 2 vols

	public Pilote(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport, Compagnie pCompagnie) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport);
		intervallePilote = 2;
		compagnie = pCompagnie;
	}

	public Pilote(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport, String pEmployeur) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport);
		intervallePilote = 2;
		employeur = pEmployeur;
	}
	
	public Pilote(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport, Pays pPays) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport);
		intervallePilote = 2;
		pays = pPays;
	}

	public String getEmployeur(){
		return employeur; //si employeur == nom+prenom du proprietaire l'avion privee alors cest un pilote privee
						  
	}
	public Compagnie getCompagnie(){
		return compagnie;
	}
	public Pays getPays() {
		return pays;
	}
	public boolean estEnVol() {
		return super.estEnVol();
	}
}
