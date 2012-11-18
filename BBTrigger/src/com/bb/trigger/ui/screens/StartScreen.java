package com.bb.trigger.ui.screens;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.ui.widgets.HorizontalButtonFieldSet;

public class StartScreen extends AbstractScreen {

	ButtonField addButton;
	ButtonField editProfileButton;
	private ButtonField settingsButton;

	LabelField descriptionLabel;

	public StartScreen() {
	}

	protected void createScreenContents(VerticalFieldManager manager) {
		// Configuration element
		LabelField configurationLabel = new LabelField("Configuration");
		manager.add(configurationLabel);

		HorizontalButtonFieldSet configurationButtonManager = new HorizontalButtonFieldSet(
				USE_ALL_WIDTH);
		addButton = new ButtonField("Add new Task", FIELD_HCENTER);
		configurationButtonManager.add(addButton);
		editProfileButton = new ButtonField("Edit Profile", FIELD_HCENTER);
		configurationButtonManager.add(editProfileButton);
		settingsButton = new ButtonField("Settings", FIELD_HCENTER);
		configurationButtonManager.add(settingsButton);
		manager.add(configurationButtonManager);
		descriptionLabel = new LabelField("Profile tasks:", USE_ALL_WIDTH
				| FIELD_HCENTER);

		add(new SeparatorField());
		LabelField excecutionLabel = new LabelField("Excecution");
		manager.add(excecutionLabel);
		// Excecution
		HorizontalButtonFieldSet excecutionButtonManager = new HorizontalButtonFieldSet(
				USE_ALL_WIDTH);
		ButtonField showLog = new ButtonField("Log", FIELD_HCENTER);
		showLog.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				LogScreen logScreen = new LogScreen();
				logScreen.createContents();
				UiApplication.getUiApplication().pushScreen(logScreen);
			}
		});
		excecutionButtonManager.add(showLog);
		ButtonField info = new ButtonField("About", FIELD_HCENTER);
		info.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				InfoScreen infoScreen = new InfoScreen();
				infoScreen.createContents();
				UiApplication.getUiApplication().pushScreen(infoScreen);
			}
		});
		excecutionButtonManager.add(info);
		ButtonField hideApp = new ButtonField("Hide application", FIELD_HCENTER);
		hideApp.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				UiApplication.getUiApplication().requestBackground();
			}
		});
		excecutionButtonManager.add(hideApp);
		manager.add(excecutionButtonManager);
	}
}
