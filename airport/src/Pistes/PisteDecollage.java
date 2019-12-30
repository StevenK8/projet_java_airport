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
		if(vol.getAvion().peutDecoller()) {
			fileAttente.add(vol);
	    	System.out.println(vol.toString() + " entre dans la liste d'attente pour decoller\n");	
		}	
	}
	
	public void decollePiste() {
		if (fileAttente.size() != 0) {
			Vol vol =  fileAttente.get(0);
			System.out.println(vol.toString() + " decolle");
			vol.getAvion().setEstEnVol(true);
			fileAttente.remove(0);
		}
		
	}
}
