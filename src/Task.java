public class Task {
    String name;
    String description;
    int id;


    public Status status;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = TaskManager.setNumberOfId();
        status = Status.NEW;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
