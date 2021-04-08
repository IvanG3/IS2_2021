/**
 * @(#) Desprogramado.java
 */

package es.unican.is2;

public class Desprogramado extends AlarmasState
{
	public void nuevaAlarma( Alarmas context )	{
		context.anhadeAlarma(new Alarma());
		context.setState(AlarmasState.getEstadoProgramado());
	}
	
	public void alarmaOn( Alarmas context, String id )	{
		context.activaAlarma(context.getAlarmaInactiva(id));
		context.setState(AlarmasState.getEstadoProgramado());
	}
	
	
}
