/**
 * @(#) Alarmas.java
 */

package Implementacion;

public class Alarmas
{
	private int INTERVALO_SONAR;
	
	private Alarma alarmasDesactivadas;
	
	private Alarma alarmasActivas;
	
	private AlarmasState state;
	
	public Alarma alarma( String id )
	{
		return null;
	}
	
	/**
	 * Añade una nueva alarma preparada para sonar. Retorna true si ese añade y false si no se añade porque ya existe una alarma para la misma hora.
	 */
	public boolean anhadeAlarma( Alarma a )
	{
		return false;
	}
	
	public boolean eliminaAlarma( Alarma a )
	{
		return false;
	}
	
	public Alarma alarmaMasProxima( )
	{
		return null;
	}
	
	public void desactivaAlarma( Alarma a )
	{
		
	}
	
	public void activaAlarma( Alarma a )
	{
		
	}
	
	public Alarma alarmasActivas( )
	{
		return null;
	}
	
	public Alarma alarmasDesactivadas( )
	{
		return null;
	}
	
	public void activarMelodía( )
	{
		
	}
	
	public void desactivarMelodía( )
	{
		
	}
	
	public void setState( AlarmasState state )
	{
		
	}
	
	
}
