package com.bb.trigger.api.trigger;

import com.bb.trigger.Messages;
import com.bb.trigger.api.IObjectProxy;
import com.bb.trigger.api.ui.AbstractObjectScreen;
import com.bb.trigger.api.ui.trigger.TimeTriggerScreen;

public class TimeTrigerProxy implements IObjectProxy {

	public String getName() {
		return Messages.getString(Messages.Trigger_Time_Triger_Name);
	}

	public String getDescription() {
		return Messages.getString(Messages.Trigger_Time_Triger_Description);
	}

	public AbstractObjectScreen getScreen(){
		return new TimeTriggerScreen();
	}
}
