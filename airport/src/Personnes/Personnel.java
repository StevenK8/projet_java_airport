package Personnes;

import CompagnieAerienne.Compagnie;

public class Personnel extends Passager{

	//add champ Compagnie
	private Compagnie compagnie;
	private Pays pays;
	
	public Personnel(EnumPrenom prenom, EnumNom nom, DateNaissance dateNaissance, Pays nationalite, Compagnie pCompagnie) {
		super(prenom, nom, dateNaissance, nationalite,false);
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
	
	public String toString() {
		String res = super.toString();
		return res + " personnel navigant pour " + compagnie.toString();
	}

}
