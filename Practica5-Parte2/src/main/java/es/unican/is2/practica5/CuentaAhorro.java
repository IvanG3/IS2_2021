package es.unican.is2.practica5;

import java.util.LinkedList;
import java.util.List;

public class CuentaAhorro extends Cuenta {

	private List<Movimiento> mMovimientos;
	private double saldo = 0.0;

	public CuentaAhorro(String numCuenta) {  // CC = +1, Ccog = 0
		super(numCuenta);
		mMovimientos = new LinkedList<Movimiento>();
	}

	public void ingresar(double x) throws datoErroneoException {  // CC = +1, Ccog = 0
		if (x <= 0)  // CC = +1, Ccog = +1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		
		crearMovimiento(x, "Ingreso en efectivo");
	}

	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {  // CC = +1, Ccog = 0
		if (x <= 0)  // CC = +1, Ccog = +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		if (getSaldo() < x)  // CC = +1, Ccog = +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		
		crearMovimiento(-x, "Retirada de efectivo");
	}

	public void ingresar(String concepto, double x) throws datoErroneoException {  // CC = +1, Ccog = 0
		if (x <= 0)  // CC = +1, Ccog = +1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		
		crearMovimiento(x, concepto);
	}

	public void retirar(String concepto, double x) throws saldoInsuficienteException, datoErroneoException {  // CC = +1, Ccog = 0
		if (getSaldo() < x)  // CC = +1, Ccog = +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		if (x <= 0)  // CC = +1, Ccog = +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");

		crearMovimiento(-x, concepto);
	}

	@Override
	public double getSaldo() {
		return saldo;
	}

	public void addMovimiento(Movimiento m) {  // CC = +1, Ccog = 0
		mMovimientos.add(m);
		saldo += m.getImporte();
	}

	public List<Movimiento> getMovimientos() {  // CC = +1, Ccog = 0
		return mMovimientos;
	}
	
	private void crearMovimiento(double x, String concepto) {
		Movimiento m = new Movimiento(concepto,x);
		this.mMovimientos.add(m);
		saldo += x;
	}

}