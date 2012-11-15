package com.bb.trigger.api.trigger;

import java.util.Date;

import net.rim.device.api.ui.Screen;

import com.bb.trigger.api.AbstractTrigger;
import com.bb.trigger.api.ui.trigger.TimeTriggerScreen;

public class TimeTrigger extends AbstractTrigger {

	private TimeTriggerScreen timeTriggerScreen = new TimeTriggerScreen();
	private Date tiggerDate;

	public TimeTrigger() {
		
	}

	public void init() {
	}

	private Screen getScreen() {
		return timeTriggerScreen;
	}
}
