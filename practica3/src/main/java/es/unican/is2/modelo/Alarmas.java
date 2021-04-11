/**
 * @(#) Alarmas.java
 */

package es.unican.is2.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Alarmas {
	private int INTERVALO_SONAR;

	private ArrayList<Alarma> alarmasDesactivadas = new ArrayList<Alarma>();
	private Queue<Alarma> alarmasActivas = new PriorityQueue<Alarma>();
	private AlarmasState state;

	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	public Alarmas( ) {
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
	public boolean anhadeAlarma( Alarma a ) {
		Queue<Alarma> alarmasActivasVieja = new PriorityQueue<Alarma>(alarmasActivas);

		for (Alarma alarma : alarmasActivas) {
			if (alarma.hora().equals(a.hora())) {
				return false;
			}
		}
		alarmasActivas.add(a);
		changeSupport.firePropertyChange("activa", alarmasActivasVieja, alarmasActivas);
		return true;
	}

	public boolean eliminaAlarma( Alarma a ) {
		ArrayList<Alarma> alarmasDesactivadasVieja = new ArrayList<Alarma>(alarmasDesactivadas);
		Queue<Alarma> alarmasActivasVieja = new PriorityQueue<Alarma>(alarmasActivas);

		for (Alarma al : alarmasDesactivadas) {
			if (al.id().equals(a.id())) {
				alarmasDesactivadas.remove(a);
				changeSupport.firePropertyChange("desactivadas", alarmasDesactivadasVieja, alarmasDesactivadas);
				return true;
			}
		}
		for (Alarma al : alarmasActivas) {
			if (al.id().equals(a.id())) {
				alarmasActivas.remove(a);
				changeSupport.firePropertyChange("activa", alarmasActivasVieja, alarmasActivas);
				return true;
			}
		}
		return false;
	}

	public Alarma alarmaMasProxima( ) {
		return alarmasActivas.peek();
	}

	public void desactivaAlarma( Alarma a ) {
		ArrayList<Alarma> alarmasDesactivadasVieja = new ArrayList<Alarma>(alarmasDesactivadas);
		Queue<Alarma> alarmasActivasVieja = new PriorityQueue<Alarma>(alarmasActivas);

		for (Alarma al : alarmasActivas) {
			if (al.id().equals(a.id())) {
				alarmasDesactivadas.add(a);
				alarmasActivas.remove(a);

				changeSupport.firePropertyChange("desactivadas", alarmasDesactivadasVieja, alarmasDesactivadas);
				changeSupport.firePropertyChange("activa", alarmasActivasVieja, alarmasActivas);
			}
		}
	}

	public void activaAlarma( Alarma a ) {
		ArrayList<Alarma> alarmasDesactivadasVieja = new ArrayList<Alarma>(alarmasDesactivadas);
		Queue<Alarma> alarmasActivasVieja = new PriorityQueue<Alarma>(alarmasActivas);

		for (Alarma al : alarmasDesactivadas) {
			if (al.id().equals(a.id())) {
				alarmasActivas.add(a);
				alarmasDesactivadas.remove(a);

				changeSupport.firePropertyChange("desactivadas", alarmasDesactivadasVieja, alarmasDesactivadas);
				changeSupport.firePropertyChange("activa", alarmasActivasVieja, alarmasActivas);
			}
		}
	}

	public Queue<Alarma> alarmasActivas( ) {
		return alarmasActivas;
	}

	public ArrayList<Alarma> alarmasDesactivadas( ) {
		return alarmasDesactivadas;
	}

	public void activarMelodía( ) {
		System.out.println("Sonando " + alarmaMasProxima().id());
	}

	public void desactivarMelodía( ) {
		System.out.println("Melodia parada.");
	}

	public void setState( AlarmasState state ) {
		this.state = state;
	}

	public void addPropertyChangeListener (PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

}
