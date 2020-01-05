package Vols;

import Avions.Avion;
import Main.Aeroport;
import Personnes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vol {

	/**
	 * @author Damien CHANCEREL & Steven Kerautret
	 */
	
    private Avion avion;
    private Ville depart;
    private Ville destination;
    private Aeroport aeroport;
    
    /**
     * Constructeur de la classe Vol
     * @param chAvion
     * @param pAeroport
     * @param isFromAnotherAirport
     */
    public Vol(Avion chAvion, Aeroport pAeroport, boolean isFromAnotherAirport) {
    	aeroport = pAeroport;
    	avion = chAvion;
    	if(isFromAnotherAirport) {
    		depart = Ville.values()[new Random().nextInt(Ville.values().length)];
        	destination = aeroport.getVille();
    	}
    	else {
    		depart = aeroport.getVille();
        	destination =  Ville.values()[new Random().nextInt(Ville.values().length)];
    	}
    	
    }
    
    /**
     * getter du champ avion
     * @return Avion 
     */
    public Avion getAvion() {
    	return avion;
    }
    
    /**
     * Methode toString
     * @return String
     */
    public String toString() {
    	return "> " + avion.getType() + " " +avion.getModele().toString() + " " + depart + " - " + destination;
    }
}
