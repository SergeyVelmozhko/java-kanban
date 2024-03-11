import java.util.ArrayList;
import java.util.Objects;

public class TaskManager {
    private static int numberOfId = 0;
    ArrayList<Object> tasks = new ArrayList<>();


    // Получение списка задач
    @Override
    public String toString() {
        return "TaskManager{" +
                "tasks=" + tasks +
                '}';
    }

    //Удаление всех задач
    public void tasksDelete () {
       tasks.clear();
    }

    //Получение по идентификатору
    public Object getId(int id) {
        for (Object obj: tasks) {
            if (obj.equals(id)) return obj;
        }
        return null;
    }




    public static int getNumberOfId() {
        return numberOfId;
    }

    public static int setNumberOfId() {
        return ++numberOfId;
    }
}
