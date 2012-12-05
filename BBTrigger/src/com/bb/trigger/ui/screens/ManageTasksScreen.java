package com.bb.trigger.ui.screens;

import java.util.Vector;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.component.CheckboxField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.bb.trigger.api.Task;
import com.bb.trigger.excecution.ExecutionManager;
import com.bb.trigger.excecution.TaskRepository;

public class ManageTasksScreen extends AbstractScreen {

	private final TaskRepository taskRepository;
	private VerticalFieldManager checkboxManager;

	public ManageTasksScreen() {
		super();
		taskRepository = ExecutionManager.getINSTANCE().getTaskRepository();
	}

	protected void createScreenContents(VerticalFieldManager manager) {
		Vector tasks = taskRepository.getTasks();
		if (tasks.isEmpty()) {
			manager.add(new LabelField("Profile is empty. Add tasks first."));
		} else {
			checkboxManager = new VerticalFieldManager(VERTICAL_SCROLL | VERTICAL_SCROLLBAR);
			for (int i = 0; i < tasks.size(); i++) {
				checkboxManager.add(createCheckbox((Task) tasks.elementAt(i)));
			}
			manager.add(checkboxManager);
			createMenu();
		}
	}

	private CheckboxField createCheckbox(final Task task) {
		final CheckboxField checkboxField = new CheckboxField(task.getName(), task.isEnabled());
		checkboxField.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				task.setEnabled(checkboxField.getChecked());
			}
		});
		return checkboxField;
	}

	private void createMenu() {
		MenuItem delete = new MenuItem("Delete", 0, 0) {
			public void run() {
				Field leafFieldWithFocus = getManager().getLeafFieldWithFocus();
				Task task = (Task) leafFieldWithFocus.getCookie();
				taskRepository.removeTask(task);
				checkboxManager.deleteAll();
				invalidate();
			}
		};
		addMenuItem(delete);
	}

	public boolean onClose() {
		close();
		return true;
	};
}
