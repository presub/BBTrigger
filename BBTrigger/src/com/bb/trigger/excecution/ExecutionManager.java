package com.bb.trigger.excecution;

import java.util.Vector;

import com.bb.trigger.api.Task;

/**
 * Manager for a task executions
 */
public class ExecutionManager {

	private final static ExecutionManager INSTANCE = new ExecutionManager();
	private final TaskRepository taskRepository;
	private final ExecutionLog log = new ExecutionLog();

	private ExecutionManager() {
		taskRepository = new TaskRepository();
		start();
	}

	private void start() {
		Thread thread = new Thread("BBTrigger - Execution Thread") {
			public void run() {
				Vector tasks = taskRepository.getTasks();
				for (int i = 0; i < tasks.size(); i++) {
					Task task = (Task) tasks.elementAt(i);
					task.getTrigger().initTrigger();

				}
			}
		};
		thread.start();
	}

	public static ExecutionManager getINSTANCE() {
		return INSTANCE;
	}

	public TaskRepository getTaskRepository() {
		return taskRepository;
	}

	public ExecutionLog getLog() {
		return log;
	}
}
