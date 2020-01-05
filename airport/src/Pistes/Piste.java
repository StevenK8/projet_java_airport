package Pistes;

import java.util.ArrayList;

import Vols.Vol;

public abstract class Piste {

	protected boolean status = true;
    protected ArrayList<Vol> fileAttente;
    protected final int capacite = 100;
    
    
	/** 
	 * Renvoie la file d'attente de la piste
	 * @return ArrayList<Vol>
	 */
	public ArrayList<Vol> getFileAttente(){
    	return fileAttente;
	}
	
	
	/** 
	 * Retire et renvoie le premier vol de la file d'attente
	 * @return Vol
	 */
	public Vol removeVol(){
		return fileAttente.remove(0);
	}
    
    
	/** 
	 * @param afficheQueue(
	 */
	public abstract void addToQueue(Vol vol); 
    
    
	/** 
	 * Renvoie le contenu textuel de la file d'attente de la piste
	 * @return String
	 */
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
	
	/**
	 * Définit le statut de la piste comme fermé
	 */
	public void closePiste(){
		status = false;
	}

	
	/** 
	 * Renvoie le statut d'ouverture de la piste
	 * @return boolean
	 */
	public boolean isOpened(){
		return status;
	}

	/**
	 * Définit le statut de la piste comme ouvert
	 */
	public void openPiste(){
		status = true;
	}
	
	
	/**
	 * Vérifie si la capacité totale de la piste est atteinte
	 * 
	 * @return boolean
	 */
	public boolean isFull() {
		return this.getFileAttente().size() == capacite;
	}
}
