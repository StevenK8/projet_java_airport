package Personnes;

import CompagnieAerienne.Compagnie;

public class Pilote extends Passager{

	//Travaille pour une compagnie, un etat ou a titre privee
	private String employeur;  //proprietaire donc avion privee
	private Compagnie compagnie; //avion de ligne
	private Pays pays; //avion diplo
	private int intervallePilote = 1; //intervalle entre 2 vols

	public Pilote(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport, Compagnie pCompagnie) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport,false);
		compagnie = pCompagnie;
		pays = nationalite;
	}

	public Pilote(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport, String pEmployeur) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport,true);
		employeur = pEmployeur;
		pays = nationalite;
	}
	
	public Pilote(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport,false);
		pays = nationalite;
	}

	public String getEmployeur(){
		return employeur; //si employeur == nom+prenom du proprietaire l'avion privee alors cest un pilote privee
						  
	}
	public Compagnie getCompagnie(){
		return compagnie;
	}
	public Pays getNationalite() {
		return pays;
	}
	public boolean estEnVol() {
		return super.estEnVol();
	}
	
	public boolean estEnPause() {
		return intervallePilote != 0;
	}
	public void setIntervallePilote(int inter) {
		if(intervallePilote > 0) {
			intervallePilote = inter;
		}
	}
	
	public int getIntervallePilote() {
		return intervallePilote;
	}
}
