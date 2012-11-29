package com.bb.trigger.api;

import com.bb.trigger.api.ui.AbstractObjectScreen;

public interface IObjectProxy {

	String getName();

	String getDescription();

	AbstractObjectScreen getScreen();
}
