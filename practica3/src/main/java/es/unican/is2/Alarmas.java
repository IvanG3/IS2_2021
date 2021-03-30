/**
 * @(#) Alarmas.java
 */

package es.unican.is2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Alarmas
{
	private int INTERVALO_SONAR;
	
	private ArrayList<Alarma> alarmasDesactivadas = new ArrayList<Alarma>();
	private Queue<Alarma> alarmasActivas = new PriorityQueue<Alarma>();
	private AlarmasState state;
	
	public Alarmas( String id )
	{
		state = AlarmasState.init(this);
	}
	
	/**
	 * Añade una nueva alarma preparada para sonar. Retorna true si ese añade y 
	 * false si no se añade porque ya existe una alarma para la misma hora.
	 */
	public boolean anhadeAlarma( Alarma a )
	{
		for (Alarma alarma : alarmasActivas) {
			if (alarma.hora().equals(a.hora())) {
				return false;
			}
		}
		alarmasActivas.add(a);
		return true;
	}
	
	public boolean eliminaAlarma( Alarma a )
	{
		state.borraAlarma(this, a.id());
		return true;
	}
	
	public Alarma alarmaMasProxima( )
	{
		return alarmasActivas.peek();
	}
	
	public void desactivaAlarma( Alarma a )
	{
		state.alarmaOff(this, a.id());
	}
	
	public void activaAlarma( Alarma a )
	{
		state.alarmaOn(this, a.id());
	}
	
	public Queue<Alarma> alarmasActivas( )
	{
		return alarmasActivas;
	}
	
	public ArrayList<Alarma> alarmasDesactivadas( )
	{
		return alarmasDesactivadas;
	}
	
	public void activarMelodía( )
	{
		// FALTA
	}
	
	public void desactivarMelodía( )
	{
		// FALTA
	}
	
	public void setState( AlarmasState state )
	{
		this.state = state;
	}
	
}
