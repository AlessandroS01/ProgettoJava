package it.univpm.ProgettoOOP.Model;

public class Time {
	
	private String giorno;
	
	private	int ora;
	
	private int minuti;
 
	public String getGiorno() {
			return giorno;
	}
	
	public int getOra() {
		return ora;
	}
	
	public int getMinuti() {
		return minuti;
	}
	
	public void setGiorno( String giorno) {
		this.giorno = giorno ;
	}
	
	public void setOra ( int ora ) {
		this.ora = ora ;
	}
	
	public void setMinuti ( int minuti ) {
		this.minuti = minuti ;
	}
}