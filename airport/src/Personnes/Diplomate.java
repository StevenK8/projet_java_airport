package Personnes;

public class Diplomate extends Passager{

	private boolean accesCode; //si faux --> informations perso anonymisées
	
	public Diplomate(EnumPrenom prenom, EnumNom nom, DateNaissance dateNaissance, Pays nationalite) {
		super(prenom, nom, dateNaissance, nationalite,false);
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
