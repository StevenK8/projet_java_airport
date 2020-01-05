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

    public AvionDiplomatique(EnumModele modele, int personnesMax, double poidsMax, double carburantMax, int pilotesMin,int pPersonnelMin, Pays etat){
        super(modele, personnesMax, poidsMax, carburantMax, pilotesMin, pPersonnelMin);
        etatProprietaire = etat;
        personnelMin = pPersonnelMin;
    }
    
    
	/**
	 * Méthode toString renvoie la texte d'information de l'avion diplomatique
	 * @return String
	 */
	public String toString() {
    	StringBuilder res = new StringBuilder();
    	res.append("Avion diplomatique : " + modele + "\n");
    	res.append(super.toString());
    	res.append("proprietaire : " + etatProprietaire + "\n");
    	return res.toString();
    }
    
    
	/** 
	 * Remplit l'avion diplomatique de diplomates
	 * @param aeroport
	 */
	public void remplissageAvion(Aeroport aeroport) {
    	for (Diplomate d : aeroport.getListDiplomates()) {
			this.addDiplomate(d);
			d.setNumeroVol(numVol);
		}
		for(Personnel p : aeroport.getListPersonnels()) {
			this.addPersonnel(p);
			p.setNumeroVol(numVol);
		}
		for(Pilote p : aeroport.getListPilotes()) {
			this.addPilote(p);
			p.setNumeroVol(numVol);
		}
		//System.out.println(this);
    }
    
    
	/** 
	 * Ajoute un passager à l'avion diplomatique
	 * @param p
	 */
	public void addDiplomate(Passager p) {
    	super.addPersonne(p);
    }
    
    
	/** 
	 * Ajoute un personnel à l'avion s'il est de la nationalité de l'état propriétaire de l'avion
	 * @param p
	 */
	public void addPersonnel(Personnel p) {
    	if(p.getNationalite() == etatProprietaire) {
    		super.addPersonne(p);
    	}
    }
    
    
	/** 
	 * Ajoute un pilote à l'avion s'il est de la nationalité de l'état propriétaire de l'avion
	 * @param p
	 */
	public void addPilote(Pilote p) {
    	if(p.getNationalite() == etatProprietaire) {
    		super.addPersonne(p);
    	}
    }

	
	/** 
	 * Renvoie la priorité de l'avion diplomatique (0)
	 * @return int
	 */
	public int getPriorite() {
		return 0;
	}

	
	/** 
	 * Vérifie si l'avion remplit les conditions pour décoller
	 * @return boolean
	 */
	public boolean peutDecoller() {
		if(listPassagers.size() == getNbPassagers()) {
			if(aAssezDePilotes()) {
				if(getPeriodeImmobilisation()==0)
					return true;
				return false;
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
	
	
	/** 
	 * Renvoie le pays propriétaire de l'avion
	 * @return Pays
	 */
	public Pays getEtatProprietaire() {
		return etatProprietaire;
	}
}
