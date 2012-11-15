package com.bb.trigger.api;

import com.bb.trigger.api.trigger.TimeTrigerProxy;
import com.bb.trigger.api.ui.IDataProvider;
import com.bb.trigger.api.ui.ILabelProvider;

public class TriggerManager implements IDataProvider {
	public ILabelProvider[] getData() {
		return new ILabelProvider[] { new TimeTrigerProxy(),
				new TimeTrigerProxy(), new TimeTrigerProxy() };
	}
}
