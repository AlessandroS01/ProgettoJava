package segreteria;

import java.util.Scanner;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		

		ArrayList <Studente> studentiInformatica = new ArrayList<Studente>();
		ArrayList <Studente> studentiMeccanica = new ArrayList<Studente>();
		
		Corso informatica = new Corso("Informatica", studentiInformatica);
		Corso meccanica = new Corso("Meccanica", studentiMeccanica);
		
		
		System.out.println("Cosa vuoi fare?");
		// Mi voglio iscrivere
		int i = 0;
		do {
		String nome = input.next();
		Studente nuovo = new Studente(nome);
		// quale corso vuoi scegliere?
		
		String corso = input.next();
		
		if(corso.equals("Informatica")){
			informatica.iscriviStudente(nuovo);
			// scegli esami
			informatica.scegliEsami(nuovo);	
		}
		
		if(corso.equals("Meccanica")){
			meccanica.iscriviStudente(nuovo);
			// scegli esami
			meccanica.scegliEsami(nuovo);
		    }
		i++;
		}while (i<2);
		
		informatica.nomiIscritti(studentiInformatica);
		
		
         }
	}

