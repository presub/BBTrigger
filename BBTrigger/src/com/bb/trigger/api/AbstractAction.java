package com.bb.trigger.api;

import net.rim.device.api.util.Persistable;

import com.bb.trigger.excecution.ExecutionLog;
import com.bb.trigger.excecution.ExecutionManager;

public abstract class AbstractAction implements Persistable {

	public abstract void invoke();

	public void run() {
		invoke();
		getLog().append("Action invoked");
	}

	private ExecutionLog getLog() {
		return ExecutionManager.getINSTANCE().getLog();
	}
}
