package com.bb.trigger.ui.screens;

import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class LogScreen extends AbstractScreen {
	protected void createScreenContents(VerticalFieldManager manager) {
		LabelField logDescription = new LabelField("Application log:",
				USE_ALL_WIDTH);
		manager.add(logDescription);
	}
}
