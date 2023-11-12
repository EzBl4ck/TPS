package es3;

class Auto {
	
	private String nomeString = null;
	private int numeroAuto = 0;
	
	public String getNome() {
		return nomeString;
	}
	public void setNome(String modello) {
		this.nomeString = modello;
	}
	public int getNumeroAuto() {
		return numeroAuto;
	}
	public void setNumeroAuto(int id) {
		this.numeroAuto = id;
	}
	
	@Override
	public String toString() {
		return "Auto: {nome: "+nomeString+", id: "+numeroAuto+"} ";
	}
	
	
}
