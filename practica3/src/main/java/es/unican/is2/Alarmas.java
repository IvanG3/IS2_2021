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
	 * A�ade una nueva alarma preparada para sonar. Retorna true si ese a�ade y false si no se a�ade porque ya existe una alarma para la misma hora.
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
	
	public void activarMelod�a( )
	{
		
	}
	
	public void desactivarMelod�a( )
	{
		
	}
	
	public void setState( AlarmasState state )
	{
		this.state = state;
	}
	
	
}
