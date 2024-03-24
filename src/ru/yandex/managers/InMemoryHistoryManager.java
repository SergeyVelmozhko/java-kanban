package ru.yandex.managers;

import ru.yandex.tasks.Task;

import java.util.ArrayList;

public class InMemoryHistoryManager<T extends Task> implements HistoryManager{
    ArrayList<T> history = new ArrayList<>();
    @Override
    public void add(Task task) {
        if (history.size()<10) {
            history.add((T) task);
        } else {
            history.remove(0);
            history.add((T) task);
        }
    }

    @Override
    public void getHistory() {
        System.out.println(history);
    }
}

