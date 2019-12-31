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
    
    public Vol(Avion chAvion, Aeroport pAeroport) {
    	aeroport = pAeroport;
    	avion = chAvion;
    	depart = aeroport.getVille();
    	destination =  Ville.values()[new Random().nextInt(Ville.values().length)];
    }
    
    public Avion getAvion() {
    	return avion;
    }
    
    public String toString() {
    	return avion.getModele().toString() + " " +avion.getType() +  " " + depart + " - " + destination;
    }
}
