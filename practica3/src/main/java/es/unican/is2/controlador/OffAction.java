package es.unican.is2.controlador;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.modelo.Alarmas;
import es.unican.is2.vista.VentanaAlarmas;

@SuppressWarnings("serial")
public class OffAction extends AbstractAction {
	private Alarmas modelo;
	private VentanaAlarmas vista;

	public OffAction(Alarmas modelo, VentanaAlarmas vista) {
		this.modelo = modelo;
		this.vista = vista;
		putValue(Action.NAME,"Off");
		putValue(Action.SHORT_DESCRIPTION,"Desactiva una alarma");
	}

	public void actionPerformed(ActionEvent e) {
		String id = vista.getActivaSeleccionada();
		try {
			if (id != null) {
				modelo.desactivaAlarma(modelo.getAlarmaActiva(id));
			}
		} catch (java.util.ConcurrentModificationException ex) { }
	}
}
