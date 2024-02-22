package com.kreuzfeuer.application.service;

import com.kreuzfeuer.application.model.Task;
import com.kreuzfeuer.application.repository.TaskRepository;

import java.util.List;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getTaskList() {
        return repository.getTaskList();
    }

    public Task getTask(int number) {
        return repository.getTask(number);
    }

    public void addTask(String name) {
        Task task = new Task(name);
        repository.addTask(task);
    }

    public Task deleteTask(int number) {
        return repository.deleteTask(number);
    }

    public Task updateStatus(int number) {

        return repository.updateStatus(number);
    }

    public int numberOfTasks() {
        return repository.sizeList();
    }
}
