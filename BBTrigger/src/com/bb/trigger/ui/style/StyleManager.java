package com.bb.trigger.ui.style;

/**
 * Manager for styles (fonts, backgrounds etc.)
 */
public class StyleManager {

	private static final StyleManager manager = new StyleManager();
	private static AppStyle triggerStyle = new AppStyle();

	public static StyleManager getManager() {
		return manager;
	}

	/**
	 * @return default style for this application
	 */
	public static IApplicationStyle getStyle() {
		return triggerStyle;
	}

}
