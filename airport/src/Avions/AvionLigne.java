package Avions;

import java.util.ArrayList;
import java.util.List;

import CompagnieAerienne.Compagnie;
import Personnes.Passager;

public class AvionLigne extends Avion{
	private Compagnie compagnieProprietaire;
	private int nbPersonnelsMin;
	private List<Passager> listPassagers;
	
	public AvionLigne(String modele, int capacite, double poidsBagageMax, double volumeCarburant,int NbPiloteMin, Compagnie c, int nbPersonnel) {
        super(modele, capacite, poidsBagageMax, volumeCarburant, NbPiloteMin);
		compagnieProprietaire = c;
		nbPersonnelsMin = nbPersonnel;
		listPassagers = new ArrayList<Passager>();
	}
	
	public List<Passager> getListPassagers(){
		return listPassagers;
	}
	
	public void addPassager(Passager passager) {
		if(listPassagers.size() < capacite && !passager.estEnVol()) {
			listPassagers.add(passager);
			passager.setEstEnVol(true);
		}
		else {
			System.out.println("Plus de places dans cet avion !");
		}
	}
	public void removePassager(Passager passager) {
		listPassagers.remove(passager);
		passager.setEstEnVol(false);
	}
	public void clearAvion() {
		listPassagers.forEach(passager ->{
			passager.setEstEnVol(false);
		});
		listPassagers.clear();
	}
	
	public boolean peutDecoller() {
		return this.capacite == listPassagers.size();
	}
	
	public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion de ligne : " + modele + "\n");
    	res.append("nombre de passagers : " + listPassagers.size() + " (max : " + capacite + ") \n");
    	res.append("proprietaire : " + compagnieProprietaire + "\n");
    	return res.toString();
    }
}
