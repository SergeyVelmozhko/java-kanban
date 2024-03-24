package ru.yandex.managers;

public class Managers {
    public InMemoryTaskManager getDefault(){
        return new InMemoryTaskManager();
    }
}
