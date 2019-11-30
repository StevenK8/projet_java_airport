package Avions;

import Personnes.Passager;
import Personnes.Pilote;

import java.util.ArrayList;
import java.util.List;

public abstract class Avion {
	protected String modele;
	protected int capacite;
	protected double poidsBagageMax;
	protected double volumeCarburant;
	protected int NbPiloteMin;
	public List<Passager> listPassagers;
	
    public Avion(String modele, int capacite, double poidsBagageMax, double volumeCarburant, int NbPiloteMin){
        this.modele = modele;
        this.capacite = capacite;
        this.poidsBagageMax = poidsBagageMax;
        this.volumeCarburant = volumeCarburant;
		this.NbPiloteMin = NbPiloteMin;
		listPassagers = new ArrayList<Passager>();
	}	
		
	public List<Passager> getlistPassagers(){
		return listPassagers;
	}
	
	public void addPersonne(Passager passager) {
		if(listPassagers.size() < capacite && !passager.estEnVol()) {
			listPassagers.add(passager);
			passager.setEstEnVol(true);
		}
		else {
			System.out.println("Plus de places dans cet avion !");
		}
	}
	public void removePersonne(Passager passager) {
		listPassagers.remove(passager);
		passager.setEstEnVol(false);
	}
	public void clearAvion() {
		listPassagers.forEach(passager ->{
			passager.setEstEnVol(false);
		});
		listPassagers.clear();
	}

	public boolean aAssezDePilotes(){
		int countPilotes = 0;
		for (Passager p:this.getlistPassagers()){
			if(p instanceof Pilote){
				countPilotes++;
			}
		}
		if (countPilotes >= NbPiloteMin){
			return true;
		}
		return false;
	}
	
	public boolean peutDecoller() {
		return this.capacite == listPassagers.size() && aAssezDePilotes();
	}

	public String getModele() {
		return modele;
	}
	public int getCapacite() {
		return capacite;
	}
	public double getPoidsBagageMax() {
		return poidsBagageMax;
	}
	public double getVolumeCarburant() {
		return volumeCarburant;
	}
	public int getNbPiloteMin() {
		return NbPiloteMin;
	}
}
