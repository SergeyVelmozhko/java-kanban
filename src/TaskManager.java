import java.util.HashMap;

public class TaskManager {
    private static int numberOfId = 0;
    HashMap<Integer, Task> task;
    HashMap<Integer, Epic> epic;
    HashMap<Integer, Subtask> subtask;

    // Получение списка задач
    public void arrayAllTask() {
        if (!task.isEmpty())
            System.out.println(task.toString());
        if (!epic.isEmpty())
            System.out.println(epic.toString());
        if (!subtask.isEmpty())
            System.out.println(subtask.toString());
    }

    //Удаление всех задач
    public void deleteTask() {
        task.clear();
        epic.clear();
        subtask.clear();
    }

    //Получение по идентификатору
    public String getObjectById(int id) {
        if (task.containsKey(id)) {
            return task.toString();
        } else if (epic.containsKey(id)) {
            return epic.toString();
        } else if (subtask.containsKey(id)) {
            return subtask.toString();
        } else
            return "Нет задачи с таким номером";
    }

    //Создание
    public void addTask(Task object) {
        task = new HashMap<>();
        task.put(object.id, object);
    }

    public void addEpic(Epic object) {
        epic = new HashMap<>();
        epic.put(object.id, object);
    }

    public void addSudtask(Subtask object) {
        subtask = new HashMap<>();
        subtask.put(object.id, object);
    }

    //Обновление
    public void updateTask(Task task1, Status status) {
        if (task.containsKey(task1.id)) {
            task.put(task1.id, task1);
            task1.status = status;
        } else {
            System.out.println("Не найдена задача");
        }
    }

    public void updateEpic(Epic epic1) {
        if (epic.containsKey(epic1.id)) {
            epic.put(epic1.id, epic1);
            if (!subtask.containsKey(epic1.id) || (subtask.containsKey(epic1.id) && subtask.containsValue(Status.NEW))) {
                epic1.status = Status.NEW;
            } else if (subtask.containsKey(epic1.id) && subtask.containsValue(Status.DONE)) {
                epic1.status = Status.DONE;
            } else
                epic1.status = Status.IN_PROGRESS;
        } else {
            System.out.println("Не найдена задача");
        }
    }

    public void updateSubtask(Subtask subtask1, Status status) {
        if (subtask.containsKey(subtask1.id)) {
            subtask.put(subtask1.id, subtask1);
            subtask1.status = status;
        } else {
            System.out.println("Не найдена задача");
        }
    }

    //Удаление по идентификатору
    public void removeById(int id) {
        if (task.containsKey(id))
            task.remove(id);
        if (epic.containsKey(id))
            epic.remove(id);
        if (subtask.containsKey(id))
            subtask.remove(id);
        else
            System.out.println("Нет задачи с данным ID: " + id);
    }

    //Получение списка всех подзадач определённого эпика
    public void getSudtaskByEpic(Epic epic) {
        if (subtask.containsKey(epic.id)) {
            System.out.println(subtask);
        }
    }

    public static int setNumberOfId() {
        return ++numberOfId;
    }


}
