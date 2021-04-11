package es.unican.is2.modelo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimedStateController {

	private static final TimedStateController controlador = new TimedStateController();
	private Timer timer = new Timer();

	public static TimedStateController getInstance() {
		return controlador;
	}

	public void startRelative(Alarmas context, TimedState estado, int milis) {
		timer.schedule(new Task(estado, context), milis);
	}

	public void startAbsolute(Alarmas context, TimedState estado, Date instante) {
		timer.schedule(new Task(estado, context), instante);
	}
	
	public void cancel() {
		timer.cancel();
		timer = new Timer();
	}
	
	private class Task extends TimerTask {
		TimedState timed;
		Alarmas context;
		
		public Task(TimedState timed, Alarmas context) {
			this.timed = timed;
			this.context = context;
		}

		@Override
		public void run() {
			timed.timeout(context);			
		}
		
	}

}
