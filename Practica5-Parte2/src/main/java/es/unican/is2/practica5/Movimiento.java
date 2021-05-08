package es.unican.is2.practica5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Movimiento {
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;

	
	public Movimiento() {    
		this.mFecha = LocalDateTime.of(LocalDate.now(), LocalTime.now());
    }

	public Movimiento(String concepto, double importe) {
		this.mFecha = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		this.mConcepto = concepto;
		this.mImporte = importe;
	}
	
	public double getImporte() {  // CC = +1, Ccog = 0
		return mImporte;
	}

	public String getConcepto() {  // CC = +1, Ccog = 0
		return mConcepto;
	}

	public void setConcepto(String newMConcepto) {  // CC = +1, Ccog = 0
		mConcepto = newMConcepto;
	}

	public LocalDateTime getFechaCaducidad() {  // CC = +1, Ccog = 0
		return mFecha;
	}

	public void setFechaCaducidad(LocalDateTime newMFecha) {  // CC = +1, Ccog = 0
		mFecha = newMFecha;
	}

	public void setImporte(double newMImporte) {  // CC = +1, Ccog = 0
		mImporte = newMImporte;
	}
}