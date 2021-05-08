package es.unican.is2.practica5;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	public String nombre;
	public Direccion direccion;
	public String telefono;
	public String dni;
	
    private List<Cuenta> Cuentas = new LinkedList<Cuenta>();

 	public Cliente(String titular, Direccion direccion, String telefono, String dni) {  // CC = +1, Ccog = 0
		this.nombre = titular;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
	}
	
	public void cambiaDireccion(Direccion direccion) { // CC = +1, Ccog = 0
		this.direccion = direccion;
	}
	
	public double getSaldoTotal() { // CC = +1, Ccog = 0
		double total = 0.0;
		for (Cuenta c: Cuentas) {  // CC = +1, Ccog = +1
			total += c.getSaldo();
		}
		return total;
	}
	
	public void anhadeCuenta(Cuenta c) { // CC = +1, Ccog = 0
		Cuentas.add(c);
	}
	
}