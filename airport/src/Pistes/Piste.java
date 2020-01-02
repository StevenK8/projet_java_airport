package Pistes;

import java.util.ArrayList;

import Vols.Vol;

public abstract class Piste {

	protected boolean status = true;
    protected ArrayList<Vol> fileAttente;
    protected final int capacite = 100;
    
    public ArrayList<Vol> getFileAttente(){
    	return fileAttente;
	}
	
	public Vol removeVol(){
		return fileAttente.remove(0);
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
	
	public void closePiste(){
		status = false;
	}

	public boolean isOpened(){
		return status;
	}

	public void openPiste(){
		status = true;
	}
}
