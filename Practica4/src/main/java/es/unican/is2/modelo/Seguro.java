package es.unican.is2.modelo;

import java.util.Date;

enum Cobertura {
	TERCEROS,
	TODORIESGO,
	TERCEROSLUNAS
}

public class Seguro {
	private Date fechaUltimoSiniestro;
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
	
	public void setFechaUltimoSiniestro(Date fecha) {
		this.fechaUltimoSiniestro = fecha;
	}
	
	public Date getFechaUltimoSiniestro() {
		return fechaUltimoSiniestro;
	}
}
