package es.unican.is2.practica5;

@SuppressWarnings("serial")
public class datoErroneoException extends RuntimeException {
	
	public datoErroneoException (String mensaje) {  // CC = +1, Ccog = 0
		super(mensaje);
	}

}
