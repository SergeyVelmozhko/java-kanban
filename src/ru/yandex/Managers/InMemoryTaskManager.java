package ru.yandex.Managers;

import ru.yandex.Tasks.*;

import java.util.HashMap;

public class InMemoryTaskManager<T extends Task> implements TaskManager, HistoryManager {
    private static int numberOfId = 0;
    public HashMap<Integer, Task> tasks = new HashMap<>();
    public HashMap<Integer, Epic> epics = new HashMap<>();
    public HashMap<Integer, Subtask> subtasks = new HashMap<>();
    public InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();

    // Получение списка задач
    @Override
    public void getAllTask() {
        if (!tasks.isEmpty())
            System.out.println(tasks);
        if (!epics.isEmpty())
            System.out.println(epics);
        if (!subtasks.isEmpty())
            System.out.println(subtasks);
    }

    //Удаление всех задач
    @Override
    public void removeTask() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    //Получение по идентификатору
    @Override
    public String getObjectById(int id) {
        if (tasks.containsKey(id)) {
            add((T) tasks.get(id));
            return tasks.toString();
        } else if (epics.containsKey(id)) {
            add((T) epics.get(id));
            return epics.toString();
        } else if (subtasks.containsKey(id)) {
            add((T) subtasks.get(id));
            return subtasks.toString();
        } else
            return "Нет задачи с таким номером";
    }

    //Создание
    @Override
    public void addTask(Task task) {
        if (tasks.containsKey(task.id))
            System.out.println("Такая задача уже есть");
        else
            tasks.put(task.id, task);
    }

    @Override
    public void addEpic(Epic epic) {
        if (epics.containsKey(epic.id))
            System.out.println("Такой эпик уже есть");
        else
            epics.put(epic.id, epic);
    }

    @Override
    public void addSudtask(Subtask subtask, Epic epic) {
        if (subtasks.containsKey(subtask.id))
            System.out.println("Такая подзадача уже есть");
        else {
            subtasks.put(subtask.id, subtask);
            epic.idSubtasks.add(subtask.id);
        }
    }

    //Обновление
    @Override
    public void updateTask(Task secondTask, Status status) {
        if (tasks.containsKey(secondTask.id)) {
            tasks.put(secondTask.id, secondTask);
            secondTask.status = status;
        } else {
            System.out.println("Не найдена задача");
        }
    }

    @Override
    public void updateEpic(Epic epic1) {
        if (epics.containsKey(epic1.id)) {
            epics.put(epic1.id, epic1);
            Subtask subtask = subtasks.get(epic1.id);
            if (!subtasks.containsKey(epic1.id) || subtask.status == Status.NEW) {
                epic1.status = Status.NEW;
            } else if (subtasks.containsKey(epic1.id) && subtask.status == Status.DONE) {
                epic1.status = Status.DONE;
            } else
                epic1.status = Status.IN_PROGRESS;
        } else {
            System.out.println("Не найдена задача");
        }
    }

    @Override
    public void updateSubtask(Subtask subtask1, Status status, Epic epic) {
        if (subtasks.containsKey(epic.id)) {
            subtasks.put(epic.id, subtask1);
            subtask1.status = status;
        } else {
            System.out.println("Не найдена задача");
        }
    }

    //Удаление по идентификатору
    @Override
    public void removeById(int id) {
        if (tasks.containsKey(id))
            tasks.remove(id);
        else if (epics.containsKey(id))
            epics.remove(id);
        else if (subtasks.containsKey(id))
            subtasks.remove(id);
        else
            System.out.println("Нет задачи с данным ID: " + id);
    }

    //Получение списка всех подзадач определённого эпика
    @Override
    public void getSudtaskByEpic(Epic epic) {
        for (Subtask el : subtasks.values()) {
            for (int i : epic.idSubtasks) {
                if (subtasks.containsKey(i)) {
                    el = subtasks.get(i);
                    System.out.println(el);
                }
            }
        }
    }

    public static int setNumberOfId() {
        return ++numberOfId;
    }

    @Override
    public void add(Task task) {
        if (inMemoryHistoryManager.history.size()<10) {
            inMemoryHistoryManager.history.add((T) task);
        } else {
            inMemoryHistoryManager.history.remove(0);
            inMemoryHistoryManager.history.add((T) task);
        }
    }

    @Override
    public void getHistory() {
        System.out.println(inMemoryHistoryManager.history);
    }
}
