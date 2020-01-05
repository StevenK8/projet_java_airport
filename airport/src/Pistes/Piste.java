package Pistes;

import java.util.ArrayList;

import Vols.Vol;

public abstract class Piste {

	protected boolean status = true;
    protected ArrayList<Vol> fileAttente;
    protected final int capacite = 100;
    
    
	/** 
	 * @return ArrayList<Vol>
	 */
	public ArrayList<Vol> getFileAttente(){
    	return fileAttente;
	}
	
	
	/** 
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
	
	public void closePiste(){
		status = false;
	}

	
	/** 
	 * @return boolean
	 */
	public boolean isOpened(){
		return status;
	}

	public void openPiste(){
		status = true;
	}
	
	
	/** 
	 * @return int
	 */
	private int getCapacite() {
		return capacite;
	}
	
	/** 
	 * @return boolean
	 */
	public boolean isFull() {
		return this.getFileAttente().size() == capacite;
	}
}
