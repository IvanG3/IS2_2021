/**
 * @(#) Alarma.java
 */

package es.unican.is2;

import java.util.Comparator;
import java.util.Date;

public class Alarma implements Comparator<Alarma>
{
	private String id;
	
	private Date hora;
	
	public String id()
	{
		return id;
	}
	
	public Date hora()
	{
		return hora;
	}

	public int compare(Alarma o1, Alarma o2) {
		if (o1.hora().after(o2.hora())) {
			return 1;
		}
		return -1;
	}
	
}
