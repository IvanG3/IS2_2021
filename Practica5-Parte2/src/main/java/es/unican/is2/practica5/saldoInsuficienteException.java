package es.unican.is2.practica5;

@SuppressWarnings("serial")
public class saldoInsuficienteException extends RuntimeException {

	public saldoInsuficienteException (String mensaje) {  // CC = +1, Ccog = 0
		super(mensaje);
	}
}
