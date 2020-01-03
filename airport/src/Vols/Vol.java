package Vols;

import Avions.Avion;
import Main.Aeroport;
import Personnes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vol {

    private Avion avion;
    private Ville depart;
    private Ville destination;
    private Aeroport aeroport;
    
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
    
    public Avion getAvion() {
    	return avion;
    }
    
    public String toString() {
    	return avion.getModele().toString() + " " +avion.getType() +  " " + depart + " - " + destination;
    }
}
