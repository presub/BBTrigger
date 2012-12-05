package com.bb.trigger.api;

import net.rim.device.api.util.Persistable;

public abstract class AbstractTrigger implements Persistable {

	private AbstractAction action;

	public AbstractTrigger() {
	}

	public abstract void initTrigger();

	public abstract void enable(boolean enablement);

	public AbstractAction getAction() {
		return action;
	}

	public void setAction(AbstractAction action) {
		this.action = action;
	}

}
