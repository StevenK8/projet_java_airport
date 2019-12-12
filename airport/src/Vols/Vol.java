package Vols;

import Avions.Avion;
import Personnes.*;

import java.util.ArrayList;
import java.util.List;

public class Vol {

    private Avion avion;
    private String depart;
    private String destination;
    //Heure du vol
    
    public Vol(Avion chAvion, String chDepart, String chDestination) {
    	avion = chAvion;
    	depart = chDepart;
    	destination = chDestination;
    }
    
    public Avion getAvion() {
    	return avion;
    }
    
    public String toString() {
    	return avion.getModele().toString() + " " + depart + " - " + destination;
    }
}
