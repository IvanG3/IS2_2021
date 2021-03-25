/**
 * @(#) Alarmas.java
 */

package es.unican.is2;

public class Alarmas
{
	private int INTERVALO_SONAR;
	
	private Alarma alarmasDesactivadas;
	
	private Alarma alarmasActivas;
	
	private AlarmasState state;
	
	public Alarma alarma( String id ) // NO SE COMO SE HACE
	{
		return null;
	}
	
	/**
	 * Añade una nueva alarma preparada para sonar. Retorna true si ese añade y false si no se añade porque ya existe una alarma para la misma hora.
	 */
	public boolean anhadeAlarma( Alarma a )
	{
		state.alarmaOn(this, a.id());
		return true;
	}
	
	public boolean eliminaAlarma( Alarma a )
	{
		state.borraAlarma(this, a.id());
		return true;
	}
	
	public Alarma alarmaMasProxima( ) // NO SE
	{
		return null;
	}
	
	public void desactivaAlarma( Alarma a )
	{
		state.alarmaOff(this, a.id());
	}
	
	public void activaAlarma( Alarma a )
	{
		state.alarmaOn(this, a.id());
	}
	
	public Alarma alarmasActivas( )
	{
		return alarmasActivas;
	}
	
	public Alarma alarmasDesactivadas( )
	{
		return alarmasDesactivadas;
	}
	
	public void activarMelodía( )
	{
		
	}
	
	public void desactivarMelodía( )
	{
		
	}
	
	public void setState( AlarmasState state )
	{
		this.state = state;
	}
	
	
}
