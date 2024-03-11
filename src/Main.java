public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");
        TaskManager taskManager = new TaskManager();
        Task task = new Task("222","222");
        taskManager.addTask(task);
        Task newTask = taskManager.getTask(1);


        Subtask subtask = new Subtask("Задача1", "Переезд1");
        Subtask subtaskA = new Subtask("Задача2", "Переезд2");
        System.out.println(subtaskA.name);
        Epic epic = new Epic("Задача3", "Переезд3");
        epic.setSubtasks(subtaskA);
        epic.setSubtasks(subtask);
        System.out.println(epic.toString());
        epic.setStatus(Status.IN_PROGRESS);
        System.out.println(epic.toString());

        taskManager.tasks.add(epic);
        System.out.println(taskManager.toString());
        taskManager.tasksDelete();
        System.out.println(taskManager.toString());
    }
}
