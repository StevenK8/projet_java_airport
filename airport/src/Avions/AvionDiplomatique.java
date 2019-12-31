package Avions;

import Main.Aeroport;
import Personnes.Diplomate;
import Personnes.Passager;
import Personnes.Pays;
import Personnes.Personnel;
import Personnes.Pilote;

public class AvionDiplomatique extends Avion {

    private Pays etatProprietaire;
    private int personnelMin;

    public AvionDiplomatique(String modele, int personnesMax, double poidsMax, double carburantMax, int pilotesMin,int pPersonnelMin, Pays etat){
        super(modele, personnesMax, poidsMax, carburantMax, pilotesMin, pPersonnelMin);
        etatProprietaire = etat;
        personnelMin = pPersonnelMin;
    }
    
    public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion diplomatique : " + modele + "\n");
    	res.append("nombre de passagers : " + listPassagers.size() + " (max : " + capacite + ") \n");
    	res.append("nombre de personnels navigants : " + listPersonnels.size() + " (min : " + personnelMin + ") \n");
    	res.append("nombre de pilotes : " + listPilotes.size() + " (min : " + NbPiloteMin + ") \n");
    	res.append("proprietaire : " + etatProprietaire + "\n");
    	return res.toString();
    }
    
    public void remplissageAvion(Aeroport aeroport) {
    	for (Diplomate d : aeroport.getListDiplomates()) {
			this.addDiplomate(d);
		}
		for(Personnel p : aeroport.getListPersonnels()) {
			this.addPersonnel(p);
		}
		for(Pilote p : aeroport.getListPilotes()) {
			this.addPilote(p);
		}
		//System.out.println(this);
    }
    
    public void addDiplomate(Passager p) {
    	super.addPersonne(p);
    }
    
    public void addPersonnel(Personnel p) {
    	if(p.getNationalite() == etatProprietaire) {
    		super.addPersonne(p);
    	}
    }
    
    public void addPilote(Pilote p) {
    	if(p.getNationalite() == etatProprietaire) {
    		super.addPersonne(p);
    	}
    }

	@Override
	public int getPriorite() {
		return 0;
	}

	@Override
	public boolean peutDecoller() {
		if(listPassagers.size() == getNbPassagers()) {
			if(aAssezDePilotes()) {
				return true;
			}
			else {
				System.out.println("Pas assez de pilotes dans " + this.getModele());
				return false;
			}
		}
		else {
			System.out.println("Pas assez de passagers dans " + this.getModele());
			return false;
		}
	}
	
	public Pays getEtatProprietaire() {
		return etatProprietaire;
	}
}
