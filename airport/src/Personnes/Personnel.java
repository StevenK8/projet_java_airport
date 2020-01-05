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
	 * @return boolean
	 */
	public boolean EstEnVol() {
		return super.estEnVol();
	}
	
	
	/** 
	 * @return Compagnie
	 */
	public Compagnie getCompagnie() {
		return compagnie;
	}
	
	
	/** 
	 * @return Pays
	 */
	public Pays getNationalite() {
		return pays;
	}
	
	
	/** 
	 * @return String
	 */
	public String toString() {
		String res = super.toString();
		return res + " personnel navigant pour " + compagnie.toString();
	}

}
