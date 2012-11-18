package com.bb.trigger.ui.style;

import net.rim.device.api.ui.component.LabelField;

/**
 * Interface for application styles. Implementors should change style using
 * common fields methods like <b>setFont</b> or <b>setBackground()</b>
 */
public interface IApplicationStyle {

	public LabelField getTitleBar(String titleBarMessage);

	int getDefaultHorizontalMargin();
}
