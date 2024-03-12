import java.util.HashMap;

public class TaskManager {
    private static int numberOfId = 0;
    HashMap<Integer, Task> tasks;
    HashMap<Integer, Epic> epics;
    HashMap<Integer, Subtask> subtasks;

    // Получение списка задач
    public void arrayAllTask() {
        if (!tasks.isEmpty())
            System.out.println(tasks.toString());
        if (!epics.isEmpty())
            System.out.println(epics.toString());
        if (!subtasks.isEmpty())
            System.out.println(subtasks.toString());
    }

    //Удаление всех задач
    public void deleteTask() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    //Получение по идентификатору
    public String getObjectById(int id) {
        if (tasks.containsKey(id)) {
            return tasks.toString();
        } else if (epics.containsKey(id)) {
            return epics.toString();
        } else if (subtasks.containsKey(id)) {
            return subtasks.toString();
        } else
            return "Нет задачи с таким номером";
    }

    //Создание
    public void addTask(Task object) {
        tasks = new HashMap<>();
        tasks.put(object.id, object);
    }

    public void addEpic(Epic object) {
        epics = new HashMap<>();
        epics.put(object.id, object);
    }

    public void addSudtask(Subtask object) {
        subtasks = new HashMap<>();
        subtasks.put(object.id, object);
    }

    //Обновление
    public void updateTask(Task task1, Status status) {
        if (tasks.containsKey(task1.id)) {
            tasks.put(task1.id, task1);
            task1.status = status;
        } else {
            System.out.println("Не найдена задача");
        }
    }

    public void updateEpic(Epic epic1) {
        if (epics.containsKey(epic1.id)) {
            epics.put(epic1.id, epic1);
            if (!subtasks.containsKey(epic1.id) || (subtasks.containsKey(epic1.id) && subtasks.containsValue(Status.NEW))) {
                epic1.status = Status.NEW;
            } else if (subtasks.containsKey(epic1.id) && subtasks.containsValue(Status.DONE)) {
                epic1.status = Status.DONE;
            } else
                epic1.status = Status.IN_PROGRESS;
        } else {
            System.out.println("Не найдена задача");
        }
    }

    public void updateSubtask(Subtask subtask1, Status status) {
        if (subtasks.containsKey(subtask1.id)) {
            subtasks.put(subtask1.id, subtask1);
            subtask1.status = status;
        } else {
            System.out.println("Не найдена задача");
        }
    }

    //Удаление по идентификатору
    public void removeById(int id) {
        if (tasks.containsKey(id))
            tasks.remove(id);
        if (epics.containsKey(id))
            epics.remove(id);
        if (subtasks.containsKey(id))
            subtasks.remove(id);
        else
            System.out.println("Нет задачи с данным ID: " + id);
    }

    //Получение списка всех подзадач определённого эпика
    public void getSudtaskByEpic(Epic epic) {
        if (subtasks.containsKey(epic.id)) {
            System.out.println(subtasks);
        }
    }

    public static int setNumberOfId() {
        return ++numberOfId;
    }


}
