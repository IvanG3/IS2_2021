/**
 * @(#) Sonando.java
 */

package es.unican.is2;

public class Sonando extends AlarmasState implements TimedState
{
	TimedStateController controlador = TimedStateController.getInstance();

	public void apagar( Alarmas context ) {
		controlador.cancel();
		this.exitAction(context);
		AlarmasState.getEstadoProgramado().entryAction(context);
		AlarmasState.getEstadoProgramado().doAction(context);
		context.setState(AlarmasState.getEstadoProgramado());
	}

	public void borraAlarma( Alarmas context, String id ) {
		context.eliminaAlarma(context.alarmaMasProxima());
	};

	public void entryAction(Alarmas context) {
		controlador.startRelative(context, this, context.getIntervalo());
	}

	public void exitAction( Alarmas context ) {
		context.desactivarMelodía();
	}

	public void timeout(Alarmas context) {
		this.exitAction(context);									// desactivar melodia
		AlarmasState.getEstadoProgramado().entryAction(context);
		AlarmasState.getEstadoProgramado().doAction(context);
		this.borraAlarma(context, context.alarmaMasProxima().id());	
		context.setState(AlarmasState.getEstadoProgramado());		// cambia a programado
	}


}
