package com.bb.trigger.ui.style;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.decor.BackgroundFactory;

public class AppStyle implements IApplicationStyle {

	public LabelField getTitleBar(String titleBarMessage) {
		LabelField titleBar = new LabelField(titleBarMessage,
				Field.USE_ALL_WIDTH | Field.FIELD_HCENTER);
		titleBar.setBackground(BackgroundFactory
				.createLinearGradientBackground(Color.BLUE, Color.CADETBLUE,
						Color.CADETBLUE, Color.BLUE));
		titleBar.setPadding(10, 5, 10, 0);
		return titleBar;
	}

	public int getDefaultHorizontalMargin() {
		return (int) (Display.getWidth() * (0.1));
	}
}
