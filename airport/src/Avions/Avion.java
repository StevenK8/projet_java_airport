package Avions;

public class Avion {

    private String modele;
    private int personnesMax;
    private int poidsMax;
    private int carburantMax;
    private int pilotesMin;

    public Avion(String modele, int personnesMax, int poidsMax, int carburantMax, int pilotesMin){
        this.modele = modele;
        this.personnesMax = personnesMax;
        this.poidsMax = poidsMax;
        this.carburantMax = carburantMax;
        this.pilotesMin = pilotesMin;
    }
}
