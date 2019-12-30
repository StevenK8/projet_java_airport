package Personnes;

public class Passager extends Personne{
	
	private int numPasseport;//nationalite correspondant au passeport? -> classe passeport
	//add voyage souhaite (2 aeroports) --> faire les classes Vol et Avion
	//add historique de leurs vols (liste aeroports departs et arrivees) --> classe Vol
	
	private boolean prendAvionPrivee;
	
	//constructeur temporaire
	public Passager(String prenom, String nom, DateNaissance dateNaissance, Pays nationalite, int numPasseport, boolean pPrendAvionPrive) {
		super(prenom, nom, dateNaissance, nationalite);
		this.numPasseport = numPasseport;
		prendAvionPrivee = pPrendAvionPrive;
	}

	public boolean estEnVol() {
		return super.estEnVol();
	}
	
	public boolean getPrendAvionPrive() {
		return prendAvionPrivee;
	}
	
	
}
