package com.bb.trigger.ui.screens;

import net.rim.device.api.browser.field2.BrowserField;
import net.rim.device.api.browser.field2.BrowserFieldConfig;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class InfoScreen extends AbstractScreen {

	BrowserField info;

	protected void createScreenContents(VerticalFieldManager manager) {
		BrowserFieldConfig myBrowserFieldConfig = new BrowserFieldConfig();
		myBrowserFieldConfig.setProperty(BrowserFieldConfig.NAVIGATION_MODE,
				BrowserFieldConfig.NAVIGATION_MODE_POINTER);
		info = new BrowserField(myBrowserFieldConfig);

		add(info);
		info.requestContent("local:///info.html");
	}

}
