package es;

public class Libro {
	private int id;
	private String titolo;
	private String autore;
	
	public Libro() {}
	
	public int getId() {
		return id;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public String getAutore() {
		return autore;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public void setAutore(String autore) {
		this.autore = autore;
	}
	
	@Override
	public String toString() {
		return "Libro [id = " + id + ", titolo = "+ titolo + ", autore = " + autore + "]";
	}
	
}
