package Personnes;

public class Passager extends Personne{
	
	private int numPasseport = 0;
	private int numeroVol;
	private boolean prendAvionPrivee = false;
	
	//constructeur temporaire
	public Passager(EnumPrenom prenom, EnumNom nom, DateNaissance dateNaissance, Pays nationalite, boolean pPrendAvionPrive) {
		super(prenom, nom, dateNaissance, nationalite);
		this.numPasseport = numPasseport + 1;
		prendAvionPrivee = pPrendAvionPrive;
	}

	
	/** 
	 * Renvoie le statut de vol du passager
	 * @return boolean
	 */
	public boolean estEnVol() {
		return super.estEnVol();
	}
	
	
	/** 
	 * Renvoie si ou non le passager voyage en avion privé
	 * @return boolean
	 */
	public boolean getPrendAvionPrive() {
		return prendAvionPrivee;
	}
	
	/** 
	 * Définit si le passager voyage en avion privé
	 * @param pPrendAvionprive
	 */
	public void setPrendAvionPrive(boolean pPrendAvionprive) {
		prendAvionPrivee = pPrendAvionprive;
	}
	
	
	/** 
	 * Renvoie les informations textuelles du passager
	 * @return String
	 */
	public String toString() {
		String res= "";
		res += super.toString();
		return res;
	}
	
	/**
	 * Definit le numero de vol du passager
	 * @param num
	 */
	public void setNumeroVol(int num) {
		numeroVol = num;
	}
	
	/**
	 * renvoit le numero de vol du passager
	 * @return int
	 */
	public int getNumeroVol() {
		return numeroVol;
	}
	
}
