package Pistes;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.Box.Filler;

import Vols.Vol;

public class Piste {

    private boolean onlyDecollage;
    private BlockingQueue<Vol> fileAttente;
    private final int capacite = 100;
    //Espacement
    
    public Piste(boolean decollage) {
    	onlyDecollage = decollage;
    	fileAttente = new ArrayBlockingQueue<Vol>(capacite);
    }
    
    public BlockingQueue<Vol> getQueue(){
    	return fileAttente;
    }
    
    public void addToQueue(Vol vol) {
    	fileAttente.add(vol);
    	System.out.println(vol.toString() + " entre dans la liste d'attente de l'aeroport\n");
    }
    public Vol acceptFlight() {
    	Vol vol =  fileAttente.peek();
    	if(this.onlyDecollage) {
    		if(vol.getAvion().peutDecoller()) {
    			System.out.println(vol.toString() + " decolle");
    			vol.getAvion().setEstEnVol(true);
    			fileAttente.remove();
    		}
    		else {
    			System.out.println(vol.toString() + " ne peut pas décoller car il manque des pilotes");
    		}
    	}
    	else {
    		System.out.println(vol.toString() + " atterit");
			vol.getAvion().setEstEnVol(false);
			vol.getAvion().clearPassagers(); // L’ensemble de leurs passagers evacuent aussitôt l’aéroport, alors que les pilotes de compagnies aériennes demeurent dans l’aéroport.
    		fileAttente.remove();
    	}
    	return vol;
    }
}
