package com.bb.trigger.api.action;

import net.rim.device.api.system.Alert;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.util.Persistable;

import com.bb.trigger.api.AbstractAction;

public class VibrateAction extends AbstractAction implements Persistable {

	private final int vibrationTime;

	public VibrateAction(int vibrationTime) {
		this.vibrationTime = vibrationTime;
	}

	public void invoke() {
		// TODO check thread
		UiApplication uiApplication = UiApplication.getUiApplication();
		uiApplication.invokeAndWait(new Runnable() {
			public void run() {
				Alert.startVibrate(vibrationTime);
			}
		});

	}
}
