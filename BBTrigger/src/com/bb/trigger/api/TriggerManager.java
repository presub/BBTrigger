package com.bb.trigger.api;

import com.bb.trigger.api.trigger.TimeTrigerDescriptor;

public class TriggerManager implements IDataProvider {

	public IObjectDescriptor[] getProxies() {
		return new IObjectDescriptor[] { new TimeTrigerDescriptor(),
				new TimeTrigerDescriptor(), new TimeTrigerDescriptor() };
	}
}
