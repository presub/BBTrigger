package com.bb.trigger.ui.screens;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.process.CreateTaskProcess;

public class TaskScreen extends AbstractScreen {

	private final CreateTaskProcess createTaskProcess;
	private EditField nameField;

	public TaskScreen(CreateTaskProcess createTaskProcess) {
		this.createTaskProcess = createTaskProcess;
	}

	protected void createScreenContents(VerticalFieldManager manager) {
		manager.add(new LabelField("Enter task name:"));
		nameField = new EditField(BasicEditField.FILTER_DEFAULT
				| BasicEditField.NO_COMPLEX_INPUT | BasicEditField.NO_NEWLINE);
		manager.add(nameField);
		ButtonField buttonField = new ButtonField("Create");
		buttonField.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				showSummaryScreen();
			}
		});
		manager.add(buttonField);
	}

	private void showSummaryScreen() {
		String name = nameField.getText();
		createTaskProcess.showSummaryScreen(name);
	}
}
