package Avions;

public class AvionDiplomatique extends Avion {

    private String etatProprietaire;

    public AvionDiplomatique(String modele, int personnesMax, double poidsMax, double carburantMax, int pilotesMin, String etat){
        super(modele, personnesMax, poidsMax, carburantMax, pilotesMin);
        etatProprietaire = etat;
    }
}
