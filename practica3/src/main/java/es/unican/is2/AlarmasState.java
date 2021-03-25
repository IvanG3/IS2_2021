/**
 * @(#) AlarmasState.java
 */

package es.unican.is2;

public class AlarmasState
{
	private static Desprogramado estadoDesprogramado = new Desprogramado();
	private static Programado estadoProgramado = new Programado();
	private static Sonando estadoSonando = new Sonando();
	
	public static AlarmasState init( Alarmas context )
	{
		estadoDesprogramado.entryAction(context);
		return estadoDesprogramado;
	}
	
	public Alarma nuevaAlarma( Alarmas context, String id, date hora )
	{
		return null;
	}
	
	public void apagar( Alarmas context ) {};	
	public void alarmaOff( Alarmas context, String id ) {};
	public void alarmaOn( Alarmas context, String id ) {};
	public void borraAlarma( Alarmas context, String id ) {};
	
	public static AlarmasState getEstadoDesprogramado() {
		return estadoDesprogramado;
	};
	public static AlarmasState getEstadoProgramado() {
		return estadoProgramado;
	};
	public static AlarmasState getEstadoSonando() {
		return estadoSonando;
	};
	
	/*public void entryAction( Alarmas context )
	{
		
	}
	
	public void exitAction( Alarmas context )
	{
		
	}
	
	public void doAction( Alarmas context )
	{
		
	}*/
	
	
}
