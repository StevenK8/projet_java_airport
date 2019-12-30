package CompagnieAerienne;

import java.util.ArrayList;
import java.util.List;

import Avions.AvionLigne;
import Personnes.Pays;
import Personnes.Personnel;
import Personnes.Pilote;

public class Compagnie {
	private String nomCommercial;
	private Pays nationalite;
	private List<AvionLigne> flotte;
	private List<Pilote> pilotes;
	private List<Personnel> personnelsNavigants;
	
	public Compagnie(String nomCommercial, Pays nationalite) {
		this.nomCommercial = nomCommercial;
		this.nationalite = nationalite;
		flotte = new ArrayList<>();
		pilotes = new ArrayList<>();
		personnelsNavigants = new ArrayList<>();
	}
	
	public void addAvionDansFlotte(AvionLigne avion) {
		flotte.add((AvionLigne)avion);
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
	
	public String toString() {
		return nomCommercial + " " + nationalite;
	}
}
