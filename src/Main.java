public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task", "descTask");
        Epic epic = new Epic("Epic", "descEpic");
        Subtask subtask = new Subtask("Subtask", "descSubtask");
        subtask.id = epic.id; // подзадача эпика


        //Создание
        taskManager.addTask(task);
        taskManager.addEpic(epic);
        taskManager.addSudtask(subtask);

        // Получение списка задач
        taskManager.arrayAllTask();

        //Получение по идентификатору
        taskManager.getObjectById(1);

        //Удаление всех задач
        taskManager.deleteTask(); // Скрыто для проверки обновления

        //Обновление
        Task task1 = new Task("Task1", "descTask1");
        Epic epic1 = new Epic("Epic1", "descEpic1");
        Subtask subtask1 = new Subtask("subtask1", "descSubtask1");
        task1.setId(1);
        epic1.setId(2);
        subtask1.setId(2);
        taskManager.updateTask(task1, Status.IN_PROGRESS);
        taskManager.updateEpic(epic1);
        taskManager.updateSubtask(subtask1, Status.DONE);
        taskManager.arrayAllTask(); // проверка на обновление

        //Удаление по идентификатору
        taskManager.removeById(1);
        taskManager.arrayAllTask(); // Проверка на удаление

        //Получение списка всех подзадач определённого эпика
        taskManager.getSudtaskByEpic(epic);







    }
}
