package com.bb.trigger.api.trigger;

import com.bb.trigger.Messages;
import com.bb.trigger.api.IObjectDescriptor;
import com.bb.trigger.api.ui.trigger.TimeTriggerScreen;
import com.bb.trigger.messages.MessagesResource;
import com.bb.trigger.process.CreateTaskProcess;
import com.bb.trigger.ui.screens.AbstractObjectScreen;

public class TimeTrigerDescriptor implements IObjectDescriptor {

	public String getName() {
		return Messages.getString(MessagesResource.Trigger_Time_Triger_Name);
	}

	public String getDescription() {
		return Messages
				.getString(MessagesResource.Trigger_Time_Triger_Description);
	}

	public AbstractObjectScreen createScreen(CreateTaskProcess createTaskProcess) {
		TimeTriggerScreen timeTriggerScreen = new TimeTriggerScreen(
				createTaskProcess);
		timeTriggerScreen.createContents();
		return timeTriggerScreen;
	}
}
