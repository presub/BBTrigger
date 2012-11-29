package com.bb.trigger;

import net.rim.device.api.ui.UiApplication;

import com.bb.trigger.api.TriggerManager;
import com.bb.trigger.api.ui.trigger.TimeTriggerScreen;
import com.bb.trigger.ui.screens.SelectionScreen;
import com.bb.trigger.ui.screens.StartScreen;

/**
 * This class extends the UiApplication class, providing a graphical user
 * interface.
 */
public class TriggerMain extends UiApplication {
	/**
	 * Entry point for application
	 * 
	 * @param args
	 *            Command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Create a new instance of the application and make the currently
		// running thread the application's event dispatch thread.
		TriggerMain theApp = new TriggerMain();
		theApp.enterEventDispatcher();
	}

	/**
	 * Creates a new TriggerMain object
	 */
	public TriggerMain() {
		// Push a screen onto the UI stack for rendering.
		StartScreen startScreen = new StartScreen();
		startScreen.createContents();
		pushScreen(startScreen);
		TimeTriggerScreen timeTriggerScreen = new TimeTriggerScreen();
		timeTriggerScreen.createContents();
		pushScreen(timeTriggerScreen);
		TriggerManager triggerManager = new TriggerManager();
		SelectionScreen screen = new SelectionScreen(triggerManager, "Triggers");
		screen.createContents();
		pushScreen(screen);
	}

	/**
	 * Send app to background
	 */
	public boolean requestClose() {
		return false;
	}
}
