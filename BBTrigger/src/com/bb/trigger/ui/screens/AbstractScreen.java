package com.bb.trigger.ui.screens;

import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.Messages;
import com.bb.trigger.ui.style.IApplicationStyle;
import com.bb.trigger.ui.style.StyleManager;

/**
 * Abstract common screen with title bar and basic menu
 */
public abstract class AbstractScreen extends MainScreen {

	public AbstractScreen() {

	}

	public void createContents() {
		IApplicationStyle style = StyleManager.getStyle();
		LabelField titleBar = style.getTitleBar(getScreenTitle());
		setTitle(titleBar);
		VerticalFieldManager manager = new VerticalFieldManager();
		int defaultHorizontalMargin = style.getDefaultHorizontalMargin();
		manager.setMargin(0, defaultHorizontalMargin, 0,
				defaultHorizontalMargin);
		createScreenContents(manager);
		add(manager);
	}

	protected String getScreenTitle() {
		return Messages.getString(Messages.AppName);
	}

	protected abstract void createScreenContents(VerticalFieldManager manager);

	protected boolean onSavePrompt() {
		return false;
	}

}
