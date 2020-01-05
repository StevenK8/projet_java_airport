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
	 * @return boolean
	 */
	public boolean estEnVol() {
		return super.estEnVol();
	}
	
	
	/** 
	 * @return boolean
	 */
	public boolean getPrendAvionPrive() {
		return prendAvionPrivee;
	}
	
	/** 
	 * @param pPrendAvionprive
	 */
	public void setPrendAvionPrive(boolean pPrendAvionprive) {
		prendAvionPrivee = pPrendAvionprive;
	}
	
	
	/** 
	 * @return String
	 */
	public String toString() {
		String res= "";
		res += super.toString();
		return res;
	}
	
	public void setNumeroVol(int num) {
		numeroVol = num;
	}
	
	public int getNumeroVol() {
		return numeroVol;
	}
	
}
