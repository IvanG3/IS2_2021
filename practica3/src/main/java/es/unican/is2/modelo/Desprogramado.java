/**
 * @(#) Desprogramado.java
 */

package es.unican.is2.modelo;

import java.util.Date;

public class Desprogramado extends AlarmasState
{
	public Alarma nuevaAlarma( Alarmas context, String id, Date hora )	{
		Alarma a = new Alarma(id, hora);
		context.anhadeAlarma(a);
		context.setState(AlarmasState.getEstadoProgramado());
		return a;
	}
	
	public void alarmaOn( Alarmas context, String id )	{
		context.activaAlarma(context.getAlarmaInactiva(id));
		context.setState(AlarmasState.getEstadoProgramado());
	}
	
	
}
