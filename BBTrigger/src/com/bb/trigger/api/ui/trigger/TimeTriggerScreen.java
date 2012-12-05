package com.bb.trigger.api.ui.trigger;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.DateField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.Messages;
import com.bb.trigger.api.AbstractTrigger;
import com.bb.trigger.api.trigger.TimeTrigger;
import com.bb.trigger.messages.MessagesResource;
import com.bb.trigger.process.CreateTaskProcess;
import com.bb.trigger.ui.screens.AbstractTriggerScreen;

public class TimeTriggerScreen extends AbstractTriggerScreen {

	private DateField datePicker;
	private long date;

	public TimeTriggerScreen(CreateTaskProcess createTaskProcess) {
		super("TimeTriggerScreen", createTaskProcess);
	}

	protected void createSubPageContents(VerticalFieldManager manager) {
		String triggerMessage = Messages.getString(MessagesResource.Date_Action_Description_Trigger);
		datePicker = new DateField(triggerMessage, System.currentTimeMillis(), DateField.DATE_TIME);
		datePicker.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				date = datePicker.getDate();
			}
		});
		manager.add(datePicker);
	}

	protected AbstractTrigger createTrigger() {
		return new TimeTrigger(date);
	}
}
