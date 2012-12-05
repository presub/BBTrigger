package com.bb.trigger.ui.screens;

import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.excecution.ExecutionLog;
import com.bb.trigger.excecution.ExecutionManager;
import com.bb.trigger.excecution.LogListener;

public class LogScreen extends AbstractScreen implements LogListener {

	private LabelField log;
	private final ExecutionLog logContainer;

	public LogScreen() {
		logContainer = ExecutionManager.getINSTANCE().getLog();

	}

	protected void createScreenContents(VerticalFieldManager manager) {
		LabelField logDescription = new LabelField("Application log:", USE_ALL_WIDTH);
		manager.add(logDescription);
		log = new LabelField("", USE_ALL_WIDTH);
		logContainer.setListener(this);
		log.setText(logContainer.toString());
		manager.add(log);
	}

	public void logChanged(String text) {
		log.setText(text);
	}

	public void close() {
		logContainer.setListener(null);
		super.close();
	}
}
