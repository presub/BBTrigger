package com.bb.trigger.api.trigger;

import net.rim.device.api.util.Persistable;

import com.bb.trigger.api.AbstractTrigger;

public class TimeTrigger extends AbstractTrigger implements Persistable {

	private final long date;

	public TimeTrigger(long date) {
		this.date = date;
	}
}
