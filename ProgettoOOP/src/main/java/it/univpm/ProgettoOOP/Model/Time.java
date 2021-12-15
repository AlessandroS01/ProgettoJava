package it.univpm.ProgettoOOP.Model;

public class Time {
	
	private double giorno;
	
	private	double ora;
	
	private double minuti;
	
	private double secondi;
	
	
	public Time(double giorno, double ora, double minuti, double secondi) {
		this.giorno = giorno;
		this.ora = ora;
		this.minuti = minuti;
		this.secondi = secondi;
		}
 
	public double getGiorno() {
			return giorno;
	}
	
	public double getOra() {
		return ora;
	}
	
	public double getMinuti() {
		return minuti;
	}
	
	public double getSecondi() {
		return secondi;
	}
	
	
	
}