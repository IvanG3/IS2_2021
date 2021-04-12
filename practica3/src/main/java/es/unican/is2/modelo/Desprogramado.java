package es.unican.is2.modelo;

import java.util.Date;

public class Desprogramado extends AlarmasState {
	
	public void nuevaAlarma( Alarmas context, String id, Date hora )	{
		Alarma a = new Alarma(id, hora);
		context.anhadeAlarma(a);
		AlarmasState.getEstadoProgramado().entryAction(context, a);
		context.setState(AlarmasState.getEstadoProgramado());
	}
	
	public void alarmaOn( Alarmas context, String id )	{
		Alarma a = context.getAlarmaInactiva(id);
		context.activaAlarma(a);
		AlarmasState.getEstadoProgramado().entryAction(context, a);
		context.setState(AlarmasState.getEstadoProgramado());
	}
}
