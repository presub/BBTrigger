package com.bb.trigger.ui.screens;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.api.Task;
import com.bb.trigger.process.CreateTaskProcess;

public class SummaryScreen extends AbstractScreen {

	private final CreateTaskProcess process;

	public SummaryScreen(CreateTaskProcess process) {
		this.process = process;
	}

	protected void createScreenContents(VerticalFieldManager manager) {
		LabelField field = new LabelField();
		Task task = process.getTask();
		field.setText("Creating a new task named:" + task + "\n");
		// TODO trigger and action description
		ButtonField okButton = new ButtonField();
		okButton.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				process.finalize();
			}
		});
	}

}
