/**
 * @(#) AlarmasState.java
 */

package es.unican.is2.modelo;

import java.util.Date;

public class AlarmasState
{
	public TimedStateController controlador = TimedStateController.getInstance();
	
	private static Desprogramado estadoDesprogramado = new Desprogramado();
	private static Programado estadoProgramado = new Programado();
	private static Sonando estadoSonando = new Sonando();
	
	public static AlarmasState init( Alarmas context ) {
		estadoDesprogramado.entryAction(context);
		return estadoDesprogramado;
	}
	
	public Alarma nuevaAlarma( Alarmas context, String id, Date hora ) {
		return null;
	}
	
	public void apagar( Alarmas context ) {}	
	public void alarmaOff( Alarmas context, String id ) {};
	public void alarmaOn( Alarmas context, String id ) {};
	public void borraAlarma( Alarmas context, String id ) {};
	
	public static Desprogramado getEstadoDesprogramado() {
		return estadoDesprogramado;
	};
	public static Programado getEstadoProgramado() {
		return estadoProgramado;
	};
	public static Sonando getEstadoSonando() {
		return estadoSonando;
	};
	
	public void entryAction( Alarmas context ) {}
	
	public void exitAction( Alarmas context ) {}
	
	public void doAction( Alarmas context ) {}
	
}
