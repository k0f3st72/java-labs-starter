package edu.course.lab02;

public class ProjectTask {

    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, int estimatedHours) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Идентификатор не может быть пустым.");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Заголовок не может быть пустым.");
        }
        if (estimatedHours < 0) {
            throw new IllegalArgumentException("расчетное количество часов не может быть отрицательным.");
        }
        this.id = id;
        this.title = title;
        this.status = TaskStatus.NEW;
        this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("статус не может быть пустым");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return this.status == TaskStatus.DONE;
    }

    public void increaseEstimate(int extraHours) {
        if (extraHours <= 0) {
            throw new IllegalArgumentException("Дополнительные часы должны приносить пользу.");
        }
        this.estimatedHours += extraHours;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public TaskStatus getStatus() { return status; }
    public int getEstimatedHours() { return estimatedHours; }
}