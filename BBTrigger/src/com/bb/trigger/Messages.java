package com.bb.trigger;

import net.rim.device.api.i18n.MissingResourceException;
import net.rim.device.api.i18n.ResourceBundle;

import com.bb.trigger.messages.MessagesResource;

public class Messages implements MessagesResource {

	private static ResourceBundle _resources = ResourceBundle.getBundle(
			BUNDLE_ID, BUNDLE_NAME);
	private static final String MISSING_RESOURCE = "NLS:MISSING_KEY";

	public static String getString(int key) {
		try {
			return _resources.getString(key);
		} catch (MissingResourceException e) {
			return MISSING_RESOURCE;
		}
	}
}
