package com.bb.trigger.api;

import net.rim.device.api.util.Persistable;

public class Task implements Persistable {

	private final String name;
	private final AbstractAction action;
	private final AbstractTrigger trigger;

	public Task(String name, AbstractAction action, AbstractTrigger trigger) {
		super();
		this.name = name;
		this.action = action;
		this.trigger = trigger;
	}

	public AbstractAction getAction() {
		return action;
	}

	public AbstractTrigger getTrigger() {
		return trigger;
	}

	public String getName() {
		return name;
	}
}
