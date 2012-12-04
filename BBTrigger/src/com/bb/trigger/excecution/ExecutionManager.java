package com.bb.trigger.excecution;


public class ExecutionManager {

	private final TaskRepository taskRepository;
	private final static ExecutionManager INSTANCE = new ExecutionManager();

	private ExecutionManager() {
		taskRepository = new TaskRepository();
	}

	public ExecutionManager getINSTANCE() {
		return INSTANCE;
	}

	public TaskRepository getTaskRepository() {
		return taskRepository;
	}

}
