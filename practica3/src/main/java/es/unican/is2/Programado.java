/**
 * @(#) Programado.java
 */

package es.unican.is2;

public class Programado extends AlarmasState implements TimedState
{
	TimedStateController controlador = TimedStateController.getInstance();
	
	public void entryAction(Alarmas context) {
		controlador.startAbsolute(context, this, context.alarmaMasProxima().hora());
	}
	
	public void alarmaOn( Alarmas context, String id )	{
		context.activaAlarma(context.getAlarmaInactiva(id));
	}
	
	public void alarmaOff( Alarmas context, String id ) {
		context.desactivaAlarma(context.getAlarmaActiva(id));
		if (context.alarmasActivas().size() == 0) {
			context.setState(AlarmasState.getEstadoDesprogramado());
		}
	}
	
	public void borraAlarma( Alarmas context, String id ) {
		context.eliminaAlarma(context.alarma(id));
		if (context.alarmasActivas().size() == 0) {
			context.setState(AlarmasState.getEstadoDesprogramado());
		}
	}
	
	public void timeout(Alarmas context) {
		AlarmasState.getEstadoSonando().entryAction(context);
		context.setState(AlarmasState.getEstadoSonando());		// cambia a sonando
	}	
}
