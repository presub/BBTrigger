/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.bb.trigger.ui.screens;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.Messages;
import com.bb.trigger.messages.MessagesResource;
import com.bb.trigger.process.CreateTaskProcess;

public abstract class AbstractObjectScreen extends AbstractScreen {

	private final String title;
	private final CreateTaskProcess createTaskProcess;

	public AbstractObjectScreen(String title,
			CreateTaskProcess createTaskProcess) {
		this.title = title;
		this.createTaskProcess = createTaskProcess;
	}

	protected void createScreenContents(VerticalFieldManager manager) {
		createSubPageContents(manager);
		String buttonMessage = Messages.getString(MessagesResource.Button_Next);
		ButtonField nextButton = new ButtonField(buttonMessage, USE_ALL_WIDTH);
		nextButton.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				processNextScreen();
			}
		});
		manager.add(nextButton);
	}

	protected abstract void processNextScreen();

	protected abstract void createSubPageContents(VerticalFieldManager manager);

	protected String getScreenTitle() {
		return title;
	}

	public CreateTaskProcess getProcess() {
		return createTaskProcess;
	}
}
