package com.bb.trigger.api;

import com.bb.trigger.api.action.VibrateActionDescriptor;

public class ActionManager implements IDataProvider {

	public IObjectDescriptor[] getProxies() {
		return new IObjectDescriptor[] { new VibrateActionDescriptor(),
				new VibrateActionDescriptor(), new VibrateActionDescriptor() };
	}
}
