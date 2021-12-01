package segreteria;
import java.util.Scanner;
import java.util.ArrayList;
public class Corso {
	
	
	ArrayList <Studente> iscritti = new ArrayList<Studente>();
	
	protected String nome_corso;
	
	private int numeroDiIscritti = 0;
	
	
	public Corso(String nome_corso, ArrayList <Studente> iscritti ) 
	{
		this.nome_corso = nome_corso;
		
	}
     
	
	
	public void iscriviStudente(Studente p) {
		iscritti.add(p);
		numeroDiIscritti++;	
	}

	public int iscritti() {
		return numeroDiIscritti;	
	    }

	public void scegliEsami (Studente p) {
		Scanner input = new Scanner(System.in);
		if(nome_corso.equals("Informatica")) {
			System.out.println("Scegli 1 materia");
			int d= input.nextInt();
			int i = 0;
			switch(d) {
			case 1:Esami q = new Esami("Analisi", 9); 
				   p.getEsami(q);
				   i++;
				   break;
			case 2:Esami s = new Esami("Fondamenti", 9);
			       p.getEsami(s);
			       i++;
			       break;
			} while(i<1);
			
			if(nome_corso.equals("Meccanica")) {
				System.out.println("Scegli 1 materia");
				int f= input.nextInt();
				int g = 0;
				switch(f) {
				case 1:Esami q = new Esami("Analisi", 9); 
					   p.getEsami(q);
					   g++;
					   break;
				case 2:Esami s = new Esami("Fondamenti", 9);
				       p.getEsami(s);
				       g++;
				       break;
				} while(g<1);
			
			input.close();
			
			}
			
		}
		
	}
    
	public void nomiIscritti(ArrayList <Studente> iscritti) {
		String[] nomi = new String[100];
		for(int i = 0; i< iscritti.size(); i++) {
			nomi[i]	= iscritti.get(i).getNome();
			System.out.println(nomi[i]);
		}
		
		
	}
}
		
	
	
     


