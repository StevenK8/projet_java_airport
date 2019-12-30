package Personnes;

public class Passager extends Personne{
	
	private int numPasseport;//nationalite correspondant au passeport? -> classe passeport
	//add voyage souhaite (2 aeroports) --> faire les classes Vol et Avion
	//add historique de leurs vols (liste aeroports departs et arrivees) --> classe Vol
	
	//constructeur temporaire
	public Passager(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport) {
		super(prenom, nom, dateNaissance, nationalite);
		this.numPasseport = numPasseport;
	}

	public boolean estEnVol() {
		return super.estEnVol();
	}
	
	
}
