package es.unican.is2.controlador;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.modelo.*;
import es.unican.is2.vista.*;

@SuppressWarnings("serial")
public class NuevaAction extends AbstractAction {
	private Alarmas modelo;
	private VentanaAlarmas vista;
	
	public NuevaAction(Alarmas modelo, VentanaAlarmas vista) {
		this.modelo = modelo;
		this.vista = vista;
		putValue(Action.NAME,"Nueva");
		putValue(Action.SHORT_DESCRIPTION,"Crea una nueva alarma");
	}

	public void actionPerformed(ActionEvent e) {
		String id = vista.getId();
		Date hora;
		try {
			hora = new SimpleDateFormat("dd/MM/yyyy hh:mm a").parse(vista.getDate());
			modelo.getState().nuevaAlarma(modelo, id, hora);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
}