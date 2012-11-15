package com.bb.trigger.api;

import com.bb.trigger.api.ui.AbstractTriggerScreen;
import com.bb.trigger.api.ui.ILabelProvider;

public interface ITriggerProxy extends ILabelProvider{

	AbstractTrigger getNewTrigger();

	AbstractTriggerScreen getNewTriggerScreen();

}
