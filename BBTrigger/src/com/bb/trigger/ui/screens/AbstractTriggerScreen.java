package com.bb.trigger.ui.screens;

import com.bb.trigger.api.AbstractTrigger;
import com.bb.trigger.process.CreateTaskProcess;

public abstract class AbstractTriggerScreen extends AbstractObjectScreen {

	public AbstractTriggerScreen(String title,
			CreateTaskProcess createTaskProcess) {
		super(title, createTaskProcess);
	}

	protected void processNextScreen() {
		CreateTaskProcess process = getProcess();
		process.setTrigger(createTrigger());
		process.showActionSelectionScreen();
	}

	protected abstract AbstractTrigger createTrigger();
}
