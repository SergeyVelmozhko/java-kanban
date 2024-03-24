package ru.yandex.tasks;

import ru.yandex.managers.InMemoryTaskManager;

public class Task {
    String name;
    String description;
    public int id;

    public Status status;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = InMemoryTaskManager.setNumberOfId();
        status = Status.NEW;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ru.yandex.Tasks.Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
