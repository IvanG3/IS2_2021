package es.unican.is2.practica5;

import java.time.LocalDate;

public class Debito extends Tarjeta {
	
	private double saldoDiarioDisponible;
	static final int LIMITE_DEBITO = 1000;

	public Debito(String numero, String titular, CuentaAhorro cuentaAsociada, LocalDate fechaCaducidad) {  // CC = +1, Ccog = 0
		super(numero, titular, cuentaAsociada, fechaCaducidad);
	}
	
	
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {  // CC = +1, Ccog = 0
		if (saldoDiarioDisponible<x) {  // CC = +1, Ccog = +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Retirada en cajero automático", x);
		saldoDiarioDisponible-=x;
	}
	
	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException {  // CC = +1, Ccog = 0
		if (saldoDiarioDisponible<x) {  // CC = +1, Ccog = +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Compra en : " + datos, x);
		saldoDiarioDisponible-=x;
	}

	
	/**
	 * Método invocado automáticamente a las 00:00 de cada día
	 */
	public void restableceSaldo() {  // CC = +1, Ccog = 0
		saldoDiarioDisponible = LIMITE_DEBITO;
	}

}