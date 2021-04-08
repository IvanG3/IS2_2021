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
	
	public Alarma getAlarmaActiva( String id ) {
		for (Alarma a : alarmasActivas) {
			if (a.id().equals(id)) {
				return a;
			}
		}
		return null;
	}
	
	public Alarma getAlarmaInactiva( String id ) {
		for (Alarma a : alarmasDesactivadas) {
			if (a.id().equals(id)) {
				return a;
			}
		}
		return null;
	}
	
	public Alarma alarma( String id ) {
		Alarma a = getAlarmaActiva(id);
		if (a == null) {
			a = getAlarmaInactiva(id);
		}
		return a;
	}
	
	public int getIntervalo() {
		return INTERVALO_SONAR;
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
		for (Alarma al : alarmasDesactivadas) {
			if (al.id().equals(a.id())) {
				alarmasDesactivadas.remove(a);
				return true;
			}
		}
		for (Alarma al : alarmasActivas) {
			if (al.id().equals(a.id())) {
				alarmasActivas.remove(a);
				return true;
			}
		}
		return false;
	}
	
	public Alarma alarmaMasProxima( )
	{
		return alarmasActivas.peek();
	}
	
	public void desactivaAlarma( Alarma a )
	{
		for (Alarma al : alarmasActivas) {
			if (al.id().equals(a.id())) {
				alarmasDesactivadas.add(a);
				alarmasActivas.remove(a);
			}
		}
	}
	
	public void activaAlarma( Alarma a )
	{
		for (Alarma al : alarmasDesactivadas) {
			if (al.id().equals(a.id())) {
				alarmasActivas.add(a);
				alarmasDesactivadas.remove(a);
			}
		}
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
