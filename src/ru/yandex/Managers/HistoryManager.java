package ru.yandex.Managers;

import ru.yandex.Tasks.Task;

public interface HistoryManager<T extends Task> {

    public void add(T task);
    public void getHistory();
}
