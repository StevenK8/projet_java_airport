package Avions;

import Personnes.Personne;

public class AvionPrivé extends Avion{

    private Personne proprietaire;

    public AvionPrivé(String modele, int personnesMax, int poidsMax, int carburantMax, int pilotesMin){
        super(modele, personnesMax, poidsMax, carburantMax, pilotesMin);
    }
}
