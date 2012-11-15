package com.bb.trigger.api.ui;

import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.Messages;
import com.bb.trigger.ui.screens.AbstractScreen;

public abstract class AbstractTriggerScreen extends AbstractScreen {

	public AbstractTriggerScreen() {
	}

	protected void createScreenContents(VerticalFieldManager manager) {
		createSubPageContents(manager);
		String buttonMessage = Messages.getString(Messages.Button_Next);
		ButtonField nextButton = new ButtonField(buttonMessage, USE_ALL_WIDTH);
		manager.add(nextButton);
	}

	protected abstract void createSubPageContents(VerticalFieldManager manager);
	
	protected String getScreenTitle() {
		return Messages.getString(Messages.Trigger_Title_Bar);
	}
}
