package es.unican.is2.controlador;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.modelo.Alarmas;
import es.unican.is2.vista.VentanaAlarmas;

@SuppressWarnings("serial")
public class OnAction extends AbstractAction {
	private Alarmas modelo;
	private VentanaAlarmas vista;

	public OnAction(Alarmas modelo, VentanaAlarmas vista) {
		this.modelo = modelo;
		this.vista = vista;
		putValue(Action.NAME,"On");
		putValue(Action.SHORT_DESCRIPTION,"Activa una alarma");
	}

	public void actionPerformed(ActionEvent e) {
		String id = vista.getDesactivadaSeleccionada();
		try {
			if (id != null) {
				modelo.activaAlarma(modelo.getAlarmaInactiva(id));
			}
		} catch (java.util.ConcurrentModificationException ex) { }
	}
}
