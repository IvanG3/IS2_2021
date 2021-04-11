package es.unican.is2.controlador;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.modelo.*;
import es.unican.is2.vista.*;

@SuppressWarnings("serial")
public class ApagarAction extends AbstractAction {
	private Alarmas modelo;
	private VentanaAlarmas vista;

	public ApagarAction(Alarmas modelo, VentanaAlarmas vista) {
		this.modelo = modelo;
		this.vista = vista;
		putValue(Action.NAME,"Apagar");
		putValue(Action.SHORT_DESCRIPTION,"Apaga una alarma");
	}

	public void actionPerformed(ActionEvent e) {
		Alarma alarma = modelo.alarmaMasProxima();
		if (alarma != null && alarma.hora().before(new Date(System.currentTimeMillis()))) {
			modelo.getState().apagar(modelo);
			modelo.getState().alarmaOff(modelo, alarma.id());
		}
	}
}