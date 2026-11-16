package edu.course.lab03;

public class ProjectTask {
    private final String id;
    private final int estimatedHours;
    private final boolean completed;

    public ProjectTask(String id, int estimatedHours, boolean completed) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException();
        if (estimatedHours < 0) throw new IllegalArgumentException();
        this.id = id;
        this.estimatedHours = estimatedHours;
        this.completed = completed;
    }

    public int getEstimatedHours() { return estimatedHours; }
    public boolean isCompleted() { return completed; }
    public String getId() { return id; }
}