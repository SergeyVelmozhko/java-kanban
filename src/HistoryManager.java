public interface HistoryManager<T extends Task> {

    public void add(T task);
    public void getHistory();
}
