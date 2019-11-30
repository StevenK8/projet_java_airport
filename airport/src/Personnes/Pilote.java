package Personnes;

import Avions.Avion;

public class Pilote extends Passager{

	//Travaille pour compagnie ou entreprise ou etat
	private int passagersMax;
	//Intervalle (temps de pause)

	public Pilote(String prenom, String nom, DateNaissance dateNaissance, String nationalite, int numPasseport, int passagersMax) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport);
		this.passagersMax = passagersMax;
		// TODO Auto-generated constructor stub
	}

	public int getPassagersMax(){
		return passagersMax;
	}

	public boolean estQualifié(Avion avion){
		if(avion.getNbPassagers()<=passagersMax){
			return true;
		}
		return false;
	}
}
