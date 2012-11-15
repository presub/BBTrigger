package com.bb.trigger.api.ui;

import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.Messages;
import com.bb.trigger.ui.screens.AbstractScreen;

public abstract class AbstractActionScreen extends AbstractScreen {

	public AbstractActionScreen() {
	}

	protected void createScreenContents(VerticalFieldManager manager) {
		createSubPageContents(manager);
		String buttonMessage = Messages.getString(Messages.Button_Next);
		ButtonField nextButton = new ButtonField(buttonMessage, USE_ALL_WIDTH);
		manager.add(nextButton);
	}

	protected abstract void createSubPageContents(VerticalFieldManager manager);

	protected String getScreenTitle() {
		return Messages.getString(Messages.Action_Title_Bar);
	}

}
