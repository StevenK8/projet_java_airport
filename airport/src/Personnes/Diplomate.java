package Personnes;

public class Diplomate extends Passager{

	private boolean accesCode; //si faux --> informations perso anonymisées
	
	public Diplomate(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport,false);
		accesCode = true; //peut etre a enlever plus tard ?
	}
	
	public boolean getBooleanAccesCode() {
		return accesCode;
	}
	public void setBooleanAccesCode(boolean modif) {
		accesCode = modif;
	}
	
	public boolean estEnVol() {
		return super.estEnVol();
	}

}
