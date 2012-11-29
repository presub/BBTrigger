package com.bb.trigger.api.ui.trigger;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.DateField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.Messages;
import com.bb.trigger.api.ui.AbstractObjectScreen;

public class TimeTriggerScreen extends AbstractObjectScreen {

	private DateField datePicker;

	public TimeTriggerScreen() {
		super("test");
	}

	protected void createSubPageContents(VerticalFieldManager manager) {
		String triggerMessage = Messages
				.getString(Messages.Date_Action_Description_Trigger);
		datePicker = new DateField(triggerMessage, System.currentTimeMillis(),
				DateField.DATE_TIME);
		datePicker.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				long date = datePicker.getDate();
			}
		});
		manager.add(datePicker);
	}
}
