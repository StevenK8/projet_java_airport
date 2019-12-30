package Pistes;

import java.util.ArrayList;
import java.util.Scanner;
import Vols.Vol;

public class PisteAtterissage extends Piste{

	public PisteAtterissage() {
		fileAttente = new ArrayList<>(capacite);
	}
	
	@Override
	public void addToQueue(Vol vol) {
		//prendre en compte la priorite de l'avion pour son espacement
		int prio = vol.getAvion().getPriorite();
		double carb = vol.getAvion().getVolumeCarburant();
		boolean ok = false;
		for(int i = 0; i < fileAttente.size(); i++) {
			//priorite : 0-> maximale (avion diplo) 	1-> medium (avionLigne)		 2-> minimale (avionPrive)
			if (fileAttente.get(i).getAvion().getPriorite() > prio || fileAttente.get(i).getAvion().getVolumeCarburant() > carb) {
				//on fait passer devant le vol en parametre
				System.out.println(vol.getAvion().getModele() + " priorite : " + prio + " | carburant : " + carb + "L, le mettre en position n° " + i + " de la file d'attente ?" );
				Scanner sc = new Scanner(System.in);int x;
				do{
					System.out.println("Oui = 1  Non = 2");
					x = sc.nextInt();
				}while(x != 1 && x != 2);
				if(x == 1) {
					fileAttente.add(i, vol);
					System.out.println(vol.toString() + " entre dans la liste d'attente pour atterir à  la position " + i);
					ok = true;
					break;
				}
				else if(x == 2) {
					System.out.println(vol.toString() + " entre dans la liste d'attente pour atterir en derniere position");
					break;
				}
				sc.close();
				
			}
		}
    	if(!ok) {
    		fileAttente.add(vol);
    		System.out.println(vol.toString() + " entre dans la liste d'attente pour atterir en derniere position");
    	}
    	
	}
	
	public void atteritPiste() {
		if(fileAttente.size() != 0) {
			Vol vol =  fileAttente.get(0);
			System.out.println(vol.toString() + " atterit");
			vol.getAvion().setEstEnVol(false);
			vol.getAvion().clearPassagers();
			fileAttente.remove(0);
		}
		
	}
}
