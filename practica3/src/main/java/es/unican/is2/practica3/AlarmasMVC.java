package es.unican.is2.practica3;

import es.unican.is2.controlador.*;
import es.unican.is2.modelo.*;
import es.unican.is2.vista.*;

public class AlarmasMVC {

	public static void main(String[] args) {
		Alarmas modelo = new Alarmas();
		VentanaAlarmas vista = new VentanaAlarmas(modelo);
		vista.setNuevaAction(new NuevaAction(modelo,vista));
		vista.setApagarAction(new ApagarAction(modelo,vista));
		vista.setOnAction(new OnAction(modelo,vista));
		vista.setOffAction(new OffAction(modelo,vista));
		vista.setEliminarAction(new EliminarAction(modelo,vista));
		vista.setVisible(true);
	}

}
