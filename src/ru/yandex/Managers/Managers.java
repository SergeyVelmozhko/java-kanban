package ru.yandex.Managers;

public class Managers {
    public InMemoryTaskManager getDefault(){
        return new InMemoryTaskManager();
    }
}
