package es.unican.is2.modelo;

import java.util.Date;

public class Programado extends AlarmasState implements TimedState {
	TimedStateController controlador = TimedStateController.getInstance();
	
	public void entryAction(Alarmas context, Alarma a) {
		controlador.startAbsolute(context, this, a.hora());
	}
	
	public void alarmaOn( Alarmas context, String id )	{
		Alarma a = context.getAlarmaInactiva(id);
		context.activaAlarma(a);
		controlador.startAbsolute(context, this, a.hora());
	}
	
	public void alarmaOff( Alarmas context, String id ) {
		context.desactivaAlarma(context.getAlarmaActiva(id));
		controlador.cancel();
		if (context.alarmasActivas().size() == 0) {
			context.setState(AlarmasState.getEstadoDesprogramado());
		} else {
			for (Alarma al : context.alarmasActivas()) {
				controlador.startAbsolute(context, this, al.hora());
			}
		}
	}
	
	public void borraAlarma( Alarmas context, String id ) {
		context.eliminaAlarma(context.alarma(id));
		controlador.cancel();
		if (context.alarmasActivas().size() == 0) {
			context.setState(AlarmasState.getEstadoDesprogramado());
		} else {
			for (Alarma al : context.alarmasActivas()) {
				controlador.startAbsolute(context, this, al.hora());
			}
		}
	}
	
	public void nuevaAlarma( Alarmas context, String id, Date hora ) {
		Alarma a = new Alarma(id, hora);
		context.anhadeAlarma(a);
		entryAction(context, a);
	}
	
	public void timeout(Alarmas context) {
		AlarmasState.getEstadoSonando().entryAction(context, null);
		context.setState(AlarmasState.getEstadoSonando());		// cambia a sonando
	}	
}
