package Pistes;

import java.util.ArrayList;

import Vols.Vol;

public abstract class Piste {

    protected ArrayList<Vol> fileAttente;
    protected final int capacite = 100;
    
    public ArrayList<Vol> getFileAttente(){
    	return fileAttente;
    }
    
    public abstract void addToQueue(Vol vol); 
    
    public void afficheQueue() {
		System.out.println("[");
		int num = 1;
    	for (Vol v : fileAttente) {
			System.out.println("Position "+num+" :\t"+v.toString());
			num++;
		}
		System.out.println("]\n");
    }
}
