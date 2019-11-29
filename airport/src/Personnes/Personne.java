package Personnes;

public class Personne {
	private String prenom;
	private String nom;
    private DateNaissance dateNaissance;
    private String nationalite;

	public Personne(String prenom, String nom, DateNaissance dateNaissance, String nationalite) {
		this.prenom = prenom;
		this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
	}
	
	public String toString() {
		return prenom + " " + nom + "originaire de " + nationalite;
	}
	
}
