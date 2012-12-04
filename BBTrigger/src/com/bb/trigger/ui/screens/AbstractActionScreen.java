package com.bb.trigger.ui.screens;

import com.bb.trigger.api.AbstractAction;
import com.bb.trigger.process.CreateTaskProcess;

public abstract class AbstractActionScreen extends AbstractObjectScreen {

	public AbstractActionScreen(String title,
			CreateTaskProcess createTaskProcess) {
		super(title, createTaskProcess);
	}

	protected void processNextScreen() {
		CreateTaskProcess process = getProcess();
		process.setAction(createAction());
		process.showTaskScreen();
	}

	protected abstract AbstractAction createAction();
}