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
<<<<<<< HEAD
	
	public void entryAction( Alarmas context )
	{
		// FALTA
	}
	
	public void exitAction( Alarmas context )
	{
		// FALTA
=======

	/**public void borraAlarma( Alarmas context ) {
		this.exitAction(context);								// desactivar melodia
		AlarmasState.getEstadoProgramado().entryAction(context);
		AlarmasState.getEstadoProgramado().doAction(context);
		context.setState(AlarmasState.getEstadoProgramado());	// cambia a programado
	}*/

	public void entryAction(Alarmas context) {
		controlador.startAbsolute(context, this, context.alarmaMasProxima().hora());
	}

	public void exitAction( Alarmas context ) {
		context.desactivarMelodía();
>>>>>>> 4a9cdceeb9e7a0970efe41f0acca94d74edfa4d9
	}

	public void timeout(Alarmas context) {
		this.exitAction(context);								// desactivar melodia
		AlarmasState.getEstadoProgramado().entryAction(context);
		AlarmasState.getEstadoProgramado().doAction(context);
		context.setState(AlarmasState.getEstadoProgramado());	// cambia a programado
	}


}
