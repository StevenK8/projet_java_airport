package Personnes;

import CompagnieAerienne.Compagnie;

public class Pilote extends Passager{

	//Travaille pour une compagnie, un etat ou a titre privee
	private String employeur;  //proprietaire donc avion privee
	private Compagnie compagnie; //avion de ligne
	private Pays pays; //avion diplo
	private int intervallePilote = 0; //intervalle entre 2 vols

	public Pilote(EnumPrenom prenom, EnumNom nom, DateNaissance dateNaissance, Pays nationalite, Compagnie pCompagnie) {
		super(prenom, nom, dateNaissance, nationalite,false);
		compagnie = pCompagnie;
		pays = nationalite;
	}

	public Pilote(EnumPrenom prenom, EnumNom nom, DateNaissance dateNaissance, Pays nationalite, String pEmployeur) {
		super(prenom, nom, dateNaissance, nationalite,true);
		employeur = pEmployeur;
		pays = nationalite;
	}
	
	public Pilote(EnumPrenom prenom, EnumNom nom, DateNaissance dateNaissance, Pays nationalite) {
		//pilote d'avion diplomatique --> ne pilote que des avions de sa nationalite
		super(prenom, nom, dateNaissance, nationalite,false);
		pays = nationalite;
	}

	
	/** 
	 * @return String
	 */
	public String getEmployeur(){
		return employeur; //si employeur == nom+prenom du proprietaire l'avion privee alors cest un pilote privee
						  
	}
	
	/** 
	 * @return Compagnie
	 */
	public Compagnie getCompagnie(){
		return compagnie;
	}
	
	/** 
	 * @return Pays
	 */
	public Pays getNationalite() {
		return pays;
	}
	
	/** 
	 * @return boolean
	 */
	public boolean estEnVol() {
		return super.estEnVol();
	}
	
	
	/** 
	 * @return boolean
	 */
	public boolean estEnPause() {
		return intervallePilote != 0;
	}
	public void diminueIntervallePilote() {
		if(intervallePilote > 0) {
			intervallePilote -= 1;
		}
	}
	
	
	/** 
	 * @param inter
	 */
	public void setIntervallePilote(int inter) {
		if(intervallePilote > 0) {
			intervallePilote = inter;
		}
	}
	
	
	/** 
	 * @return int
	 */
	public int getIntervallePilote() {
		return intervallePilote;
	}
	
	
	/** 
	 * @return String
	 */
	public String toString() {
		String res = super.toString();
		if(compagnie != null) {
			return res + " pilote de ligne pour " + compagnie;
		}
		else if(employeur != null) {
			return res + " pilote d'avion privee pour " +  employeur;
		}
		else {
			return res + " pilote d'avion diplomatique pour " + pays.toString();
		}
	}
}
