package Personnes;

public class Passager extends Personne{
	
	private int numPasseport;
	//add voyage souhait� (2 a�roports) --> faire les classes Vol et Avion
	//add historique de leurs vols (liste a�roports departs et arriv�es) --> classe Vol
	
	//constructeur temporaire
	public Passager(String prenom, String nom, DateNaissance dateNaissance, String nationalite, int numPasseport) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
		this.numPasseport = numPasseport;
	}

	
	
}
