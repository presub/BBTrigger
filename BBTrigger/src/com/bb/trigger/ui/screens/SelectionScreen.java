package com.bb.trigger.ui.screens;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.api.IDataProvider;
import com.bb.trigger.api.IObjectProxy;
import com.bb.trigger.ui.widgets.ListStyleButtonField;
import com.bb.trigger.ui.widgets.ListStyleButtonSet;

/**
 * Screen for..
 */
public class SelectionScreen extends AbstractScreen {

	private Bitmap pointer = Bitmap
			.getBitmapResource("button_right_black_15x22");
	private IDataProvider provider;
	private String title;

	public SelectionScreen(IDataProvider provider, String title) {
		this.provider = provider;
		this.title = title;
	}

	protected void createScreenContents(VerticalFieldManager manager) {
		manager.add(new LabelField(title));

		ListStyleButtonSet buttonSet = new ListStyleButtonSet();
		IObjectProxy[] data = provider.getProxies();
		for (int i = 0; i < data.length; i++) {
			final IObjectProxy provider = data[i];
			ListStyleButtonField link = new ListStyleButtonField(
					provider.getName(), provider.getDescription(), pointer);
			link.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					// pushScreen(provider);
				}
			});
			buttonSet.add(link);
		}
		manager.add(buttonSet);
	}
}
