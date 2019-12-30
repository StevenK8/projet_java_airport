package CompagnieAerienne;

import java.util.ArrayList;
import java.util.List;

import Avions.AvionLigne;
import Personnes.Personnel;
import Personnes.Pilote;

public class Compagnie {
	private String nomCommercial;
	private String nationalite;
	private List<AvionLigne> flotte;
	private List<Pilote> pilotes;
	private List<Personnel> personnelsNavigants;
	
	public Compagnie(String nomCommercial, String nationalite) {
		this.nomCommercial = nomCommercial;
		this.nationalite = nationalite;
		flotte = new ArrayList<>();
		pilotes = new ArrayList<>();
		personnelsNavigants = new ArrayList<>();
	}
	
	public void addAvionDansFlotte(Object avion) {
		if(avion instanceof AvionLigne) {
			flotte.add((AvionLigne)avion);
		}
		else {
			System.out.println("L'avion ne peut pas être ajouté dans la flotte car ce n'est pas un avion de ligne\n");
		}
	}
	
	public void removeAvion(AvionLigne avion) {
		flotte.remove(avion);
	}
	
	public void addPilote(Pilote pilote) {
		pilotes.add(pilote);
	}
	public void removePilote(Pilote pilote) {
		pilotes.remove(pilote);
	}
	
	public void addPersonnel(Personnel personnel) {
		personnelsNavigants.add(personnel);
	}
	
	public void removePersonnel(Personnel personnel) {
		personnelsNavigants.remove(personnel);
	}
	
	public List<AvionLigne> getListAvions(){
		return flotte;
	}
	
	public List<Pilote> getListPilotes(){
		return pilotes;
	}
	
	public List<Personnel> getListPersonnel(){
		return personnelsNavigants;
	}
	
	public void setNomCommercial(String newName) {
		nomCommercial = newName;
	}
	
	public void setNationalite(String newNationalite) {
		nationalite = newNationalite;
	}
	
	public String toString() {
		return nomCommercial + " " + nationalite;
	}
}
