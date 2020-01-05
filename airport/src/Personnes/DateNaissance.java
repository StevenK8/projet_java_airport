package Personnes;

import java.util.Random;

public class DateNaissance {

	private int jour;
	private int mois;
	private int annee;
	
	public DateNaissance(int jour, int mois, int annee) {
		this.annee = annee;
		this.mois = mois;
		this.jour = jour;
	}

	/**
	 * Crée une date de naissance aléatoire
	 */
	public DateNaissance() {
		Random r = new Random();
		jour = r.nextInt(31-1) + 1;
		mois = r.nextInt(12-1)+1;
		annee = r.nextInt(2020-1930) + 1930;
	}
}
