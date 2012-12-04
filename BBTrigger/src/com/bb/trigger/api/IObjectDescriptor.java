package com.bb.trigger.api;

import com.bb.trigger.process.CreateTaskProcess;
import com.bb.trigger.ui.screens.AbstractObjectScreen;

public interface IObjectDescriptor {

	String getName();

	String getDescription();

	AbstractObjectScreen createScreen(CreateTaskProcess createTaskProcess);
}
