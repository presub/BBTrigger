package com.bb.trigger.ui.screens;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.api.IDataProvider;
import com.bb.trigger.api.IObjectDescriptor;
import com.bb.trigger.process.CreateTaskProcess;
import com.bb.trigger.ui.widgets.ListStyleButtonField;
import com.bb.trigger.ui.widgets.ListStyleButtonSet;

/**
 * Screen for selecting triggers or actions
 */
public class ObjectSelectionScreen extends AbstractScreen {

	private final Bitmap pointer = Bitmap.getBitmapResource("button_right.png");
	private final IDataProvider provider;
	private final String title;

	private final CreateTaskProcess createTaskProcess;

	public ObjectSelectionScreen(CreateTaskProcess createTaskProcess,
			IDataProvider provider, String title) {
		this.createTaskProcess = createTaskProcess;
		this.provider = provider;
		this.title = title;
	}

	protected void createScreenContents(VerticalFieldManager manager) {
		manager.add(new LabelField(title));
		ListStyleButtonSet buttonSet = new ListStyleButtonSet();
		IObjectDescriptor[] data = provider.getProxies();
		for (int i = 0; i < data.length; i++) {
			final IObjectDescriptor provider = data[i];
			ListStyleButtonField link = new ListStyleButtonField(
					provider.getName(), provider.getDescription(), pointer);
			link.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					UiApplication.getUiApplication().invokeAndWait(
							new Runnable() {
								public void run() {
									createTaskProcess
											.showObjectScreen(provider);
								}
							});
				}
			});
			buttonSet.add(link);
		}
		manager.add(buttonSet);
	}
}
