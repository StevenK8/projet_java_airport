package Personnes;

public class Passager {
	private String prenom;
	private String nom;
	private DateNaissance dateNaissance;
	private String nationalite;
	private int numPasseport;
	//add voyage souhaité (2 aéroports) --> faire les classes Vol et Avion
	//add historique de leurs vols (liste aéroports departs et arrivées) --> classe Vol
	
	//constructeur temporaire
	public Passager(String prenom, String nom, DateNaissance dateNaissance, String nationalite, int numPasseport) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
		this.numPasseport = numPasseport;
	}
	
	
}
