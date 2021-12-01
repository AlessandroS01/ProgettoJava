package segreteria;

public class Esami  {

	private String nomeEsami;
	private int numeroDiCrediti;
	
	
	public Esami(String nomeEsami, int numeroDiCrediti) {
		this.nomeEsami = nomeEsami;
		this.numeroDiCrediti = numeroDiCrediti;
	}
	
	public String nomeEsame() {
		return  nomeEsami;		
	}
    
	public int numeroCrediti() {
		return numeroDiCrediti;
	}
    
	
	
}
