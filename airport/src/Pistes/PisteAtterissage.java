package Pistes;

import java.util.ArrayList;
import java.util.Scanner;

import Main.Aeroport;
import Personnes.Pilote;
import Vols.Vol;

public class PisteAtterissage extends Piste{

	private Aeroport aeroport;
	
	public PisteAtterissage(Aeroport pAeroport) {
		fileAttente = new ArrayList<>(capacite);
		aeroport = pAeroport;
	}
	
	@Override
	public void addToQueue(Vol vol) {
		//prendre en compte la priorite de l'avion pour son espacement
		int prio = vol.getAvion().getPriorite();
		double carb = vol.getAvion().getVolumeCarburant();
		boolean ajout = false;
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
					ajout = true;
					break;
				}
				else if(x == 2) {
					System.out.println(vol.toString() + " entre dans la liste d'attente pour atterir en derniere position");
					fileAttente.add(vol);
					ajout = true;
					break;
				}
				sc.close();
			}
		}
    	if(!ajout) {
    		fileAttente.add(vol);
    		System.out.println(vol.toString() + " entre dans la liste d'attente pour atterir en derniere position");
    	}
    	
	}
	
	public void atteritPiste() {
		if(fileAttente.size() != 0) {
			Vol vol =  fileAttente.get(0);
			if(vol.getAvion().estEnVol()) {
				System.out.println(vol.toString() + " atterit");
				vol.getAvion().setEstEnVol(false);
				vol.getAvion().clearAvion(aeroport);
				fileAttente.remove(0);
				aeroport.diminueIntervallePilotes();
			}
			else {
				System.out.println("nope");
			}
		}
	}
}
