package ru.yandex.managers;

import ru.yandex.tasks.Task;

public interface HistoryManager<T extends Task> {

    public void add(T task);
    public void getHistory();
}
