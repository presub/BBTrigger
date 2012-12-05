package com.bb.trigger.excecution;


/**
 * Execution log. Contains information about executed tasks
 */
public class ExecutionLog {

	private final StringBuffer log;
	private LogListener listener;

	public ExecutionLog() {
		log = new StringBuffer();
	}

	public void append(String string) {
		log.append(string + "\n");
		if (listener != null) {
			listener.logChanged(log.toString());
		}
	}

	public String toString() {
		return log.toString();
	}

	public void setListener(LogListener listener) {
		this.listener = listener;
	};
}
