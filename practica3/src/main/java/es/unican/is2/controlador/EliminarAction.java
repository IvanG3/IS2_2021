package es.unican.is2.controlador;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.modelo.Alarmas;
import es.unican.is2.vista.VentanaAlarmas;

@SuppressWarnings("serial")
public class EliminarAction extends AbstractAction {
	private Alarmas modelo;
	private VentanaAlarmas vista;

	public EliminarAction(Alarmas modelo, VentanaAlarmas vista) {
		this.modelo = modelo;
		this.vista = vista;
		putValue(Action.NAME,"Eliminar");
		putValue(Action.SHORT_DESCRIPTION,"Elimina una alarma");
	}

	public void actionPerformed(ActionEvent e) {
		String id = vista.getActivaSeleccionada();
		if (id == null) {
			id = vista.getDesactivadaSeleccionada();
		}
		try {
			if (id != null) {
				modelo.getState().borraAlarma(modelo, id);
			}
		} catch (java.util.ConcurrentModificationException ex) { }
	}
}