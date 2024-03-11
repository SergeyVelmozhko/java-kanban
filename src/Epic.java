import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Epic extends Task {
    ArrayList<Subtask> subtasks = new ArrayList<>();
    public Epic(String name, String description) {
        super(name, description);
    }


    public void setSubtasks(Subtask subtask) {
        subtasks.add(subtask);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtasks=" + Arrays.toString(new ArrayList[]{subtasks}) +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
