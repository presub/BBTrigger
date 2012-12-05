package com.bb.trigger.excecution;

import java.util.Vector;

public class ExecutionThread extends Thread {

	private final Vector tasks;

	public ExecutionThread(Vector tasks) {
		this.tasks = tasks;
	}

	public void run() {
		super.run();
	}
}
