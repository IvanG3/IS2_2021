/**
 * @(#) Sonando.java
 */

package es.unican.is2.modelo;

public class Sonando extends AlarmasState implements TimedState
{
	TimedStateController controlador = TimedStateController.getInstance();

	public void apagar( Alarmas context ) {
		this.exitAction(context);									// desactivar melodia
		this.borraAlarma(context, context.alarmaMasProxima().id());
		context.setState(AlarmasState.getEstadoProgramado());		// cambia a programado
	}
<<<<<<< HEAD
	
	public void entryAction( Alarmas context )
	{
		// FALTA
	}
	
	public void exitAction( Alarmas context )
	{
		// FALTA
=======

	public void borraAlarma( Alarmas context, String id ) {
		context.eliminaAlarma(context.alarmaMasProxima());
	};

	public void entryAction(Alarmas context, Alarma a) {
		controlador.startRelative(context, this, context.getIntervalo());
		context.activarMelodía();
	}

	public void exitAction( Alarmas context ) {
		context.desactivarMelodía();
>>>>>>> 4a9cdceeb9e7a0970efe41f0acca94d74edfa4d9
	}

	public void timeout(Alarmas context) {
		Alarma a = context.alarmaMasProxima();
		if (a != null) {
			this.exitAction(context);									// desactivar melodia
			this.borraAlarma(context, a.id());
			context.setState(AlarmasState.getEstadoProgramado());		// cambia a programado
		}
	}


}
