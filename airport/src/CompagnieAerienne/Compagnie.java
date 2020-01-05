package CompagnieAerienne;

import java.util.ArrayList;
import java.util.List;

import Avions.AvionLigne;
import Personnes.Pays;
import Personnes.Personnel;
import Personnes.Pilote;

public class Compagnie {
	private EnumCompagnie nomCommercial;
	private Pays nationalite;
	private List<AvionLigne> flotte;
	private List<Pilote> pilotes;
	private List<Personnel> personnelsNavigants;
	
	public Compagnie(EnumCompagnie nomCommercial, Pays nationalite) {
		this.nomCommercial = nomCommercial;
		this.nationalite = nationalite;
		flotte = new ArrayList<>();
		pilotes = new ArrayList<>();
		personnelsNavigants = new ArrayList<>();
	}
	
	
	/** 
	 * @param avion
	 */
	public void addAvionDansFlotte(AvionLigne avion) {
		flotte.add((AvionLigne)avion);
	}
	
	
	/** 
	 * @param avion
	 */
	public void removeAvion(AvionLigne avion) {
		flotte.remove(avion);
	}
	
	
	/** 
	 * @param pilote
	 */
	public void addPilote(Pilote pilote) {
		pilotes.add(pilote);
	}
	
	/** 
	 * @param pilote
	 */
	public void removePilote(Pilote pilote) {
		pilotes.remove(pilote);
	}
	
	
	/** 
	 * @param personnel
	 */
	public void addPersonnel(Personnel personnel) {
		personnelsNavigants.add(personnel);
	}
	
	
	/** 
	 * @param personnel
	 */
	public void removePersonnel(Personnel personnel) {
		personnelsNavigants.remove(personnel);
	}
	
	
	/** 
	 * @return List<AvionLigne>
	 */
	public List<AvionLigne> getListAvions(){
		return flotte;
	}
	
	
	/** 
	 * @return List<Pilote>
	 */
	public List<Pilote> getListPilotes(){
		return pilotes;
	}
	
	
	/** 
	 * @return List<Personnel>
	 */
	public List<Personnel> getListPersonnel(){
		return personnelsNavigants;
	}
	
	
	/** 
	 * @return String
	 */
	public String toString() {
		return nomCommercial + " " + nationalite;
	}
}
