package Avions;

import java.util.ArrayList;
import java.util.List;

import CompagnieAerienne.Compagnie;
import Personnes.Passager;

public class AvionLigne extends Avion{
	private Compagnie compagnieProprietaire;
	private int nbPersonnelsMin;
	private List<Passager> listPassagers;
	
	public AvionLigne(String m, int capa, double pdsMax, double volCarburant,int nbPilMin, Compagnie c, int nbPersonnel) {
		modele = m;
		capacite = capa;
		poidsBagageMax = pdsMax;
		volumeCarburant = volCarburant;
		NbPiloteMin = nbPilMin;
		compagnieProprietaire = c;
		nbPersonnelsMin = nbPersonnel;
		listPassagers = new ArrayList<Passager>();
	}
	
	public List<Passager> getListPassagers(){
		return listPassagers;
	}
	
	public void addPassager(Passager passager) {
		if(listPassagers.size() < capacite) {
			listPassagers.add(passager);
		}
		else {
			System.out.println("Plus de places dans cet avion !");
		}
	}
	public void removePassager(Passager passager) {
		listPassagers.remove(passager);
	}
	public void clearAvion() {
		listPassagers.clear();
	}
}
