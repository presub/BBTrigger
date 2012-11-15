package com.bb.trigger.api.trigger;

import javax.wireless.messaging.Message;

import com.bb.trigger.Messages;
import com.bb.trigger.api.AbstractTrigger;
import com.bb.trigger.api.ITriggerProxy;
import com.bb.trigger.api.ui.AbstractTriggerScreen;
import com.bb.trigger.api.ui.trigger.TimeTriggerScreen;

public class TimeTrigerProxy implements ITriggerProxy {

	public AbstractTrigger getNewTrigger() {
		return new TimeTrigger();
	}

	public AbstractTriggerScreen getNewTriggerScreen() {
		return new TimeTriggerScreen();
	}

	public String getName() {
		return Messages.getString(Messages.Trigger_Time_Triger_Name);
	}

	public String getDescription() {
		return Messages.getString(Messages.Trigger_Time_Triger_Description);
	}
}
