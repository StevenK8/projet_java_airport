package Personnes;

public class Passager extends Personne{
	
	private int numPasseport;//État correspondant au passeport? -> classe passeport
	//add voyage souhait� (2 a�roports) --> faire les classes Vol et Avion
	//add historique de leurs vols (liste a�roports departs et arriv�es) --> classe Vol
	
	//constructeur temporaire
	public Passager(String prenom, String nom, DateNaissance dateNaissance, String nationalite, int numPasseport) {
		super(prenom, nom, dateNaissance, nationalite);
		this.numPasseport = numPasseport;
	}

	
	
}
