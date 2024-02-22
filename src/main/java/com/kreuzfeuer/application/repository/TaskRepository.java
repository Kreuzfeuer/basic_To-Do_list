package com.kreuzfeuer.application.repository;

import com.kreuzfeuer.application.model.Task;


import java.util.LinkedList;
import java.util.List;

public class TaskRepository {


    private final List<Task> taskList;

    public TaskRepository() {
        this.taskList = new LinkedList<>();
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public Task getTask(int number) {
        return taskList.get(number);
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public Task deleteTask(int number) {
        return taskList.remove(number);
    }

    public Task updateStatus(int number) {
        var task = taskList.get(number);
        task.setStatus(true);
        return task;
    }

    public int sizeList() {
        return taskList.size();
    }
}
