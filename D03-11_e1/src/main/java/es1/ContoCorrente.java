package es1;

class ContoCorrente {
	
	private float saldo;
	
	public ContoCorrente() {
		saldo = 0;
	}
	
	public synchronized void deposita(float value) {
		saldo += value;
	}
	
	public synchronized void preleva(float value) {
		if(saldo - value >= 0)
			saldo -= value;
	}
	
	public double getSaldo() {
		return saldo;
	}
}
