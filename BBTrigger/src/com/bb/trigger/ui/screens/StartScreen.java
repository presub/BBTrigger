package com.bb.trigger.ui.screens;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.process.CreateTaskProcess;
import com.bb.trigger.process.IProcess;
import com.bb.trigger.ui.widgets.HorizontalButtonFieldSet;

/**
 * Main screen for this application.
 */
public class StartScreen extends AbstractScreen {

	public StartScreen() {

	}

	protected void createScreenContents(VerticalFieldManager manager) {
		createConfiguration(manager);
		manager.add(new SeparatorField());
		createOptions(manager);
		manager.add(new SeparatorField());
		createExcecution(manager);
		manager.add(new SeparatorField());
		createLifeCycle(manager);
	}

	private void createConfiguration(VerticalFieldManager manager) {
		LabelField configurationLabel = new LabelField("Configuration");
		manager.add(configurationLabel);

		HorizontalButtonFieldSet configurationButtonManager = new HorizontalButtonFieldSet(
				USE_ALL_WIDTH);
		ButtonField addButton = new ButtonField("Add Task", FIELD_HCENTER);
		addButton.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				IProcess process = new CreateTaskProcess();
				process.run();
			}
		});
		configurationButtonManager.add(addButton);
		ButtonField editProfileButton = new ButtonField("Edit Profile",
				FIELD_HCENTER);
		configurationButtonManager.add(editProfileButton);
		manager.add(configurationButtonManager);
	}

	private void createExcecution(VerticalFieldManager manager) {
		LabelField excecutionLabel = new LabelField("Excecution");
		manager.add(excecutionLabel);
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
		manager.add(excecutionButtonManager);
	}

	private void createLifeCycle(VerticalFieldManager manager) {
		LabelField lifeCycleLabel = new LabelField("Lifecycle");
		manager.add(lifeCycleLabel);

		HorizontalButtonFieldSet lifecycleManager = new HorizontalButtonFieldSet(
				USE_ALL_WIDTH);

		ButtonField hideApp = new ButtonField("Hide app", FIELD_HCENTER);
		hideApp.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				UiApplication.getUiApplication().requestBackground();
			}
		});
		lifecycleManager.add(hideApp);
		ButtonField closeApp = new ButtonField("Close app", FIELD_HCENTER);
		closeApp.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				System.exit(0);
			}
		});
		lifecycleManager.add(closeApp);
		manager.add(lifecycleManager);
	}

	private void createOptions(VerticalFieldManager manager) {
		LabelField configurationLabel = new LabelField("Options");
		manager.add(configurationLabel);
		HorizontalButtonFieldSet optionsManager = new HorizontalButtonFieldSet(
				USE_ALL_WIDTH);
		ButtonField settingsButton = new ButtonField("Settings", FIELD_HCENTER);
		optionsManager.add(settingsButton);

		ButtonField info = new ButtonField("About", FIELD_HCENTER);
		info.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				InfoScreen infoScreen = new InfoScreen();
				infoScreen.createContents();
				UiApplication.getUiApplication().pushScreen(infoScreen);
			}
		});
		optionsManager.add(info);
		manager.add(optionsManager);
	}

}
