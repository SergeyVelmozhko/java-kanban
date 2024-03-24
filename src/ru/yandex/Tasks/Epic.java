package ru.yandex.Tasks;

import java.util.ArrayList;

public class Epic extends Task {
    public ArrayList<Integer> idSubtasks = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "ru.yandex.Tasks.Epic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
