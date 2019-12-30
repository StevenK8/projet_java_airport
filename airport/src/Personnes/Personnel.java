package Personnes;

import CompagnieAerienne.Compagnie;

public class Personnel extends Passager{

	//add champ Compagnie
	private Compagnie compagnie;
	
	public Personnel(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport, Compagnie pCompagnie) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport);
		compagnie = pCompagnie;
	}
	
	public boolean EstEnVol() {
		return super.estEnVol();
	}
	
	public Compagnie getCompagnie() {
		return compagnie;
	}

}
