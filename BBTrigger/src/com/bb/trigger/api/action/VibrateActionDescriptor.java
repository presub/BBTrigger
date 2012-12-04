package com.bb.trigger.api.action;

import com.bb.trigger.api.IObjectDescriptor;
import com.bb.trigger.api.ui.action.VibrateActionScreen;
import com.bb.trigger.process.CreateTaskProcess;
import com.bb.trigger.ui.screens.AbstractObjectScreen;

public class VibrateActionDescriptor implements IObjectDescriptor {

	public String getName() {
		return "Vibrate";
	}

	public String getDescription() {
		return "Vibrate for a specified time ";
	}

	public AbstractObjectScreen createScreen(CreateTaskProcess createTaskProcess) {
		VibrateActionScreen vibrateScreen = new VibrateActionScreen(createTaskProcess);
		vibrateScreen.createContents();
		return vibrateScreen;
	}

}
