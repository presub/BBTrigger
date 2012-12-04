package com.bb.trigger.api.trigger;

import com.bb.trigger.api.AbstractTrigger;

public class TimeTrigger extends AbstractTrigger {

	private final long date;

	public TimeTrigger(long date) {
		this.date = date;
	}
}
