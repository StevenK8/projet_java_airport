package Avions;

public class AvionDiplomatique extends Avion {

    private String etatProprietaire;

    public AvionDiplomatique(String modele, int personnesMax, int poidsMax, int carburantMax, int pilotesMin){
        super(modele, personnesMax, poidsMax, carburantMax, pilotesMin);
    }
}
