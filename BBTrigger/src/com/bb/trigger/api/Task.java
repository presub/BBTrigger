package com.bb.trigger.api;

import net.rim.device.api.util.Persistable;

public class Task implements Persistable {

	private final String name;
	private final AbstractTrigger trigger;
	private boolean enabled = true;

	public Task(String name, AbstractAction action, AbstractTrigger trigger) {
		super();
		this.name = name;
		this.trigger = trigger;
		this.trigger.setAction(action);
	}

	public AbstractAction getAction() {
		return trigger.getAction();
	}

	public AbstractTrigger getTrigger() {
		return trigger;
	}

	public String getName() {
		return name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
