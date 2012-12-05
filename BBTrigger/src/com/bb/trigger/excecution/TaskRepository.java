package com.bb.trigger.excecution;

import java.util.Vector;

import net.rim.device.api.system.PersistentObject;
import net.rim.device.api.system.PersistentStore;
import net.rim.device.api.util.Persistable;

import com.bb.trigger.api.Task;

public class TaskRepository {

	private final long REPO_ID = 37472917499l;
	private PersistentObject persistentObject;

	private Vector tasks;

	public TaskRepository() {
		restore();
	}

	private void restore() {
		persistentObject = PersistentStore.getPersistentObject(REPO_ID);
		Object contents = persistentObject.getContents();
		if (contents instanceof Vector) {
			tasks = (Vector) contents;
		} else {
			tasks = new PersistentTaskVector();
			commit();
		}
	}

	public void addTask(Task task) {
		tasks.addElement(task);
		commit();
	}

	public void removeTask(Task task) {
		tasks.removeElement(task);
		commit();
	}

	// TODO Improve (maybe some id)
	public void editTask(Task task) {
		commit();
	}

	private void commit() {
		persistentObject.setContents(tasks);
		persistentObject.commit();
	}

	public Vector getTasks() {
		return tasks;
	}
}

// For flushing persistence store
class PersistentTaskVector extends Vector implements Persistable {
	// Intentionally empty.
}
