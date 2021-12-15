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
 
	public double get_Giorno() {
			return giorno;
	}
	
	public double get_Ora() {
		return ora;
	}
	
	public double get_Minuti() {
		return minuti;
	}
	
	public double get_Secondi() {
		return secondi;
	}
	
	
	
}