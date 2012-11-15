package com.bb.trigger.ui.screens;

import com.bb.trigger.api.ui.IDataProvider;
import com.bb.trigger.api.ui.ILabelProvider;
import com.bb.trigger.ui.widgets.ListStyleButtonField;
import com.bb.trigger.ui.widgets.ListStyleButtonSet;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.container.VerticalFieldManager;

/**
 * Screen for..
 */
public class SelectionScreen extends AbstractScreen {
	
	private Bitmap pointer = Bitmap
			.getBitmapResource("button_right_black_15x22");
	private IDataProvider provider;

	public SelectionScreen(IDataProvider provider) {
		this.provider = provider;
	}

	protected void createScreenContents(VerticalFieldManager manager) {
		ListStyleButtonSet buttonSet = new ListStyleButtonSet();
		ILabelProvider[] data = provider.getData();
		for (int i = 0; i < data.length; i++) {
			final ILabelProvider provider = data[i];
			ListStyleButtonField link = new ListStyleButtonField(
					provider.getName(),provider.getDescription(), pointer);
			link.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					//pushScreen(provider);
				}
			});
			buttonSet.add(link);
		}
		manager.add(buttonSet);
	}
}
