public interface TaskManager {
    // Получение списка задач
    void getAllTask();

    //Удаление всех задач
    void removeTask();

    //Получение по идентификатору
    String getObjectById(int id);

    //Создание
    void addTask(Task task);

    void addEpic(Epic epic);

    void addSudtask(Subtask subtask, Epic epic);

    //Обновление
    void updateTask(Task task1, Status status);

    void updateEpic(Epic epic1);

    void updateSubtask(Subtask subtask1, Status status, Epic epic);

    //Удаление по идентификатору
    void removeById(int id);

    //Получение списка всех подзадач определённого эпика
    void getSudtaskByEpic(Epic epic);

    //Хранение запросов
    void getHistory();
}
