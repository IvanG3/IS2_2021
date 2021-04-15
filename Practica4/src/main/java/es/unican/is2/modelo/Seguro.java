package es.unican.is2.modelo;

import java.time.LocalDate;

enum Cobertura {
	TERCEROS,
	TODORIESGO,
	TERCEROSLUNAS
}

public class Seguro {
	private LocalDate fechaUltimoSiniestro;
	private int potenciaCV;
	private Cobertura cobertura;
	private Cliente tomadorSeguro;
	
	public Seguro(int potencia, Cliente cliente, Cobertura cobertura) {
		this.potenciaCV = potencia;
		this.tomadorSeguro = cliente;
		this.cobertura = cobertura;
	}
	
	public double precio() {
		double precio = 10;
		return precio;
	}
	
	public void setFechaUltimoSiniestro(LocalDate fecha) {
		this.fechaUltimoSiniestro = fecha;
	}
	
	public LocalDate getFechaUltimoSiniestro() {
		return fechaUltimoSiniestro;
	}
}

/**try {
	seguro = new Seguro(1, clienteConMinusvalia, Cobertura.TERCEROS_LUNAS);
	assertTrue();
}

@Test
public void testPrecio() {
	try {
		seguro = new Seguro(1, clienteConMinusvalia, Cobertura.TERCEROS);
		seguro.setFecha(LocalDate.now().minusYears(3).minusDays(1))
	} catch (Exception e) {
		fail("Lanza excepcion");
	}
}*/
