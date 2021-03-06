package es.unican.is2.practica5;

public abstract class Cuenta {

	private String numCuenta;

	public Cuenta(String numCuenta) {  // CC = +1, Ccog = 0
		this.numCuenta = numCuenta;
	}

	public String getNumCuenta() {  // CC = +1, Ccog = 0
		return numCuenta;
	}

	public abstract double getSaldo();

}
