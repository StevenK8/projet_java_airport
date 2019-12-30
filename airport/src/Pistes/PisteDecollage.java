package Pistes;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import Vols.Vol;

public class PisteDecollage extends Piste{

	public PisteDecollage() {
		fileAttente = new ArrayList<>(capacite);
	}

	@Override
	public void addToQueue(Vol vol) {
		//prendre en compte la priorite de l'avion pour son espacement
    	fileAttente.add(vol);
    	System.out.println(vol.toString() + " entre dans la liste d'attente de l'aeroport\n");		
	}
	
	public void DecollePiste() {
		Vol vol =  fileAttente.get(0);
		System.out.println(vol.toString() + " decolle");
		vol.getAvion().setEstEnVol(true);
		fileAttente.remove(0);
	}
}
