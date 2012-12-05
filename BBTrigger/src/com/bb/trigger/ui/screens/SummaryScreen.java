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
		LabelField descriptionText = new LabelField();
		Task task = process.getTask();
		descriptionText.setText("Creating a new task named:" + task.getName()
				+ "\n");
		// TODO trigger and action description
		manager.add(descriptionText);
		ButtonField okButton = new ButtonField("Ok");
		okButton.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				process.finalize();
			}
		});
		manager.add(okButton);

		ButtonField cancelButton = new ButtonField("Cancel");
		cancelButton.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				process.cancel();
			}
		});
		manager.add(cancelButton);
	}
}
