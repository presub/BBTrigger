package com.bb.trigger.api;

import com.bb.trigger.api.trigger.TimeTrigerProxy;

public class TriggerManager implements IDataProvider {

	public IObjectProxy[] getProxies() {
		return new IObjectProxy[] { new TimeTrigerProxy(),
				new TimeTrigerProxy(), new TimeTrigerProxy() };
	}
}
