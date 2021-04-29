package es.unican.is2.modelo;

import java.time.LocalDate;

public class Seguro {
	private LocalDate fechaUltimoSiniestro;
	private int potenciaCV;
	private Cobertura cobertura;
	private Cliente tomadorSeguro;

	public Seguro(int potencia, Cliente cliente, Cobertura cobertura) throws DatoIncorrectoException {
		if (potencia <= 0 || cliente == null || cobertura == null) {
			throw new DatoIncorrectoException();
		}
		this.potenciaCV = potencia;
		this.tomadorSeguro = cliente;
		this.cobertura = cobertura;
	}

	public double precio() {
		double precio = 0;
		switch (cobertura) {
		case TODORIESGO:
			precio = 1000;
			break;
		case TERCEROSLUNAS:
			precio = 600;
			break;
		case TERCEROS:
			precio = 400;
			break;
		default:
			break;
		}
		
		if (potenciaCV >= 90 && potenciaCV <= 110) {
			precio = precio * 1.05;
		} else if (potenciaCV > 110) {
			precio = precio * 1.20;
		}
		
		if (fechaUltimoSiniestro.isAfter(LocalDate.now().minusYears(1).minusDays(1))) {
			precio = precio + 200;
		} else if (fechaUltimoSiniestro.isAfter(LocalDate.now().minusYears(3).minusDays(1))) {
			precio = precio + 50;
		}

		if (tomadorSeguro.getMinusvalia()==true) {
			precio = precio * 0.75;
		}
		
		return precio;
	}

	public void setFechaUltimoSiniestro(LocalDate fecha) throws DatoIncorrectoException {
		if (fecha.isAfter(LocalDate.now())) {
			throw new DatoIncorrectoException();
		}
		this.fechaUltimoSiniestro = fecha;
	}

	public LocalDate getFechaUltimoSiniestro() {
		return fechaUltimoSiniestro;
	}
}
