package es.unican.is2.practica5;

import java.time.LocalDateTime;

public class Movimiento {
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;

	public double getI() {  // CC = +1, Ccog = 0
		return mImporte;
	}

	public String getC() {  // CC = +1, Ccog = 0
		return mConcepto;
	}

	public void setC(String newMConcepto) {  // CC = +1, Ccog = 0
		mConcepto = newMConcepto;
	}

	public LocalDateTime getF() {  // CC = +1, Ccog = 0
		return mFecha;
	}

	public void setF(LocalDateTime newMFecha) {  // CC = +1, Ccog = 0
		mFecha = newMFecha;
	}

	public void setI(double newMImporte) {  // CC = +1, Ccog = 0
		mImporte = newMImporte;
	}
}