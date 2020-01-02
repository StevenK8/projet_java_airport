package Pistes;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import Vols.Vol;

public class PisteDecollage extends Piste{

	private int intervalleDecollage;
	
	public PisteDecollage() {
		fileAttente = new ArrayList<>(capacite);
		intervalleDecollage = 1;
	}

	@Override
	public void addToQueue(Vol vol) {
		//prendre en compte la priorite de l'avion pour son espacement
		if(vol.getAvion().peutDecoller()) {
			fileAttente.add(vol);
	    	System.out.println(vol.toString() + " entre dans la liste d'attente pour decoller\n");	
		}	
	}
	
	public boolean decollePiste() {
		if(intervalleDecollage == 0) {
			if (fileAttente.size() != 0) {
				Vol vol =  fileAttente.get(0);
				System.out.println(vol.toString() + " decolle");
				vol.getAvion().setEstEnVol(true);
				fileAttente.remove(0);
				if(vol.getAvion().getPriorite() == 0) {
					//avion diplomatique
					intervalleDecollage = 1;
				}
				else if(vol.getAvion().getPriorite() == 1) {
					//avion de ligne
					intervalleDecollage = 2;
				}
				else {
					//avion prive
					intervalleDecollage = 3;
				}
				System.out.println("\n[Intervalle = " + intervalleDecollage +"]");
				return true;
			}
			else {
				System.out.println("Auncun avion dans la file dattente");
				return false;
			}
		}
		else {
			System.out.println("> Intervalle : " + intervalleDecollage);
			return false;
		}
	}
	
	public int getIntervalleDecollage() {
		return intervalleDecollage;
	}
	public void diminueIntervalleDecollage() {
		if(intervalleDecollage > 0) {
			intervalleDecollage -= 1;
		}
	}
}
