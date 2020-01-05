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
		if(isOpened()){
			//prendre en compte la priorite de l'avion pour son espacement
			int prio = vol.getAvion().getPriorite();
			double carb = vol.getAvion().getVolumeCarburant();
			boolean ajout = false;
			for(int i = 0; i < fileAttente.size(); i++) {
				//priorite : 0-> maximale (avion diplo) 	1-> medium (avionLigne)		 2-> minimale (avionPrive)
				if (fileAttente.get(i).getAvion().getPriorite() > prio || fileAttente.get(i).getAvion().getVolumeCarburant() > carb) {
					//on fait passer devant le vol en parametre
					System.out.println("> " +vol.getAvion().getModele() + " \npriorite : " + vol.getAvion().getType() + "\n carburant : " + carb + "L\n le mettre premiere position de la file d'attente ?" );
					Scanner sc = new Scanner(System.in);
					int x;
					do{
						System.out.println("Oui = 1  Non = 2");
						x = sc.nextInt();
					}while(x != 1 && x != 2);
					if(x == 1) {
						fileAttente.add(i, vol);
						//this.afficheQueue();
						System.out.println(vol.toString() + " entre dans la liste d'attente pour atterir a la position " + i);
						ajout = true;
						break;
					}
					else if(x == 2) {
						fileAttente.add(vol);
						//this.afficheQueue();
						ajout = true;
						break;
					}
					sc.close();
				}
			}
			if(!ajout) {
				fileAttente.add(vol);
				//this.afficheQueue();
			}
    			
		}
	}
public void atteritPiste() {
		if(fileAttente.size() != 0 && isOpened()) {
			Vol vol =  fileAttente.get(0);
			if(vol.getAvion().estEnVol()) {
				System.out.println(vol.toString() + " atterit");
				vol.getAvion().setEstEnVol(false);
				vol.getAvion().clearAvion(aeroport);
				fileAttente.remove(0);
				aeroport.diminueIntervallePilotes();
			}
			else {
				System.out.println("-- L'avion n'est pas en vol! --");
			}
		}
	}
	
	
}
