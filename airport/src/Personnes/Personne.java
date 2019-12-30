package Personnes;

public class Personne {
	private String prenom;
	private String nom;
    private DateNaissance dateNaissance;
    private Pays nationalite;
    private boolean estEnVol;

	public Personne(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite) {
		this.prenom = prenom;
		this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
	}
	
	public String toString() {
		return prenom + " " + nom + " originaire de " + nationalite;
	}
	
	public boolean estEnVol() {
		return estEnVol;
	}
	public void setEstEnVol(boolean modif) {
		estEnVol = modif;
	}
	
	public String getNomProprio() {
		return prenom+nom;
	}
}
