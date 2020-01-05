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
	
	
	/** 
	 * Renvoie le statut de vol du personnel
	 * @return boolean
	 */
	public boolean EstEnVol() {
		return super.estEnVol();
	}
	
	
	/** 
	 * Renvoie la compagnie du personnel
	 * @return Compagnie
	 */
	public Compagnie getCompagnie() {
		return compagnie;
	}
	
	
	/** 
	 * renvoie la nationalité du personnel
	 * @return Pays
	 */
	public Pays getNationalite() {
		return pays;
	}
	
	
	/** 
	 * Renvoie les informations textuelles du personnel
	 * @return String
	 */
	public String toString() {
		String res = super.toString();
		return res + " personnel navigant pour " + compagnie.toString();
	}

}
