import java.util.HashMap;

public class TaskManager {
    private static int numberOfId = 0;
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();

    // Получение списка задач
    public void getAllTask() {
        if (!tasks.isEmpty())
            System.out.println(tasks.toString());
        if (!epics.isEmpty())
            System.out.println(epics.toString());
        if (!subtasks.isEmpty())
            System.out.println(subtasks.toString());
    }

    //Удаление всех задач
    public void removeTask() {
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
    public void addTask(Task task) {
        tasks.put(task.id, task);
    }

    public void addEpic(Epic epic) {
        epics.put(epic.id, epic);
    }

    public void addSudtask(Subtask subtask, Epic epic) {
        subtasks.put(epic.id, subtask);
        epic.idSubtasks.add(subtask.id);
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

    public void updateSubtask(Subtask subtask1, Status status, Epic epic) {
        if (subtasks.containsKey(epic.id)) {
            subtasks.put(epic.id, subtask1);
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
}
