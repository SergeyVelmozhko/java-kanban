import java.util.ArrayList;

public class Epic extends Task {
    ArrayList<Integer> idSubtasks = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
