/**
 * @(#) Alarma.java
 */

package es.unican.is2.modelo;

import java.util.Date;

public class Alarma implements Comparable<Alarma> {
	private String id;
	private Date hora;
	
	public Alarma(String id, Date hora) {
		this.id = id;
		this.hora = hora;
	}
	
	public String id()
	{
		return id;
	}
	
	public Date hora()
	{
		return hora;
	}

	public int compareTo(Alarma a) {
		if (hora.after(a.hora())) {
			return 1;
		}
		return 0;
	}
	
}
