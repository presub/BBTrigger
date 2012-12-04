package com.bb.trigger.api.ui.action;

import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.api.AbstractAction;
import com.bb.trigger.api.action.VibrateAction;
import com.bb.trigger.process.CreateTaskProcess;
import com.bb.trigger.ui.screens.AbstractActionScreen;

public class VibrateActionScreen extends AbstractActionScreen {

	private EditField timeField;

	public VibrateActionScreen(CreateTaskProcess createTaskProcess) {
		super("Test", createTaskProcess);
	}

	protected void createSubPageContents(VerticalFieldManager manager) {
		manager.add(new LabelField("Provide vibration time in miliseconds"));
		timeField = new EditField(BasicEditField.FILTER_INTEGER);
		manager.add(timeField);
	}

	protected AbstractAction createAction() {
		String text = timeField.getText();
		// TODO catch NumberFormatException
		int valueOf = Integer.valueOf(text).intValue();
		return new VibrateAction(valueOf);
	}
}
