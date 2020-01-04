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
    
    public String afficheQueue() {
    	String res = "\n\t[\n\t";
		int num = 1;
    	for (Vol v : fileAttente) {
			res += "Position "+num+" :\t"+v.toString()+ "\n\t";
			num++;
		}
		res += "]\n";
		return res;
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
	
	private int getCapacite() {
		return capacite;
	}
	public boolean isFull() {
		return this.getFileAttente().size() == capacite;
	}
}
