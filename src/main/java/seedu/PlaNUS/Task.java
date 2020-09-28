package seedu.PlaNUS;

public class Task {
    protected String description;
    protected String date;
    protected String time;
    protected String priority;

    public Task(String description, String date, String time, String priority) {
        this.description = description;
        this.date = date;
        this.time = time;
        this.priority = priority;
    }

    public String toString() {
        return description + " " + date + " " + time + " " + priority;
    }
}
