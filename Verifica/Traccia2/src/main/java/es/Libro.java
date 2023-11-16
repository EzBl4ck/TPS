package es;

public class Libro {
	private String codice;
	private String titolo;
	private String casaEditrice;
	
	public Libro() {
		this.codice = "";
		this.titolo = "";
		this.casaEditrice = "";
	}
	
	public Libro(String codice, String titolo, String casaEditrice) {
		this.codice = codice;
		this.titolo = titolo;
		this.casaEditrice = casaEditrice;
	}
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getCasaEditrice() {
		return casaEditrice;
	}
	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}
	
	@Override
	public String toString() {
		return "Libro [ codice: "+codice+", titolo: "+titolo+", Casa Editrice: "+casaEditrice+" ]";
	}
	
}
