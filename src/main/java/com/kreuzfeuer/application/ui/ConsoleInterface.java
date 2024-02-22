package com.kreuzfeuer.application.ui;

import com.kreuzfeuer.application.model.Task;
import com.kreuzfeuer.application.repository.TaskRepository;
import com.kreuzfeuer.application.service.TaskService;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    private final TaskService service;
    private final Scanner sc;

    private static final String INVALID_INPUT = "Неверные вводимые данные!";

    public ConsoleInterface(Scanner sc) {
        this.service = new TaskService(new TaskRepository());
        this.sc = sc;
    }

    public void start() {
        System.out.println("Добро пожаловать в приложение To-Do List!");
        System.out.println("1. Добавить новую задачу\n" + "2. Просмотреть список задач\n" + "3. Отметить задачу как выполненную\n" + "4. Удалить задачу\n" + "5. Выход ");
        boolean repeat = true;
        do {
            System.out.print("Выберите действие (введите номер): ");

            int buf = 0;
            try {
                buf = Integer.parseInt(sc.nextLine());
            } catch (IllegalArgumentException ex) {
                System.out.println(INVALID_INPUT);
                continue;
            }
            switch (buf) {
                case 1 -> {
                    System.out.print("Введите описание задачи: ");
                    String name = sc.nextLine();
                    if (name.isBlank()) {
                        System.out.println(INVALID_INPUT);
                        continue;
                    }
                    service.addTask(name);
                }
                case 2 -> {

                    List<Task> list = service.getTaskList();
                    if (list.isEmpty()) {
                        System.out.println("Список задач: (пусто)");
                    }
                    System.out.println("Список задач:");
                    int i = 1;
                    for (var task : list) {
                        System.out.println(i++ + ". " + task.getFullDescription());
                    }
                }
                case 3 -> {
                    System.out.print("Введите номер задачи для отметки как выполненной: ");
                    try {
                        int parseInt = Integer.parseInt(sc.nextLine()) - 1;
                        if (parseInt < 0 || parseInt >= service.numberOfTasks()) {
                            throw new IllegalArgumentException("Invalid input");
                        }
                        Task task = service.updateStatus(parseInt);
                        System.out.println("Задача \"" + task.getName() + "\" выполнена.");
                    } catch (IllegalArgumentException ex) {
                        System.out.println(INVALID_INPUT);
                    }
                }
                case 4 -> {
                    System.out.print("Введите номер задачи для удаления: ");
                    try {
                        int parseInt = Integer.parseInt(sc.nextLine()) - 1;
                        if (parseInt < 0 || parseInt >= service.numberOfTasks()) {
                            throw new IllegalArgumentException("Invalid input");
                        }
                        Task task = service.deleteTask(parseInt);
                        System.out.println("Задача \"" + task.getName() + "\" удалена.");
                    } catch (IllegalArgumentException ex) {
                        System.out.println(INVALID_INPUT);
                    }
                }

                case 5 -> {
                    System.out.println("До свидания!");
                    repeat = false;
                }
                default -> System.out.println(INVALID_INPUT);
            }

        } while (repeat);
    }

}
