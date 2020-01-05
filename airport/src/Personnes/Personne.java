package Personnes;

public class Personne {
	private EnumPrenom prenom;
	private EnumNom nom;
    private DateNaissance dateNaissance;
    private Pays nationalite;
    private boolean estEnVol;

	public Personne(EnumPrenom prenom, EnumNom nom, DateNaissance dateNaissance, Pays nationalite) {
		this.prenom = prenom;
		this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
	}
	
	
	/** 
	 * @return String
	 */
	public String toString() {
		return prenom + " " + nom + " originaire de " + nationalite;
	}
	
	
	/** 
	 * @return boolean
	 */
	public boolean estEnVol() {
		return estEnVol;
	}
	
	/** 
	 * @param modif
	 */
	public void setEstEnVol(boolean modif) {
		estEnVol = modif;
	}
	
	
	/** 
	 * @return String
	 */
	public String getNomProprio() {
		return prenom.toString() + nom.toString();
	}
}
