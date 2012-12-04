package com.bb.trigger.process;

import java.util.Vector;

import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.UiApplication;

public abstract class AbstractProcess implements IProcess {

	private final Vector processScreens = new Vector();

	protected final void pushScreen(final Screen screen) {
		processScreens.addElement(screen);
		UiApplication.getUiApplication().invokeAndWait(new Runnable() {
			public void run() {
				UiApplication.getUiApplication().pushScreen(screen);
			}
		});
	}

	protected final void popScreens() {
		UiApplication.getUiApplication().invokeAndWait(new Runnable() {
			public void run() {
				for (int i = 0; i < processScreens.size(); i++) {
					UiApplication.getUiApplication().popScreen(
							(Screen) processScreens.elementAt(i));
				}
			}
		});
	}
}
