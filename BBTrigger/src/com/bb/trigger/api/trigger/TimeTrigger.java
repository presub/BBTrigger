package com.bb.trigger.api.trigger;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import net.rim.device.api.util.Persistable;

import com.bb.trigger.api.AbstractTrigger;

public class TimeTrigger extends AbstractTrigger implements Persistable {

	private final long date;
	private final TimerTask timerTask;

	public TimeTrigger(long date) {
		this.date = date;
		timerTask = new TimerTask() {
			public void run() {
				getAction().run();
			}
		};
	}

	public void initTrigger() {
		Timer timer = new Timer();
		timer.schedule(timerTask, new Date(date));
	}

	public void enable(boolean enablement) {
		if (enablement) {
			initTrigger();
		} else {
			timerTask.cancel();
		}
	}
}
