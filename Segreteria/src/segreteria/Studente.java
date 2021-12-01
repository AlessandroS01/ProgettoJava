package segreteria;

import java.util.ArrayList;

public class Studente {

	ArrayList <Esami> esamiScelti = new ArrayList<Esami>();
	
	private String nome;
	
	private int matricola = 0;
	
	private int crediti = 0;
	
	public Studente(String nome) {
		
		this.nome = nome;
		matricola++;
		
	}
	
	public String getNome() {
		return this.nome;	
	}

	public int getMatricola() {

		return matricola;
	}
	
	public int getCrediti() {
		return crediti;	
	}

	
	public void  getEsami(Esami p) {
		esamiScelti.add(p);
	}
    


}
