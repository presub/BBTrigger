package com.bb.trigger.process;

import com.bb.trigger.api.AbstractAction;
import com.bb.trigger.api.AbstractTrigger;
import com.bb.trigger.api.ActionManager;
import com.bb.trigger.api.IObjectDescriptor;
import com.bb.trigger.api.Task;
import com.bb.trigger.api.TriggerManager;
import com.bb.trigger.ui.screens.AbstractObjectScreen;
import com.bb.trigger.ui.screens.ObjectSelectionScreen;
import com.bb.trigger.ui.screens.SummaryScreen;
import com.bb.trigger.ui.screens.TaskScreen;

public class CreateTaskProcess extends AbstractProcess {

	private final static TriggerManager triggerManager = new TriggerManager();
	private final static ActionManager actionManager = new ActionManager();

	private Task task;
	private AbstractTrigger trigger;
	private AbstractAction action;

	public CreateTaskProcess() {
	}

	public void run() {
		showTriggerSelectionScreen();
	}

	public void finalize() {
	}

	private void showTriggerSelectionScreen() {
		final ObjectSelectionScreen screen = new ObjectSelectionScreen(this,
				triggerManager, "Triggers");
		screen.createContents();
		pushScreen(screen);
	}

	public void showActionSelectionScreen() {
		final ObjectSelectionScreen screen = new ObjectSelectionScreen(this,
				actionManager, "Actions");
		screen.createContents();
		pushScreen(screen);
	}

	public void showTaskScreen() {
		final TaskScreen screen = new TaskScreen(this);
		screen.createContents();
		pushScreen(screen);
	}

	public void showObjectScreen(IObjectDescriptor provider) {
		AbstractObjectScreen screen = provider.createScreen(this);
		pushScreen(screen);
	}

	public void showSummaryScreen(String taskName) {
		createTask(taskName);
		SummaryScreen screen = new SummaryScreen(this);
		pushScreen(screen);
	}

	private void createTask(String name) {
		if ((action == null) || (trigger == null)) {
			throw new IllegalStateException();
		}
		task = new Task(name, action, trigger);
	}

	public Task getTask() {
		return task;
	}

	public void setTrigger(AbstractTrigger trigger) {
		this.trigger = trigger;
	}

	public void setAction(AbstractAction action) {
		this.action = action;
	}

}
