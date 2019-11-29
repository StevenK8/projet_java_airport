package Personnes;

import Avions.Avion;
import Avions.AvionDiplomatique;

public class Pilote extends Passager{

	//Travaille pour compagnie ou entreprise ou etat
	private int passagersMax;
	//Intervalle (temps de pause)

	public Pilote(String prenom, String nom, DateNaissance dateNaissance, String nationalite, int numPasseport) {
		super(prenom, nom, dateNaissance, nationalite, numPasseport);
		// TODO Auto-generated constructor stub
	}
}
