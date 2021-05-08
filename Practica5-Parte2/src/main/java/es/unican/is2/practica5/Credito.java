package es.unican.is2.practica5;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


public class Credito extends Tarjeta {

	private double mCredito;
	private List<Movimiento> mMovimientosMensuales;
	private List<Movimiento> mhistoricoMovimientos;
	private double gastosAcumulados;


	public Credito(String numero, String titular, CuentaAhorro cuentaAsociada, double credito, LocalDate fechaCaducidad) { // CC = +1, Ccog = 0
		super(numero, titular, cuentaAsociada, fechaCaducidad);
		mCredito = credito;
		mMovimientosMensuales = new LinkedList<Movimiento>();
		mhistoricoMovimientos = new LinkedList<Movimiento>();
		this.gastosAcumulados = 0.0;
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param cantidad Cantidad a retirar. Se aplica una comisión del 5%.
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	@Override
	public void retirar(double cantidad) throws saldoInsuficienteException, datoErroneoException { // CC = +1, Ccog = 0
		if (cantidad<0)	// CC = +1, Ccog = +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");

		cantidad += cantidad * 0.05; // Añadimos una comisión de un 5%

		if (getGastosAcumulados()+cantidad > mCredito) // CC = +1, Ccog = +1 TODO
			throw new saldoInsuficienteException("Crédito insuficiente");
		else {
			Movimiento movimiento = new Movimiento("Retirada en cajero automático",-cantidad);
			mMovimientosMensuales.add(movimiento);
            gastosAcumulados += cantidad;
		}
	}

	@Override
	public void pagoEnEstablecimiento(String datos, double cantidad) throws saldoInsuficienteException, datoErroneoException { // CC = +1, Ccog = 0
		if (cantidad<0)  // CC = +1, Ccog = +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");

		if (getGastosAcumulados() + cantidad > mCredito)  // CC = +1, Ccog = +1 TODO
			throw new saldoInsuficienteException("Saldo insuficiente");

		Movimiento m = new Movimiento("Compra a crédito en : " + datos, -cantidad);
		mMovimientosMensuales.add(m);
		gastosAcumulados += cantidad;
	}

	public double getGastosAcumulados() { // CC = +1, Ccog = 0
		return gastosAcumulados;
	}

	/**
	 * Método que se invoca automáticamente el día 1 de cada mes
	 */
	public void liquidar() {  // CC = +1, Ccog = 0
		Movimiento movimiento = new Movimiento();
		movimiento.setConcepto("Liquidación de operaciones tarjeta crédito");
		double cantidad = 0.0;
		for (int i = 0; i < this.mMovimientosMensuales.size(); i++) {  // CC = +1, Ccog = +1
			Movimiento movimientoAux = (Movimiento) mMovimientosMensuales.get(i);
			cantidad += movimientoAux.getImporte();
		}
		movimiento.setImporte(cantidad);

		if (cantidad != 0) // CC = +1, Ccog = +1
			mCuentaAsociada.addMovimiento(movimiento);

		mhistoricoMovimientos.addAll(mMovimientosMensuales);
		mMovimientosMensuales.clear();
		gastosAcumulados = 0;
	}

	public List<Movimiento> getMovimientosUltimoMes() { // CC = +1, Ccog = 0
		return mMovimientosMensuales;
	}

	public List<Movimiento> getMovimientos() { // CC = +1, Ccog = 0
		return mhistoricoMovimientos;
	}

}