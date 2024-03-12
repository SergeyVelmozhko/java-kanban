public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task", "descTask");
        Epic epic = new Epic("Epic", "descEpic");
        Subtask subtask = new Subtask("Subtask", "descSubtask", epic);



        //Создание
        taskManager.addTask(task);
        taskManager.addEpic(epic);
        taskManager.addSudtask(subtask, epic);

//        // Получение списка задач
//        taskManager.getAllTask();
//
//        //Получение по идентификатору
//        taskManager.getObjectById(1);
//
//        //Удаление всех задач
//        taskManager.removeTask(); // Скрыто для проверки обновления
//
//        //Обновление
//        Task task1 = new Task("Task1", "descTask1");
//        Epic epic1 = new Epic("Epic1", "descEpic1");
//        Subtask subtask1 = new Subtask("subtask1", "descSubtask1", epic);
//
//        taskManager.updateTask(task1, Status.IN_PROGRESS);
//        taskManager.updateEpic(epic1);
//        taskManager.updateSubtask(subtask1, Status.DONE, epic);
//        taskManager.getAllTask(); // проверка на обновление
//
//        //Удаление по идентификатору
//        taskManager.removeById(1);
//        taskManager.getAllTask(); // Проверка на удаление
//
//        //Получение списка всех подзадач определённого эпика
//        taskManager.getSudtaskByEpic(epic);







    }
}
