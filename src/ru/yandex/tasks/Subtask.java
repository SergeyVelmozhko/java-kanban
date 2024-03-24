package ru.yandex.tasks;

public class Subtask extends Task {
    int idEpic;
    public Subtask(String name, String description, Epic epic) {
        super(name, description);
        this.idEpic = epic.id;
    }

    @Override
    public String toString() {
        return "ru.yandex.Tasks.Subtask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
