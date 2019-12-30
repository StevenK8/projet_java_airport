package Personnes;

import CompagnieAerienne.Compagnie;

public class Personnel extends Passager{

	//add champ Compagnie
	private Compagnie compagnie;
	private Pays pays;
	
	public Personnel(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport, Compagnie pCompagnie) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport,false);
		compagnie = pCompagnie;
		pays = nationalite;
	}
	
	public boolean EstEnVol() {
		return super.estEnVol();
	}
	
	public Compagnie getCompagnie() {
		return compagnie;
	}
	
	public Pays getNationalite() {
		return pays;
	}

}
