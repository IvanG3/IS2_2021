package es.unican.is2.practica5;

import java.time.LocalDate;

public abstract class Tarjeta {
	protected String mNumero, mTitular;		
	protected CuentaAhorro mCuentaAsociada;
	protected LocalDate fechaCaducidad;

	public Tarjeta(String numero, String titular, CuentaAhorro cuentaAsociada, LocalDate fechaCad) {  // CC = +1, Ccog = 0
		mNumero = numero;
		mTitular = titular;
		mCuentaAsociada = cuentaAsociada;
		fechaCaducidad = fechaCad;
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. 
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	public abstract void retirar(double x) throws saldoInsuficienteException, datoErroneoException;

	/**
	 * Pago en establecimiento con la tarjeta
	 * @param datos Concepto del pago
	 * @param x Cantidada a pagar
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	public abstract void pagoEnEstablecimiento(String datos, double x)
			throws saldoInsuficienteException, datoErroneoException;
	
	public LocalDate getCaducidad() {
		return fechaCaducidad;
	}
	
	public CuentaAhorro getCuentaAsociada(CuentaAhorro cuentaAsociada) {
		return cuentaAsociada;
	}
	
}