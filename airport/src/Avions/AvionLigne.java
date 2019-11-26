package Avions;

import CompagnieAerienne.Compagnie;

public class AvionLigne extends Avion{

    private Compagnie compagnie;
    private int personnelMin;

    public AvionLigne(String modele, int personnesMax, int poidsMax, int carburantMax, int pilotesMin, Compagnie compagnie, int personnelMin){
        super(modele, personnesMax, poidsMax, carburantMax, pilotesMin);
        this.compagnie = compagnie;
        this.personnelMin = personnelMin;
    }
    
}
