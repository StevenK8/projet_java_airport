package Personnes;

public class Diplomate extends Passager{

	private boolean accesCode; //si faux --> informations perso anonymisées
	
	public Diplomate(EnumPrenom prenom, EnumNom nom, DateNaissance dateNaissance, Pays nationalite) {
		super(prenom, nom, dateNaissance, nationalite,false);
		accesCode = true; //peut etre a enlever plus tard ?
	}
	
	
	/** 
	 * Renvoie le code d'accès du diplomate
	 * @return boolean
	 */
	public boolean getBooleanAccesCode() {
		return accesCode;
	}
	
	/** 
	 * Définit le code d'accès du diplomate
	 * @param modif
	 */
	public void setBooleanAccesCode(boolean modif) {
		accesCode = modif;
	}
	
	
	/** 
	 * Renvoie le statut de vol du diplomate
	 * @return boolean
	 */
	public boolean estEnVol() {
		return super.estEnVol();
	}

}
